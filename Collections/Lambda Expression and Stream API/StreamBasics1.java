import java.util.*;
import java.util.stream.*;
public class StreamMain1 {

	public static void main(String[] args) {		
		
		List<Integer> list3  = Arrays.asList(2,4,24,34,45); // Immutable list

		System.out.println(list3);
		
		// Normal approach to find even no in a list
		
		List<Integer> ListEven = new ArrayList<>();
		
		for(int i : list3) {
			if(i%2==0)
			{
				ListEven.add(i);
			}
		}
		
		
		System.out.println(ListEven);
		
		// Stream approach
		
		System.out.println("\nUsing Stream :");
		
		Stream<Integer> stream1 = list3.stream();
		List<Integer> EvenNewList = stream1.filter(even -> even%2==0).collect(Collectors.toList());
		System.out.println(EvenNewList);
		
		System.out.println("\n Chaining (Making it more compact)");
		
	List<Integer> EvenNewList2 =  list3.stream().filter(num -> num%2==0).collect(Collectors.toList());
		System.out.println(EvenNewList2);


		System.out.println("\n Finding numbers that are greater than 5");
		
	List<Integer> ListGreater = list3.stream().filter(dig -> dig>=4).collect(Collectors.toList());
		System.out.println(ListGreater);	
		
		
	}
 
}
