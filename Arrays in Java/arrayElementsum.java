// focus on the use of for each loop
import java.util.*;
public class arrayElementsum {
   public static void main(String[] args)
   {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter the size of array");
	   int size = sc.nextInt();
	   int arr[] = new int[size];
	   System.out.println("Enter the elements of array : ");
	   // Now using for loop to demonstrate the use of length member
	   for(int i = 0; i<arr.length; i++){
		   arr[i] = sc.nextInt();
	   }
	   // here i'm again using for each loop for output
	    int sum = 0;
	   for(int a : arr){
		  
		   sum = sum + a;
	   }
	   System.out.println("Sum of elements present in the array is : "+sum);
   }
}
