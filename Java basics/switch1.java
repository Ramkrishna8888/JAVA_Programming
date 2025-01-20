// Understand the working of SWITCH STATEMENT
// Understand the String.format function use and also typecasting in line
import java.util.*;
public class Maths_switch {
   public static void main(String[] args)
   {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter any two numbers");
	   int a = sc.nextInt();
	   int b = sc.nextInt();
	   System.out.println("Enter the choice :");
	   System.out.println("PRESS 1: ADD");
	   System.out.println("PRESS 2: SUBTRACT");
	   System.out.println("PRESS 3: MULTIPLICATION");
	   System.out.println("PRESS 4: DIVISION");
	   int choice = sc.nextInt();
	   switch(choice)
	   {
	   case 1:
	   {
		   System.out.println("The addition of "+a+" and "+b+" is "+(a+b));
		   break;
	   }
	   case 2:
	   {
		   System.out.println("The substraction of "+a+" and "+b+" is "+(a-b));
		   break;
	   }
	   case 3:
	   {
		   System.out.println("The Multiplication of "+a+" and "+b+" is "+(a*b));
		   break;
	   }
	   case 4:
	   {
		   System.out.println("The Division of "+a+" and "+b+" is "+String.format("%.2f",(float)a/b));
		   break;
	   }
	   default :
		   System.out.println("Invalid Input !!");
	   }
   }
	
}
