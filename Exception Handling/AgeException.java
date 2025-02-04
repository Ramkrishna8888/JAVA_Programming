// created a program to throw a User defined Exception (Checked Exception)

import java.util.*;
class AgeLimitException extends Exception{
	
	AgeLimitException(String msz){
		super(msz);
	}
	
	AgeLimitException(){};
	
}

class PersonAge {
	
	void setAge(int Age) throws AgeLimitException {
	if(Age < 18 || Age > 60) {
		throw new AgeLimitException("Age Limit should be between 18 too 60 !");
	}
	else {
		System.out.println("Your age "+Age+" is Valid");
	}
  }
}

public class AgeException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Age: ");
		int Age = sc.nextInt();
		
		 PersonAge obj = new PersonAge();
		try {
			obj.setAge(Age);
		}
		catch(AgeLimitException e) {
			System.err.println(e);
		}

	}

}
