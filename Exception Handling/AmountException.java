import java.util.*;

class withdrawException extends Exception{
	
	withdrawException(String excep){
		
		super (excep);
		
	}
	
}
	
class CheckAmount{

public void getAmt(int amt, int withdraw) throws withdrawException {

		   if(withdraw > amt) {
			   throw new withdrawException ("Withdraw Amount "+withdraw+" is greater than amount"+amt+" Transaction Failed !!");
		   }
		   else {
			   System.out.println("Transaction Successfull.");
		   }
      }	
	
    }


public class AmountException {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the current amount");
		int amt = sc.nextInt();
		
		System.out.println("Enter the withdraw amount");
		int withdraw = sc.nextInt();
		
		CheckAmount obj = new CheckAmount();
       try {
    	  
    	   obj.getAmt(amt, withdraw);
       }
       catch (withdrawException e) {
    	   System.err.println(e);
       }

	}

}
