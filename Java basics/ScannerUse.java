import java.util.Scanner;
public class student {
	public static void main (String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the roll no. ");
	    int roll = sc.nextInt();
	    System.out.println("Enter the name");
	    String name = sc.next();
	    System.out.println("Enter the marks in three subjects");
	    double marks1 = sc.nextDouble();
	    double marks2 = sc.nextDouble();
	    double marks3 = sc.nextDouble();
	    double total = marks1 + marks2 + marks3;
	    double avg = total/3;
	    // Math.round is used to control the values after decimal points
	    double roundedValue = Math.round(avg * 1000.0) / 1000.0;
	    System.out.println("Roll no = "+roll);
	    System.out.println("Name = "+name);
	    System.out.println("Total marks = "+total);
	    System.out.println("Average of marks = "+roundedValue);
	}

}
