//understanding the concept and use of constructor
import java.util.*;
class Student{
	
	private int studentId;
	private String studentName;
	private String studentAddress;
	private String collegeName;
	
	//  getters and setters
	
	public int getStudentId(){
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentAddress() {
		return studentAddress;
	}
	
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	Student(int studentId, String studentName, String studentAddress, String collegeName){
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.collegeName = collegeName;
	}
	
	Student(int studentId, String studentName, String studentAddress){
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.collegeName = "NIT";
	}
}


public class Contruct {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student's Id: ");
		int studentId = sc.nextInt();
		
		System.out.println("Enter Student's Name: ");
		String studentName = sc.nextLine();
		
		sc.nextLine();
		
		System.out.println("Enter Student's address: ");
		String studentAddress = sc.nextLine();
		
		Student obj = null;
		
		while(true) {
		System.out.println("Whether the student is from NIT(Yes/No)");
		String ans = sc.nextLine();
		
		if(ans.equalsIgnoreCase("yes")) {
			
			obj = new Student(studentId, studentName, studentAddress);
			break;
		}
		else if(ans.equalsIgnoreCase("no")) {
			System.out.println("Enter the college name: ");
			String collegeName = sc.nextLine();
			obj = new Student(studentId, studentName, studentAddress, collegeName);
			break;
		}
		else {
			System.out.println("Wrong Input");
		}
		
		
		}
		
		System.out.println("Student id:"+obj.getStudentId());
		System.out.println("Student name:"+obj.getStudentName());
		System.out.println("Address :"+obj.getStudentAddress());
		System.out.println("College name:"+obj.getCollegeName());
	}

}
