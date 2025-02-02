/*
Requirements:
-        PAN number should have exactly ten characters. The first 5 characters should be alphabets in uppercase, the next four characters should be digits from 0 to 9 and the last character should be an alphabet in uppercase
-        If the PAN number fails the above condition, then print "<PAN number> is an invalid PAN number" and terminate the program.
-        E-mail should end with "@gamil.com", before @ there should be at least 5 to maximum 10 characters. All characters should be in lowercase
-        IF E-mail ID fails the above condition, then print "Invalid E-mail ID" and terminate the program.


Example 
Enter your name
rajan
Enter yout PAN number
ABCHD1234K
Enter your E-mail ID
rajanpande@gmail.com
Profile of rajan is updated successfully

*/
import java.util.Scanner;
import java.util.regex.*;
public class validProfileRegex {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = sc.nextLine();
		
		System.out.println("Enter yout PAN number");
		String pan = sc.nextLine();
		
		if(!isPan(pan))
		{
			System.out.println(pan+" is an invalid PAN number");
		     return;
		}
		
		System.out.println("Enter your E-mail ID");
		String email = sc.nextLine();
		
		if(!isEmail(email)) {
			System.out.println("Invalid E-mail ID");
		     return;
		}

		System.out.println("Profile of "+name+" is updated successfully");
		
	}
	
	public static boolean isPan(String pan) {
		
		   String re = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
		   return pan.matches(re);
	}
	
	public static boolean isEmail(String email){
	
		String re = "^[a-z]{5,10}@digitec\\.com$";
	    return email.matches(re);
	}

}
