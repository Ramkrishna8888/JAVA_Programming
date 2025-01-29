// Working on String for understanding basic use
import java.util.*;
public class arr1 {
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter your name");
    	String name = sc.nextLine();
    	
    	System.out.println("Enter the fist index (from which letter you want to print name) :");
    	int index1 = sc.nextInt();
    	
    	//System.out.println("Enter the fist index (on which letter you want to end name) :");
    	//int index2 = sc.nextInt();

    	for(int i = index1; i<name.length(); i++)
    	{
    		System.out.print(name.charAt(i));
    	}
    }
}
