class Calculator {
    
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }
    
    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Overloaded method to add two double numbers
    public double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        // Calling the add method with two integers
        System.out.println("Sum of two integers: " + calculator.add(10, 20));
        
        // Calling the add method with three integers
        System.out.println("Sum of three integers: " + calculator.add(10, 20, 30));
        
        // Calling the add method with two doubles
        System.out.println("Sum of two doubles: " + calculator.add(10.5, 20.3));
    }
}
