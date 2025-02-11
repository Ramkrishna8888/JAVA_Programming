// don't know Why I've made this program haha..
// But you're gonna learn a lot of things by this program

import java.util.*;
public class UserInterface
{
    void checkValid(String id){
        
        if(id.length()!=8){
            System.out.println(id+" is an invalid length");
            return;
        }
        
        String regex1 = "^[A-Z]{3}[0-9]{5}$";
        if(!id.matches(regex1))
        {
            
          System.out.println(id+" is an invalid format");
            return;
            
        }
        else
        {
              String takeFirstDig = id.substring(3);
            int checkFirstDig = Integer.parseInt(takeFirstDig);
            if(checkFirstDig==0)
            {
                System.out.println(checkFirstDig+" is an invalid digit");
                 return;
            }
           
          
          String takeAge = id.substring(7);
          int checkAge = Integer.parseInt(takeAge);
          
          if(checkAge==1){
              System.out.println("Age group belongs to 20 - 30");
          }
          else if(checkAge==2){
              System.out.println("Age group belongs to 30 - 40");
          }
          else{
              System.out.println("Age is not eligible");
          }
        }
    }
    
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter the message");
	  String id = sc.nextLine();
	  
	  UserInterface obj = new UserInterface();
	   obj.checkValid(id);
	  
	}
}
