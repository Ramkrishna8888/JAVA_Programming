interface Shape{
	
	void draw();
	
	default void drawing() {
		System.out.println("Drawing any shape from shape 1");
	}
	
}
interface Shape2{
	void draw2();
	
	default void drawing2() {
		System.out.println("Drawing any shape from shape 2");
	}
	
	
}
class circle implements Shape,Shape2{
	
	 public void draw() {
		  System.out.println("Drawing a abstract circle for interface Shape ");
	  }
	 
	 public void draw2() {
		 System.out.println("Drawing an abstract circle for interface Shape2 ");
	 }
	 
	 void circleshape() {
		 System.out.println("Circle by the method of circle class");
	 }
}
public class interface1 {

	public static void main(String[] args) {
		Shape obj1 = new circle();
		System.out.println("Using Shape interface as reference refers to circle object");
		obj1.draw();
		obj1.drawing();
		Shape2 obj2 = new circle();
		System.out.println("Using Shape2 interface as refers to circle object");
		obj2.draw2();
		obj2.drawing2();
		circle obj3 = new circle();
		System.out.println("Using circle as reference and also used it's object and by this i can call all the methods (Shape, Shape2, circle)");
		obj3.draw();
		obj3.draw2();
		obj3.drawing();
		obj3.drawing2();

	}

}
