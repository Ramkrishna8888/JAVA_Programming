import java.util.*;
public class positiveNegativeZero {
     public static void main(String[] args)
     {
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("Enter a number");
    	 int num = sc.nextInt();
    	 if(num>0)
    	 {
    		 System.out.println("Given number is Positive");
    	 }
    	 else if(num<0)
    	 {
    		 System.out.println("Given no. is Negative");
    	 }
    	 else
    		 System.out.println("Given no. is Zero");
     }
}
