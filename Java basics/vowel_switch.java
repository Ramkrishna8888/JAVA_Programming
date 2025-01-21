// how to take input of character and use of switch statement
// given character is a vowel or not 
import java.util.*;
public class vowel_switch {
   public static void main(String[] args)
   {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter any character");
	   char inp = sc.next().charAt(0);
	   switch(inp)
	   {
	   case 'a':
	   case 'A':
		   System.out.println(inp+" is a vowel");
	       break;
	   case 'e':
	   case 'E':
		   System.out.println(inp+" is a vowel");
	       break;
	   case 'i':
	   case 'I':
		   System.out.println(inp+"is a vowel");
	       break;
	   case 'o':
	   case 'O':
		   System.out.println(inp+" is a vowel");
	       break;
	   case 'u':
	   case 'U':
		   System.out.println(inp+" is a vowel");
		   break;
	   default:
		   System.out.println(inp+" is not a vowel");
	   }
	   
   }
}
