import java.util.*;
public class GreaterofThree {
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter any three numbers");
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int c = sc.nextInt();
    	int greater;
    	if(a>b && a>c)
    	{
    	greater = a;	
    	}
    	else if(b>c && b>a)
    	{
    		greater = b;
    	}
    	else
    		greater = c;
    	System.out.println("The greatest number is = "+greater);
    }
}
