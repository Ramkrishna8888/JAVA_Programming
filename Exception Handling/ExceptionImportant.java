import java.util.*;

// TO PRINT ONLY EXCEPTION MSG WE HAVE TO USE .getMessage() predefined method CHECK LINE NO. 53

public class InvalidGadgetException extends Exception {
    public InvalidGadgetException(String message) {
        super(message);
    }
}
public class GadgetValidatorUtil {
    public boolean validateGadgetID(String gadgetID) throws InvalidGadgetException {
         String regex = "^[A-Z][0-9]{3}$";
         if(!gadgetID.matches(regex)) {
        	 throw new InvalidGadgetException("Invalid gadget ID");
         }
        return true;
    }

    public boolean validateWarrantyPeriod(int period) throws InvalidGadgetException {
        if(period<6||period>36) {
        	throw new InvalidGadgetException("Invalid warranty period");
        }
        return true;
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        GadgetValidatorUtil obj = new GadgetValidatorUtil();
        
        System.out.println("Enter the number of gadget entries");
        int size = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<size; i++){
        try {
        	
        	System.out.println("Enter gadget "+(i+1)+" details");
        	String input = sc.nextLine();
        	
        	String[] arr = input.split(":");
        	
        	if(obj.validateGadgetID(arr[0])) {
        		if(obj.validateWarrantyPeriod(Integer.parseInt(arr[2]))) {
        			System.out.println("Warranty accepted, stock updated");
        		}
        	}
        	
        	
        }
        catch (InvalidGadgetException e) {
        	System.err.println(e.getMessage());
        }
       }
    }
}
