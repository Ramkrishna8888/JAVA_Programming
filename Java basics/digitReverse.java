// simple way to reverse a digit
import java.util.*;
public class oneTwoThree {
   public static void main(String[] args)
   {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter a number");
	   int num = sc.nextInt();
	   //reversing the digit
	   int reverse = 0;
	   while(num>0)
	   {
		   int dig = num%10;
		   reverse = reverse*10+dig;
		   num = num/10;
	   }
	   System.out.println("Reverse of no :"+reverse);
   }
}
