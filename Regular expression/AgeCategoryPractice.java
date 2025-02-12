import java.util.*;

public class Main {

    void checkValid(String id) {
        if (id.length() != 8) {
            System.out.println(id.length() + " is an invalid length");
            return;
        }

        String regex = "^[A-Z]{3}[0-9]{5}$";
        if (!id.matches(regex)) {
            System.out.println(id + " is an invalid format");
            return;
        }

        String digPart = id.substring(3);

        if (digPart.charAt(0) == '0') {
            System.out.println(digPart.charAt(0) + " is an invalid digit");
            return;
        }

    String lastDigitStr = digPart.substring(4);
      int lastDigit = Integer.parseInt(lastDigitStr); 

    if (lastDigit < 1 || lastDigit > 9) {
    System.out.println("Age category is an invalid category");
    return;
     }


   String pin = "" + id.charAt(4) + id.charAt(6);


        System.out.println("PIN: " + pin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the membership ID:");
        String id = sc.nextLine();

        Main obj = new Main();
        obj.checkValid(id);

        sc.close();
    }
}
