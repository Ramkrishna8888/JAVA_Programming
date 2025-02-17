import java.util.*;
import java.util.stream.*;
public class StreamMethods {

	public static void main(String[] args) {

		  // filter method
		
		 List<String> names = List.of("Ram", "Krishna", "Rajan", "Pandey");
		 
		 List<String> nameStarWithR =  names.stream().filter(e ->
		      e.startsWith("R")
				 ).collect(Collectors.toList());
      
		 System.out.println(nameStarWithR);
     
		 // Map method
		 
		 List<Integer> numbers = List.of(2,3,4,5,6,7,8,9);
		 
		List<Integer> numSquare = numbers.stream().map(i -> i*2).collect(Collectors.toList());
		 System.out.println(numSquare);
		 
		 // for each method
		 
		 names.stream().forEach(
			 e-> {System.out.println(e);}
		 );
		 
		 System.out.println("\nPrint using method reference passing\n");
		 
		// Printing using method reference passing
	     names.stream().forEach(System.out::println);
	     
	     // sorted function
	
	     System.out.println("\nPrinting numbers in sorted order");
	     numbers.stream().sorted().forEach(System.out::print);
	
	     
	     // We have to use get method because max and min returns optional and get helps to give the max value
	     
	     // Min method
	     System.out.println("\nMinimum number");
	  Integer nums =   numbers.stream().min((a,b)->a.compareTo(b)).get();
	         System.out.println(nums+" ");
	         
	     System.out.println("\nMaximum number");  
	  Integer nums2 = numbers.stream().max((a,b) -> a.compareTo(b)).get();
	      System.out.println(nums2);
	
	}

}
