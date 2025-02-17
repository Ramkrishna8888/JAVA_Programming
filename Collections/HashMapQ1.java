import java.util.*;
import java.util.stream.*;

// basic input and output

class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the size of map");
        int size = sc.nextInt();
        
        sc.nextLine();
        
        Map<Integer,String> mp = new HashMap<>();
        System.out.println("Enter the values");
        
        for(int i =0; i<size; i++){
         String value = sc.nextLine();
            mp.put(i, value);
        }
        
        System.out.println("Values present in map : \n");
        
        for(Map.Entry<Integer, String> i : mp.entrySet()){
            System.out.println(i.getKey()+" "+i.getValue());
        }
        
    }
    
}
