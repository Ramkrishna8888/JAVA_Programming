import java.util.*;
public class Age {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age");
		int n = sc.nextInt();
		if(n>=18)
		{
			System.out.println("Major");
		}
		else if(n<18&&n>0)
		{
			System.out.println("Minor");
		}
		else
		{
			System.out.println("Invalid Age");
		}
		
	}

}
