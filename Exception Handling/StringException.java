import java.util.*;
class ExceptionCheck{
	
	public String getData(String word, int a, int b) {
		
		String ans = "";
		try {
		String Extraction = word.substring(a,b);
		System.out.println("The extracted word is "+Extraction);
		}
		catch (StringIndexOutOfBoundsException e){
			
			ans = "String index is undefined";
		}
		finally {
			ans = ans + "Thanks for using the application";
		}
	
	    return ans;
	}
		
}

public class StringIndex {

	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the String");
		String word = sc.nextLine();
		
		System.out.println("Enter the index 1 and index 2");
		int a= sc.nextInt();
		int b = sc.nextInt();
		
	   ExceptionCheck obj = new ExceptionCheck();
	   System.out.println(obj.getData(word, a, b));

	}

}
