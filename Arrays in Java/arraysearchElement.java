// Practicing array in JAVA language
import java.util.*;
public class arraysearchElement {
  public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
	  // A predefined array
	  int predefined_array[] = {1,7,6,3,4,5};
    boolean match = true;
	  int i;
	  System.out.println("Enter a number to search in the array");
	  int searching_ele = sc.nextInt(); 
	  // Checking through for loop whether the searching is present is array or not
	  for(i=0; i<predefined_array.length; i++)
	  {
		  if(searching_ele == predefined_array[i]) {
			   match = true;
		      break;
		  }
		  else
			  match = false;
	  }
	  if(match)
		  System.out.println("The element "+searching_ele+" is present on index : "+i);
	  else
		  System.out.println("The element "+searching_ele+" is not present in the array");
  }
}
