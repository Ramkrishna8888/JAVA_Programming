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
		p.call(); */

	// Anonymous inner class
	
	Phone p = new Phone() {
		public void call() {
			System.out.println("Calling");
		}
	};
	p.call();
	
	}	
	
}
