import java.util.*;
import java.lang.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        String num = sc.nextLine();
        
        try{
            int number = Integer.parseInt(num);
            System.out.println(number);
        }
        catch(NumberFormatException e){
            
            System.out.println("String conversion into integer is not possible");
        }
        
        
    }
}
