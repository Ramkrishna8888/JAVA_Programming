// understanding the use of constructor
import java.util.*;
class rectangleArea{
	double length,breadth;
	rectangleArea(double length, double breadth)
	{
         this.length = length;
         this.breadth = breadth;
	}
	double Area()
	{
		double rectarea = length*breadth;
		return rectarea;
	}
}
public class rectangleConstructor {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double len,bdth;
		System.out.println("Enter the length and breadth :");
		len = sc.nextDouble();
		bdth = sc.nextDouble();
		rectangleArea obj = new rectangleArea(len,bdth);
		double Ans = obj.Area();
		System.out.printf("Area of rectangle is %.2f",Ans);
	}

}
