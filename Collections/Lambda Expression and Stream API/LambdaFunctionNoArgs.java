import java.util.*;
@FunctionalInterface
interface Phone{
	void call();
	
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
		Phone p = () ->{System.out.println("Calling");};
		p.call();
	
  // if you body statement contains only one statement then using curly braces is also optional
	 Phone p1 = () -> System.out.println("Calling");
		p1.call();
		
		
	}	
	
}
