// understand how to use regex by just this single program
/*
^ used for starting the expression
$ used for closing the expression
[a-zA-Z] for giving the range
[a-z]+ atleast one or more than one
[a-z]{2} giving range of only two characters 
[a-z]{2,} atleast two character

an exxpression =

^[a-zA-Z]{4}[0-9]{5,}[a-c]+$

input
aBcD1234567aabbbbc
output
true

*/


import java.util.Scanner;
import java.util.regex.*;
public class regex1 {
	
	public static void checkStringRe(String re, String str) {
		
		Pattern pattern = Pattern.compile(re);
		Matcher match = pattern.matcher(str);
		
		boolean matches = match.matches();
		
		System.out.println(matches);
		
	}
	
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   
	   while(true) {
	   
	   System.out.println("Enter the regular expression");
	   String re = sc.nextLine();
	   
	   System.out.println("Enter the String to be checked");
	   String str = sc.nextLine();
	   
	   checkStringRe(re,str);
	   
	   System.out.println("whether you want to close the app (Yes/No)");
	   String choice = sc.nextLine();
	   
	   if(choice.equalsIgnoreCase("yes"))
	   {
		   System.out.println("Thankyou !");
		   break;
	   }
	   }
   }
}
