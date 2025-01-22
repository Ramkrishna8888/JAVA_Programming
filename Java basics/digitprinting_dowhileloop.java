// Syntax of Do while loop
import java.util.*;
public class Digitprint_doWhileloop {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int i =1;
    	do {
    		System.out.print(i+" "); // using System.out.print to print digits in a single line with one space between them
    		i++;
    	}while(i<=10);
    	
    }
}
