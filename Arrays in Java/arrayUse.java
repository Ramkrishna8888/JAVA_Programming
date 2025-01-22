// learn how to use syntax of array in java
import java.util.*;
public class displayArray {
     public static void main(String[] args)
     {
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("Enter the size of array");
    	 int size = sc.nextInt();
    	 int i =0;
    	 int arr[] = new int[size];
    	 for(i=0; i<size; i++)
    	 {
    		 arr[i]=sc.nextInt();
    	 }
    	 System.out.println("Printing elements using normal For loop");
    	 for(i=0; i<size; i++)
    	 {
    		 System.out.println(arr[i]+" ");
    	 }
    	 System.out.println("Printing elements using For each loop");
    	 for(int x : arr)
    	 {
    		 System.out.println(x+" ");
    	 }
    	 System.out.println("Size of array is : "+arr.length); // use of length memener to know the size of array
     }
}
