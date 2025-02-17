import java.util.*;
import java.util.stream.Stream;

public class StreamObject {

	public static void main(String[] args) {
		
	// Stream API - collection process
	// collection / group of object

		
	//1. blank stream object
		
	Stream<Object> emptyStream = Stream.empty();
	
	
	//2. Array, object, collections
	String[] names = {"Ram", "Krishna", "Rajan", "Pandey"};
	
	/*Stream<String> stream1 = Stream.of(names);
	stream1.forEach(e -> {
			   System.out.println(e);
	    }); */
	
	Stream<String> stream1 = Stream.of(names);
	stream1.forEach(e -> {
		   if(e.startsWith("R"))
			   System.out.print(e+" ");
	    });
	
	//3. List, Set
	
	List<Integer> list2 = new ArrayList<>();
	  
	    list2.add(2);
	    list2.add(3);
	    list2.add(4);
	    list2.add(6);
	    list2.add(12);
	    list2.add(15);
	    
	Stream<Integer> stream = list2.stream();
	   stream.forEach(e->{
		   if(e%2==0)
		   System.out.print(e+" ");
	   });
	
	
	}
	
	
	// 

}
