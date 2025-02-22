import java.util.*;
import java.util.stream.*;

// Experience is useless but in question it was given so i've used that.

class EmployeePOJO{
	private String name;
	private String department;
	private String location;
	private double salary;
	private int experience;
	
	
	
	public EmployeePOJO(String name, String department, String location, double salary, int experience) {
		this.name = name;
		this.department = department;
		this.location = location;
		this.salary = salary;
		this.experience = experience;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString(){
		return name+":"+department+":"+location+":"+salary+":"+experience;
	}
	
}

class EmployeeUtility{
	
	// get Employee by details
	
	public Stream<EmployeePOJO> getEmployeesByDepartment(Stream<EmployeePOJO> employeeStream, String department){
		
		return employeeStream.filter(e -> e.getDepartment().equalsIgnoreCase(department));		
	}
	
   // get Employee by location
	
	public Stream<EmployeePOJO> getEmployeesByLocation(Stream<EmployeePOJO> employeeStream, String location){
		return employeeStream.filter(e -> e.getLocation().contentEquals(location));
	}
	
  // get employee in salary range
	
	public Stream<EmployeePOJO> getEmployeesInSalaryRange(List<EmployeePOJO> employeeList, double minSalary, double maxSalary){
		return employeeList.stream().filter(e -> e.getSalary()>=minSalary && e.getSalary()<=maxSalary);
	}
}

public class EmployeeManagementStream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeUtility obj = new EmployeeUtility();
		List<EmployeePOJO> list = new ArrayList<>();
		
		System.out.println("Enter the total number of employee needed to add in the list");
        int size = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the employee details");
         for(int i = 0; i<size; i++) {
        	 String details = sc.nextLine();
        	 
        	 String[] arr = details.split(":");
        	 String name = arr[0];
        	 String department = arr[1];
        	 String location = arr[2];
        	 double salary = Double.parseDouble(arr[3]);
        	 int experience = Integer.parseInt(arr[4]);
             EmployeePOJO obj2 = new EmployeePOJO(name,department,location,salary,experience);
             list.add(obj2);
         }
		
         // searching employee details by department by name 
         System.out.println("Enter the department");
         String searchByDep = sc.nextLine();
		
         Stream<EmployeePOJO> stream =  obj.getEmployeesByDepartment(list.stream(), searchByDep);
         List<EmployeePOJO> listbyDep = stream.toList();
         if(listbyDep.isEmpty()) {
        	System.out.println("No employee found in "+searchByDep+" department");
         }
         else { 
        	 System.out.println("Employees found in "+searchByDep+" are:");
            listbyDep.forEach(e -> System.out.println(e.getName()+":"+e.getDepartment()+":"+e.getLocation()+":"+(int)e.getSalary()));
         }
         
         // searching employee details by location
         
         System.out.println("Enter the location");
         String searchByLocation = sc.nextLine();
         Stream<EmployeePOJO> stream2 = obj.getEmployeesByLocation(list.stream(), searchByLocation);
         List<EmployeePOJO> listbyLoc = stream2.toList();
         if(listbyLoc.isEmpty()) {
        	System.out.println("No employees found in "+searchByLocation+" Location");
         }
         else { 
        	 System.out.println("Employees found in "+searchByLocation+" location:");
          listbyLoc.forEach(e -> System.out.println(e.getName()+":"+e.getDepartment()+":"+e.getLocation()+":"+(int)e.getSalary()));         
         }
         // searhing Employee in a given salary range 
         
         System.out.println("Enter the salary range (min max)");
         double minSalary = sc.nextDouble();
         double maxSalary = sc.nextDouble();
         
         Stream<EmployeePOJO> stream3 = obj.getEmployeesInSalaryRange(list, minSalary, maxSalary);
         List<EmployeePOJO> listbySalaryRange = stream3.toList();
         if(listbySalaryRange.isEmpty()) {
         	System.out.println("No employees found in this salary range");
          }
         else {
        	 System.out.println("Employees found in this salary range:");
           listbySalaryRange.forEach(e -> System.out.println(e.getName()+":"+e.getDepartment()+":"+e.getLocation()+":"+(int)e.getSalary()));
         }
	}

}
