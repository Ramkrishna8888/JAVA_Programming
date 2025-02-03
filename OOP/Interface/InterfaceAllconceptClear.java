import java.util.*;
interface ShapeCircle{	
	double pi = 3.14;
	double CalculateAreaCircle(double radius);
	double CalculateCircumference(double radius);
}
interface ShapeTriangle{
	double CalculateAreaTriangle(double base, double height);
	double CalculatePerimeterTriangle(double side1, double side2, double side3);
}

interface ShapeSquare{
	double CalculateAreaSquare(double side);
	double CalculatePerimeterSquare(double side);
}
class Circle implements ShapeCircle{
	
	
	Circle(){
		System.out.println("Calculating Area and Perimeter of Circle");
	}
	
	@Override
	public double CalculateAreaCircle(double radius) {
		return pi*(radius*radius);
	}
	@Override
	 public double CalculateCircumference(double radius) {
		
		return pi*2*radius;
	}
	
}

class Triangle implements ShapeTriangle{
	
/*	Triangle(){
		System.out.println("Calculating Area and Perimeter of Triangle");
	} NOT POSSIBLE INTERFACE DOESN'T HAVE CONTRUCTORS
	
	AND ALSO YOU CAN'T CRDATE OBJECT OF AN INTERFACE DIRECTLY 
	
	*/
	
	@Override
    public double CalculateAreaTriangle(double base, double height) {
		
		return 0.5*(base*height);
	}
	
	@Override
    public double CalculatePerimeterTriangle(double side1, double side2, double side3) {
		
		return side1+side2+side3;
	}
		
}

class Square implements ShapeSquare{
	
	@Override
	public double CalculateAreaSquare(double side) {
		return side*side;
	}
	
	@Override
	public double CalculatePerimeterSquare(double side) {
		return 4*side;
	}
	
}




public class AreaPerimeter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("\n");
		System.out.println("********************************");
		System.out.println(" FINDING AREA & PERIMETER ");
		System.out.println("Enter the choice ");
		System.out.println("PRESS 1 for Circle");
		System.out.println("PRESS 2 for Triangle");
		System.out.println("PRESS 3 for Square");
		System.out.println("PRESS 4 for EXIT");
		int choice = sc.nextInt();
			switch(choice){
			case 1: {
				  
				System.out.println("Enter the radius of circle ");
				double radius = sc.nextDouble();
				ShapeCircle obj1 = new Circle();
			    System.out.println("Area of circle : "+obj1.CalculateAreaCircle(radius)); 
			    System.out.println("circumference of circle : "+obj1.CalculateCircumference(radius));
			    break;
			}
			
			case 2:{
				
				System.out.println("Enter the base and height for the Area");
				double base = sc.nextDouble();
				double height = sc.nextDouble();
				System.out.println("Enter the side1, side2 and side3 of triangle");
				double side1 = sc.nextDouble();
				double side2 = sc.nextDouble();
				double side3 = sc.nextDouble();
				ShapeTriangle obj2 = new Triangle();
				System.out.println("Area of Triangle : "+obj2.CalculateAreaTriangle(base,height));
				System.out.println("Perimeter of Triangle : "+obj2.CalculatePerimeterTriangle(side1,side2,side3));			
				break;
			}
			
			case 3:{
				 
				System.out.println("Enter the side of Square");
				double side = sc.nextDouble();
				ShapeSquare obj3 = new Square();
				System.out.println("Area of Square : "+obj3.CalculateAreaSquare(side));
				System.out.println("Perimeter of Square : "+obj3.CalculatePerimeterSquare(side));
				break;
			}
			
			case 4:{
				
				System.out.println("Thanks for using this app");
				sc.close();
				return;
			}
			
			default : System.out.println("Invalid choice ! Kindly re-enter");
			
			}
	}

	}

}
