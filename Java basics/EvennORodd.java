import java.util.*;
public class EvenorOdd {
    public static void main (String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    
    	System.out.println("Enter a number");
    	int x = sc.nextInt();
    	if(x%2==0)
    		System.out.println("The given no. is Even");
    	else
    		System.out.println("The given no. is Odd");
    }
	
}
