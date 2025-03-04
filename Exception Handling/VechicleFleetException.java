import java.util.*;
class InvalidVehicleDetailsException extends Exception {
	 InvalidVehicleDetailsException(String msz){
		 super(msz);
	 }
}

class VehicleRegistrationSystem{
	
	public String validatFleetDetails(String registrationId, String vehicleLicenseNumber, String driverLicenseNumber) throws InvalidVehicleDetailsException{
	    String idRegex = "^VR-[0-9]{4}";
	    String vehicleRegex = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$";
	    String licenseRegex = "^[A-Z]{2}[0-9]{13}$";
	    if(registrationId.matches(idRegex)) {
	    	if(vehicleLicenseNumber.matches(vehicleRegex)) {
	    		if(driverLicenseNumber.matches(licenseRegex)){
	    			return "Details for Registration ID:"+registrationId+" are valid and can be added to the system";
	    		}
	    	}
	    }
	    	throw new InvalidVehicleDetailsException("Details of registration Id are invalid");
	}
	
}

public class VehicleFleet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	VehicleRegistrationSystem obj = new VehicleRegistrationSystem();
	
	try {
	System.out.println("Enter Registration ID:");
	String id = sc.nextLine();
	System.out.println("Enter Vehicle License Number:");
	String vehicle = sc.nextLine();
	System.out.println("Enter Driver License Number:");
	String license = sc.nextLine();
	
	System.out.println(obj.validatFleetDetails(id, vehicle, license));
	
	}
	catch(InvalidVehicleDetailsException e) {
		System.err.println(e.getMessage());
	}
	
	}

}
