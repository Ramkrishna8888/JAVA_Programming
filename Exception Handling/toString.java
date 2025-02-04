import java.util.*;
class Product
{
   int pid;
   String pname;
   double price;
   Product(int pid, String pname, double price){
	   this.pid = pid;
	   this.pname = pname;
	   this.price=price;
   }
   Product(){}; // when your parameterized constructor is created then it's a good practice to create a default contructor
	   public String toString() { // if you will not override a toString method then you'll get class name and hashcode as output
		   return pid+" "+pname+" "+price; // because it'll extend object class of java implicitly 
	   }
   }

public class ToStringDemo {

	public static void main(String[] args) {
		Product obj = new Product(123, "Mouse", 200.0);
		System.out.println(obj);

	}

}
