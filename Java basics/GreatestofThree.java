//Basic approach
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
    	if(a>b)
    	{
    		if(a>c)
    		{
    			greater = a;
    		}
    		else
    		{
    			greater = c;
    		}
    	}
    	else if(b>c)
    	{
    		greater = b;
    	}
    	else
    	{
    		greater = c;
    	}
    	System.out.println("The greatest number is = "+greater);
    }
}


// Using  Logical operator

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

//Greatest of three numbers conditional operator 

import java.util.*;
public class biggestOfThree {
      public static void main(String[] args)
      {
    	  Scanner sc = new Scanner(System.in);
    	  System.out.println("Enter any three numbers");
    	  int a = sc.nextInt();
    	  int b = sc.nextInt();
    	  int c = sc.nextInt();
    	  int greater = (a>b)?((a>c)?a:c):((b>c)?b:c);
    	  System.out.println("Greater no. is "+greater);
      }
	
}
