import java.util.*;public class StreamMain1 {

	public static void main(String[] args) {
		
		
		//Types to add elements in list 
		
		// Type 1
		
		List<Integer> list1 = List.of(2,4,24,34,45); // It's immutable 
		
		//Type 2
		
		List<Integer> list2 = new ArrayList<>(); // mutable way
		
		list2.add(2);
		list2.add(4);
		list2.add(24);
		list2.add(34);
		list2.add(45);
		
		//Type 3
		
		List<Integer> list3  = Arrays.asList(2,4,24,34,45); // Immutable 
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}

}
