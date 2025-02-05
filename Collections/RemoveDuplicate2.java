// Write a program to remove duplicate mobile numbers
// FACTORY feature of Java 9
import java.util.*;
public class RemoveDuplicate2 {

	public static void main(String[] args) {
		 /* List<Integer> mobileno = new ArrayList<Integer>(); 
		  mobileno.add(1111);
          mobileno.add(2222);
          mobileno.add(3333);
          mobileno.add(1111);
          mobileno.add(2222);
          mobileno.add(4444);
          mobileno.add(5555);
          mobileno.add(5555);
		  System.out.println(mobileno);//[1111, 2222, 3333, 1111, 2222, 4444, 5555, 5555]
		 */
		
		// Collection Factory method  - of() - added in  Java 9 version
		
		List<Integer> mobileno = List.of(1111,2222,3333,1111,2222,4444,5555,5555);
		 System.out.println(mobileno);//[1111, 2222, 3333, 1111, 2222, 4444, 5555, 5555] 
		
		Set<Integer> uniquemobno = new LinkedHashSet<Integer>(); // used LinkedHashSet because i'm worried about the order
		  //addAll is used to add one collection object to another collection object
		  // while add is used to add the elements in a set or list
		  uniquemobno.addAll(mobileno);
		  System.out.println("After using the LinkedHashSet");
		  System.out.println(uniquemobno);
	}

}
