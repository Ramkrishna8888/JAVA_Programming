// Working on Syntax of JAVA
import java.util.*;
public class sumOFdigits {
   public static void main(String[] args)
   {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter a digit :");
	   int num = sc.nextInt();
	   int sum = 0;
	   while(num != 0)
	   {
		   int lastdig = num%10;
		   sum = sum + lastdig;
		   num = num/10;
	   }
	  System.out.println("The sum of digit is :"+sum); 
   }
}
