import java.util.Scanner;
public class Area {
    public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter the length of rectangle");
    	int l = s.nextInt();
    	System.out.println("Enter the breadth of rectangle");
    	int b = s.nextInt();
    	System.out.println("area = "+(l*b));
    }
}
