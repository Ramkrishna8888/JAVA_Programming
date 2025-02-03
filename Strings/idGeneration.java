import java.util.*;
public class EmployeeIdgeneration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String generateid = "SIET";
		
		System.out.println("Enter the training ID");
	     String id = sc.nextLine();
	     
	     if(id.length()!=9) {
	    	 System.out.println(id+" is an invalid training id");
	          return;
	     }
	     
	     String year = id.substring(0,4);
	     if(!year.equals("2021")) {
	    	 System.out.println("The year is not equal to 2021");
	    	 return;
	     }
	     String teamcode = id.substring(4,6);
	     if(!(teamcode.equals("01")||teamcode.equals("02")||teamcode.equals("03")||teamcode.equals("04")||teamcode.equals("05"))) {
	    	 System.out.println(teamcode+" is an invalid teamcode");
	          return;
	     }
	     else if(teamcode.equals("01")) {
	    	 generateid = generateid + "LP";
	     }
	     else if(teamcode.equals("02")) {
	    	 generateid = generateid+"TA";
	     }
	     else if(teamcode.equals("03")) {
	    	 generateid = generateid + "CT";
	     }
	     else if(teamcode.equals("04")) {
	    	 generateid = generateid + "PT";
	     }
	     else if(teamcode.equals("05")) {
	    	 generateid = generateid + "TT";
	     }
         
	     String lastthree = id.substring(6,9);
	     int rollno = Integer.parseInt(lastthree); 
	     if(((rollno<1) || (rollno>999))) {
	    	 System.out.println(lastthree+" is an invalid roll number");
	    	 return;
	     }
	     
	    String generatedId = generateid+lastthree;
	    System.out.println("Employee Id:"+generatedId);
	     
	    
	}

}
