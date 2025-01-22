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
    	 for(i=0; i<size; i++)
    	 {
    		 System.out.print(arr[i]+" ");
    	 }
     }
}
