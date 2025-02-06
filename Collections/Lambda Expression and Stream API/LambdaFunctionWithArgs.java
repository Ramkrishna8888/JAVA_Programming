import java.util.*;
@FunctionalInterface
interface Phone{
	void call(int num);
	
}

/*class AndroidPhone implements Phone{
	@Override
	public void call() {
		System.out.println("Calling");
	}
}*/
public class LambdaDemo { 

	public static void main(String[] args) {
		/*Phone p = new AndroidPhone();
		p.call(); 
 
	 Anonymous inner class
	
	Phone p = new Phone() {
		public void call() {
			System.out.println("Calling");
		}
	};
	p.call(); */
		
	// Lambda Expressions 	
      Phone p = (int num) -> System.out.println("Calling: "+num);
		p.call(1234);
	
  // we already Know the data types as well so we can remove that as well
	  Phone p1 = (num) -> System.out.println("Calling: "+num);
		p1.call(1234);	
			
 // If there is only one argument then using parenthesis is also optional
		Phone p3 = num -> System.out.println("Calling: "+num);
		p3.call(1234);	
	}	
	
}
