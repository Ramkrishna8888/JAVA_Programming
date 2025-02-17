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
		
		System.out.println("\n\nUsing Stream :");
		
		Stream<Integer> stream1 = list3.stream();
		List<Integer> EvenNewList = stream1.filter(even -> even%2==0).collect(Collectors.toList());
		
		System.out.println(EvenNewList);
		
		
		
	}
 
}
