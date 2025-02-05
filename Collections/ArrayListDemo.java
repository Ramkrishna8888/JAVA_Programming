import java.util.*;
public class ArrayListDemo {
    public static void main(String[] args) {
       //ArrayList obj = new ArrayList();
    	LinkedList obj = new LinkedList();
    	
    	// diffrence is in only performance in case of linkedlist add and remove method is fast
    	obj.add(10); // autoboxing - added in java  5 version
    	obj.add(20);
    	obj.add("Rajan");
    	obj.add("Pandey");
    	System.out.println(obj); //[10, 20, Rajan, Pandey]
    
        obj.add(2,"Hello"); 
        System.out.println(obj);  //[10, 20, Hello, Rajan, Pandey]
 
       obj.set(2, "Hey");
       System.out.println(obj);  //[10, 20, Hey, Rajan, Pandey]
       
       obj.remove("Hey");
       System.out.println(obj);  //[10, 20, Rajan, Pandey]
       
       obj.remove(1);
       System.out.println(obj); //[10, Rajan, Pandey]
       
       String s = (String)obj.get(2); // typecasting because return type of get method is object(higher in priority) but i'm trying to store in String.
       System.out.println(s);  // Pandey
       
       System.out.println("Size = "+obj.size());
       
       
  /*
   converting respective primitive type into reference type or vice versa automatically
    This feature is known as autoboxing
    
       above we used the the premitive type with collection but collection supports only reference type.
   */
    
    
    
    }
}
