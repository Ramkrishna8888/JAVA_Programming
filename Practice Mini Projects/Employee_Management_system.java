import  java.util.*;
import java.time.*;
import java.util.stream.*;
class NameValidator extends Exception{
	
	NameValidator(String msz){
		super(msz);
	}
}

class EmployeeNew{
	
	private int employeeId;
	private String name;
	private int age;
	private String department;
	private double salary;
	private LocalDate joiningDate;
	
	EmployeeNew(int employeeId, String name, int age, String department, double salary, LocalDate joiningDate){
		this.employeeId = employeeId;
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}
	
	//getters
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	
	
	@Override
	public String toString(){
		return "Employee Id: "+employeeId+" Name: "+name+" Age: "+age+" Department: "+department+" Salary: "+salary+" Joining date: "+joiningDate;
	}
	
}

class EmployeeValidator{
	
	boolean validEmployeeName(String name) throws NameValidator{
		if(!name.matches("[A-Z][a-zA-Z]{0,29}")) {
			throw new NameValidator("Invalid name input");
		}
		return true;
	}
}

class EmployeeServices{
	List<EmployeeNew> employees = new ArrayList<>();
	
	// add employee details (obj) in list
	void addEmployee(EmployeeNew e) {
		employees.add(e);
	}
	
	// delete employee (object) if id matches
	boolean deleteEmployee(int employeeId) {
		return employees.removeIf(e -> e.getEmployeeId()==employeeId);
      }
	
	// search employee by name and return in a new list
	List<EmployeeNew> searchEmployeeByName(String name){
		List<EmployeeNew> list = employees.stream().filter(e -> e.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	     return list;
	}
	
	// filter by salary and return it into a new map
	Map<Integer, String> filterBySalary(double minSalary, double maxSalary){
		Map<Integer, String> map = employees.stream().filter(e -> e.getSalary()>=minSalary && e.getSalary()<=maxSalary).collect(Collectors.toMap(EmployeeNew::getEmployeeId, EmployeeNew::getName));
	    return map;		 
	  }
	
   	List<EmployeeNew> sortByJoiningDateDescending(){
   		return employees.stream().sorted(Comparator.comparing(EmployeeNew::getJoiningDate).reversed()).collect(Collectors.toList());
   	}
	
}


public class EmployeeManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

	    // creation of object for employeeServices so tha we can add all list elements
	    // to the list that is present in EmployeeServices class to perform operations
		EmployeeServices obj2 = new EmployeeServices();
		List<EmployeeNew> list = new ArrayList<>();
		
		System.out.print("Enter number of employees: ");
         int size = sc.nextInt();
         sc.nextLine();
         
         System.out.println("Enter Employee (ID:Name:Age:Department:Salary:JoiningDate):");
         try {
        	 
        	 for(int i = 0; i<size; i++) {
        		 String details = sc.nextLine();
        		 
        		 String[] arr = details.split(":");
        		 int employeeId = Integer.parseInt(arr[0]);
        		 String name = arr[1];
        		 EmployeeValidator validName = new EmployeeValidator();
        	     validName.validEmployeeName(name);
        		 
        	     int age = Integer.parseInt(arr[2]);
        	     String department = arr[3];
        	     double salary = Double.parseDouble(arr[4]);
        	     LocalDate joiningDate = LocalDate.parse(arr[5]);
        	     
        	     EmployeeNew obj = new EmployeeNew(employeeId,name,age,department,salary,joiningDate);
        	     list.add(obj);
        	    
        		obj2.addEmployee(obj);
        		
        	 }
        	     
        	     // performing deletion by employee id
        	     System.out.println("Enter Employee ID to delete:");
        	     int deleteId = sc.nextInt();
        	     sc.nextLine();
        	     
        	     if(obj2.deleteEmployee(deleteId))
        	     {
        	    	 System.out.println("Employee with ID "+deleteId+" has deleted successfully !");
        	     }
        	     else {
        	    	 System.out.println("No employee with ID "+deleteId+" present.");
        	     }
        	 
        	     System.out.println("Enter Employee name to search:");
        	     String nameSearch = sc.nextLine();
        	     
        	     
        	     List<EmployeeNew> foundEmployee = obj2.searchEmployeeByName(nameSearch);
        	     if(foundEmployee.isEmpty()) {
        	    	 System.out.println("No Employee found with the name "+nameSearch);
        	     }
        	     else {
        	    	 System.out.println("Employee with the name "+nameSearch+" is: ");
        	    	 foundEmployee.forEach(System.out::println);
        	     }
        	     
        	     System.out.println("Enter salary range (Min Max):");
        	     double minSalary = sc.nextDouble();
        	     double maxSalary = sc.nextDouble();
        	     
        	     Map<Integer, String> map = obj2.filterBySalary(minSalary, maxSalary);
        	     
        	     if(map.isEmpty()) {
        	    	 System.out.println("No Employee found in this salary range");
        	     }
        	     else {
        	    	 System.out.println("Employee in salary range "+minSalary+"-"+maxSalary+":");
        	    	 for(Map.Entry<Integer, String> itr : map.entrySet()) {
        	    		 System.out.println("ID: "+itr.getKey()+" Name: "+itr.getValue());
        	    	 }
        	     }
        	 
        	 
         }
         catch (NameValidator e) {
        	 System.out.println(e.getMessage());
         }
         
	}

}
