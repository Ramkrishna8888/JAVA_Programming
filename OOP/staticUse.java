// Understanding the use of Static keyword in JAVA OOP
class Myclass
{
	   int m;
	   static int n;
	   void temp()
	   {
		   m = 10;
		   n = 20;
	   }
	   static void temp2() {
		   n=50;
	   }
	   void display()
	   {
		   System.out.println("m = "+m+" n = "+n);
	   }
}
public class static1 {
    public static void main(String[] args) {
    	System.out.println("calling normal method");
    	Myclass obj1 = new Myclass();
    	obj1.temp();
    	obj1.display();
    	System.out.println("After calling the static method with second object");
    	Myclass obj2 = new Myclass();
    	obj2.temp();
    	obj2.temp2();
    	obj2.display();
       // you can declare value of static variable like this as well
    	Myclass.n=100;
    	obj2.display();
    }
   }
