// understanding the OOPS in java
import java.util.*;
class employee{
	int empId;
	String empName;
    Double empSal;
    void empDetail(){
    	empId = 101;
    	empName = "Ram";
    	empSal = 15000.00;
    }
    void empDisplay(){
     System.out.println("The id of employee is : "+empId);
     System.out.println("The Name of employee is : "+empName);
     System.out.println("The salary of employee is : "+empSal);
    }
}
public class employeeClass {
	public static void main(String[] args)
	{
		employee obj = new employee();
		obj.empDetail();
		obj.empDisplay();
	}

}
