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
	   int num2 = reverse;
	   while(num2>0)
	   {
	   int digit2 = num2 % 10;
	   switch(digit2)
	   {
	   case 0:{
		   System.out.print("zero ");
	        break;
	   }
	   case 1:{
		   System.out.print("one ");
		    break;
	   }
	   case 2:{
		   System.out.print("two ");
		    break;
	   }
	   case 3:{
		   System.out.print("three ");
		    break;
	   }
	   case 4:{
		   System.out.print("four ");
	        break;
	   }
	   case 5:{
		   System.out.print("five ");
	        break;
	   }
	   case 6:{
		   System.out.print("six ");
		    break;
	   }
	   case 7:{
		   System.out.print("seven ");
		    break;
	   }
	   case 8:{
		   System.out.print("eight ");
		    break;
	   }
	   case 9:{
		   System.out.print("nine ");
		    break;
	   }
	   default :
		   System.out.println("Invalid input");
	   }
	   num2 = num2/10;
	   }
   }
}
