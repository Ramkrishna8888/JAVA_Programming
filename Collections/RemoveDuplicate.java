// Write a program to remove duplicate mobile numbers

import java.util.*;
public class RemoveDuplicate {

	public static void main(String[] args) {
		  List<Integer> mobileno = new ArrayList<Integer>();  // Why used List as a reference ? check the next line for answer
		  // ArrayList<Integer> mobileno = new ArrayList<Integer>(); we can do this as well but it's always suggested to use base Interface reference should refer to subclass objects 
          mobileno.add(1111);
          mobileno.add(2222);
          mobileno.add(3333);
          mobileno.add(1111);
          mobileno.add(2222);
          mobileno.add(4444);
          mobileno.add(5555);
          mobileno.add(5555);
		  System.out.println(mobileno);//[1111, 2222, 3333, 1111, 2222, 4444, 5555, 5555]
		 
		  Set<Integer> uniquemobno = new LinkedHashSet<Integer>(); // used LinkedHashSet because i'm worried about the order
		  //addAll is used to add one collection object to another collection object
		  // while add is used to add the elements in a set or list
		  uniquemobno.addAll(mobileno);
		  System.out.println("After using the LinkedHashSet");
		  System.out.println(uniquemobno);
	}

}
