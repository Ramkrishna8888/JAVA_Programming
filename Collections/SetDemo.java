import java.util.*;
public class SetDemo {

	public static void main(String[] args) {
		
	    System.out.println("*********HashSet**********");
		//HashSet (Unordered and no duplicate)
		HashSet hs = new HashSet();
        hs.add("hey");
        hs.add("Ram");
        hs.add("Krishna");
        hs.add("how");
        hs.add("are");
        hs.add("you");
        System.out.println(hs.add("Ram")); // it will return "false" because it will not add duplicate element this is the speciality of the hashset
        System.out.println(hs); // [how, Krishna, are, hey, you, Ram] Not Stored in the order that we have inserted
	
        System.out.println("*********LinkedHashSet**********");
        
      //LinkedHashSet (ordered and no duplicate)
   		LinkedHashSet obj = new LinkedHashSet();
        obj.add("hey");
        obj.add("Ram");
        obj.add("Krishna");
        obj.add("how");
        obj.add("are");
        obj.add("you");
        System.out.println(obj); // [hey, Ram, Krishna, how, are, you] Stored in the same order that we have inserted
      	
        
        System.out.println("*********TreeSet**********");
        //TreeSet (sorted and no duplicate)
        TreeSet ts = new TreeSet();
        ts.add("hello"); 
        ts.add("Ram");
        ts.add("Krishna");
        ts.add("how");
        ts.add("areee");
        ts.add("u");
        System.out.println(ts); // [[Krishna, Ram, areee, hello, how, u]] Stored in a sorted order (Ascending)
      	System.out.println(ts.descendingSet()); // [[u, how, hello, areee, Ram, Krishna]] in a sorted order(Descending)
	
	}
	
	
	

}
