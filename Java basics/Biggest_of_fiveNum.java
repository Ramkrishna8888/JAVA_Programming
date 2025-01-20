// basic of while loop
import java.util.*;
public class Bignumber_loop {
   public static void main(String[] args)
   {
	   Scanner sc = new Scanner(System.in);
	   int num,i=0,big =0;
	   System.out.println("Enter any 5 biggest number");
	   while(i<5)
	   {
		   num = sc.nextInt();
		   if(num>big)
		   {
			   big = num;
		   }
		   i++;
	   }
	   System.out.println("The biggest number of five numbers you've entered is : "+big);
   }
}
