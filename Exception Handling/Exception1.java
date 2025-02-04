
public class Exception1 {

	public static void main(String[] args) {
		try {
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			int res = n1/n2;
			System.out.println("Result = "+res);
		}
		catch(ArithmeticException e) {
			System.err.println("Divide by zero not allowed");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Requires two numbers");
		}
		catch(NumberFormatException e) {
			System.err.println("Enter only numbers");
		}
		catch(RuntimeException e) {
			System.err.println("Runtime exception occured");
		}
		catch(Exception e) { // if you'll write Exception e first then other exceptions start showing error because It's a Superclass and it's a rule
			             // if you're declaring the Superclass of exception then no need to write other subclass exceptions
			System.out.println("Exception occured"); 
		}

	}
	
	// For running the command line argument based program 
	// Right click -> Run Configuration -> Select Class -> arguments ->give arguments with comma seperated and Run

}
