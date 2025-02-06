import java.util.List;

public class StreamDemo1 {

	public static void main(String[] args) {
		List<String> list1 = List.of("Ram", "Krishna", "Pandey");
		
	   //Ways of Traversing list or set
		
		for(int i = 0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		// Enhanced for loop
		for(String s : list1) {
			System.out.println(s);
		}
		
		// forEach() JAVA 8 version
		list1.forEach(s -> System.out.println(s));

		// Method reference JAVA 8 Version
		list1.forEach(System.out::println);
	}

}
