import java.util.*;
import java.util.Comparator;

// Sorting on the basis of Id
class IdComparator implements Comparator<Employee>{
	
	@Override
	public int compare(Employee obj1, Employee obj2) {
		return obj1.getId() - obj2.getId();
	}	
}

class NameComparator implements Comparator<Employee>{
	
	@Override
	public int compare(Employee obj1, Employee obj2) {
	return obj1.getEmpname().compareTo(obj2.getEmpname());
	}
}


// Sorting on the basis of 

class Employee{
	
	private String empName = "";
	private String Mobno = "";
	private int id =  0;
	
	
	Employee(String empName, String Mobno, int id){
		this.empName = empName;
		this.Mobno = Mobno;
		this.id = id;
	}
	
	public String getEmpname() {
		return empName;
	}
	
	public void setEmpname(String empName) {
		this.empName = empName;
	}
	
	public String getMobno() {
		return Mobno;
	}
	
	public void setMobno(String Mobno) {
		this.Mobno = Mobno;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
      public String toString(){
		return empName+" "+Mobno+" "+id;
	}
	
}


public class ComparatorUse {

	public static void main(String[] args) {
       
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> emp = new ArrayList<>();
		
		emp.add(new Employee("Ram","1234567890",1));
        emp.add(new Employee("Krishna", "2233456772",5));
        emp.add(new Employee("Pandey", "1122334455", 3));
        
        System.out.println("Sorting based on Id");
	    Collections.sort(emp, new IdComparator());
        System.out.println(emp);
        
        System.out.println("\n Sorting based on Name");
        Collections.sort(emp, new NameComparator());
        System.out.println(emp);
	}

}
