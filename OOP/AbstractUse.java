import java.util.*;
abstract class Vehicle{ // using V Uppercase because in JAVA case senstivity is priority and class name starts with Uppercase
	abstract void detail();
	void usebrake() {
		System.out.println("Applying brake");
	}
}
class bike extends Vehicle{
	void detail() {
		System.out.println("hi from bike class i'm overridden");
	}
	void accelarate() {
	 System.out.println("speed is 90km/hrs");  
	}
	
}
public class AbstractEx1 {

	public static void main(String[] args) {
     
	 Vehicle obj = new bike(); // refernce type is vehicle but object is of bike class
	 obj.detail();
	 obj.usebrake();
	 //obj.accelarate();  can't call base class non abstract method by reference of superclass
     
	 // for calling non abstract method of of a base class we should have the reference of that class along with it's object
	 
	 bike obj2 = new bike();
	 obj2.accelarate(); // now it's easily called
	 
	}

}
