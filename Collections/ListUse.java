import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int marks;

    // Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class StudentExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();  // ✅ Student list

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < n; i++) {
            // Taking input
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter marks of " + name + ": ");
            int marks = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // ✅ Create student object
            Student newStudent = new Student(name, marks);
            
            // ✅ Add student to the list
            students.add(newStudent);
        }

        // ✅ Display all students
        System.out.println("\nList of students:");
        for (Student s : students) {
            System.out.println("Name: " + s.getName() + ", Marks: " + s.getMarks());
        }
    }
}
