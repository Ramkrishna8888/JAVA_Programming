import java.util.*;

// practice custom exceptions

class InvalidCredentialsException extends Exception {
    InvalidCredentialsException(String excep) {
        super(excep);
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String excep) {
        super(excep);
    }
}

class ActManager {

    HashMap<String, String> userDetail = new HashMap<>();
    double currentAmount = 1000;
    void registerUser(String username, String password) throws InvalidCredentialsException {
        String userPattern = "^[a-zA-Z0-9_]{6,}$";
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%&*])[A-Za-z0-9@!#%&*]{8,}$";

        if (username.matches(userPattern) && password.matches(passwordPattern)) {
            userDetail.put(username, password);
        } else {
            throw new InvalidCredentialsException("Invalid Credentials");
        }
    }

    double deposit(String username, double amount) throws InvalidCredentialsException {
        if (amount > 0 && amount <= 10000) {
            if (userDetail.containsKey(username)) {
                currentAmount += amount;
                return currentAmount;
            } else {
                throw new InvalidCredentialsException("Invalid username");
            }
        } else {
            throw new InvalidCredentialsException("Amount should not be negative");
        }
    }

    double withdraw(String username, double amount) throws InsufficientFundsException {
        if (amount > 0 && amount <= currentAmount) {
            if (userDetail.containsKey(username)) {
                System.out.println("Withdraw successful");
                currentAmount -= amount;
                return currentAmount;
            }
        } else {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        return currentAmount;
    }

    void checkBalance(String username) throws InvalidCredentialsException {
        if (userDetail.containsKey(username)) {
            System.out.println("Current Balance: $" + currentAmount);
        } else {
            throw new InvalidCredentialsException("Invalid credentials");
        }
    }
}

public class BankingApplicationException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ActManager manager = new ActManager();

        try {
            System.out.print("Enter Username: ");
            String username = sc.next();
            System.out.print("Enter Password: ");
            String password = sc.next();

            manager.registerUser(username, password);
            System.out.println("Registration Successful!");

            while (true) {
                System.out.println("\nChoose an Option:\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
                System.out.print("Enter Option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = sc.nextDouble();
                        try {
                            double newBalance = manager.deposit(username, depositAmount);
                            System.out.println("Deposit Successful. New Balance: $" + newBalance);
                        } catch (InvalidCredentialsException e) {
                            System.err.println(e);
                        }
                        break;

                    case 2:
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        try {
                            double newBalance = manager.withdraw(username, withdrawAmount);
                            System.out.println("New Balance: $" + newBalance);
                        } catch (InsufficientFundsException e) {
                            System.err.println(e);
                        }
                        break;

                    case 3:
                        try {
                            manager.checkBalance(username);
                        } catch (InvalidCredentialsException e) {
                            System.err.println(e);
                        }
                        break;

                    case 4:
                        System.out.println("Logout Successful.");
                        sc.close();
                        return;

                    default:
                        System.err.println("Invalid Option! Try again.");
                }
            }
        } catch (InvalidCredentialsException e) {
            System.err.println(e);
        }
    }
}
