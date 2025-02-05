import java.util.*;
public class IterateMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
		hm.put("Monitor", 5000);
		hm.put("Keyboard", 1600);
		hm.put("CPU", 20000);
		hm.put("Graphics Card", 40000);
		hm.put("mouse", 800);
		
		System.out.println(hm); 
		
		// Now we want to iterate Key seprately
		
		Set<String> keys = hm.keySet();
		for(String i : keys) {
			System.out.println(i+" : "+hm.get(i));
			
		/*  mouse : 800
			Monitor : 5000
			Keyboard : 1600
			Graphics Card : 40000
			CPU : 20000   */

		}

	}

}
