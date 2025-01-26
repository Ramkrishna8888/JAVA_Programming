// basic question to understand before diving into string tricky questions
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String num = sc.next();
        int i = num.length()-1;
        String reverse = "";
        while(i>=0)
        {
           reverse=reverse+num.charAt(i);
           i--;
        }
        System.out.println(reverse);
        
    }
}
