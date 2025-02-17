// Find all even numbers in a list 

import java.util.*;
import java.util.stream.*;
class EvenStream{
    
    public List<Integer> getEvenNums(List<Integer> numbers){
      return numbers.stream().filter(e->e%2==0).collect(Collectors.toList());
    }
    
    
}

class Numbers{
    private List<Integer> l1 = new ArrayList<>();
    
    Numbers(List<Integer> l1){
        this.l1 = l1;
    }
    
    public List<Integer> getL1(){
        return l1;
    }
    
    public void setL1 (List<Integer> L1){
        this.l1 = l1;
    }
    
    @Override
    public String toString(){
        return l1.toString();
    }
    
}

class Main{
    public static void main(String[] args){
     
     Scanner sc = new Scanner(System.in);   
     System.out.println("Enter the size of list");
      int size = sc.nextInt();
      List<Integer> list = new ArrayList<>();
      for (int i =0; i<size; i++){
          list.add(sc.nextInt());
      } 
      
      System.out.println("Original list");
      Numbers obj = new Numbers(list);
      System.out.println(obj);
      
      
      System.out.println("\nEvenStreamven digits present in the list");
      EvenStream obj2 = new EvenStream();
      List<Integer> result = obj2.getEvenNums(obj.getL1());
      System.out.println(result);
      
    }
}
