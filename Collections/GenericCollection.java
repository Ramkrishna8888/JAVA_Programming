import java.util.*;
public class GenericCollection {
    public static void main(String[] args) {
    	LinkedList<String> obj = new LinkedList<String>(); 
    	
    	//obj.add(123); Not possible because using generic feature we gave the limitation to the linkedlist to collect only String type 
    	obj.add("Ram"); 
    	obj.add("Krishna"); 
    	obj.add("Pandey"); 
        System.out.println(obj);
        
        // using for each loop here
        
        for(String i : obj) {
        	System.out.println(i);
        }
    }
}
