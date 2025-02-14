import java.util.*;


class InvalidHealthDataException extends Exception{
InvalidHealthDataException(String excep)
{
	   super(excep);
}
}

class HealthDataProcessor{


    	
	
	public boolean validatePatientDetails(String Name, int age, String Gender, double Height, double Weight, double BloodPressure, double Cholesterol) throws InvalidHealthDataException{
		if(age<18 || age>100) {
			throw new InvalidHealthDataException("Invalid age");
		}
		if(!Gender.equalsIgnoreCase("Male") && !Gender.equalsIgnoreCase("Female")) {
			throw new InvalidHealthDataException("Invalid gender");
		}
		
		if(Height<=0) {
			throw new InvalidHealthDataException("Invalid height");
		}
		
		if(Weight<=0) {
			throw new InvalidHealthDataException("Invalid weight");
		}
		
		if(BloodPressure<0) {
			throw new InvalidHealthDataException("Invalid blood pressure");
		}
		
		if(Cholesterol<0) {
			throw new InvalidHealthDataException("Invalid cholesterol");
		}
		
		return true;
	}
	
	public double calculateInsurancePremium(String Name, int age, String Gender, double Height, double Weight, double BloodPressure, double Cholesterol){
	       
		double BMI = Weight/(Height*Height);
	    double premium = 0.0;
		if((BMI >= 18.5 && BMI <= 24.9) && (BloodPressure >=80 && BloodPressure <=120) && Cholesterol <200 ) {
			premium = 750.0;
		}
		if((BMI >= 25 && BMI <=29.9) && (BloodPressure >=90 && BloodPressure<=139.9) && (Cholesterol >=200 && Cholesterol <=239.9)) {
			premium = 1000.0;
		}
		if((BMI >=30) && (BloodPressure >=140) && (Cholesterol >=240)) {
			premium = 1500.0;
		}
	   return premium;
	}
	
}
public class healthCareMangExceptionHandling {

	public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     
     try {
     System.out.println("Enter Name:");
     String name = sc.nextLine();
     
     System.out.println("Enter Age:");
     int age = sc.nextInt();
     sc.nextLine();
     
     System.out.println("Enter Gender:");
     String gender = sc.nextLine();
     
     System.out.println("Enter Height (in meters):");
     double height = sc.nextDouble();
     
     System.out.println("Enter Weight (in kg):");
     double weight = sc.nextDouble();
     
     System.out.println("Enter Blood pressure (mmHg):");
     double bloodpressure = sc.nextDouble();
     
     System.out.println("Enter Cholesterol Level:");
     double cholesterol = sc.nextDouble();
     
     HealthDataProcessor obj = new HealthDataProcessor();
     
    	if(obj.validatePatientDetails(name, age, gender, height, weight, bloodpressure, cholesterol)) {
    	double premium =	obj.calculateInsurancePremium(name, age, gender, height, weight, bloodpressure, cholesterol);
    	System.out.println("Total Insurance Premium: $"+premium);
    	}
     }
	catch(InvalidHealthDataException e){
		System.err.println(e);
	    }
    	
		
	}

}


