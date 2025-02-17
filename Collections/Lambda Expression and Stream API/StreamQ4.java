// List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

import java.util.*;
import java.util.stream.*;
class GreaterStream{
    
    public int AddElements(List<Integer> numbers){
      return numbers.stream().reduce(0,(a,b)->a+b);
    }
}

class Numbers{
    private List<Integer> list = new ArrayList<>();
    
    Numbers(List<Integer> list){
        this.list = list;
    }
    
    public List<Integer> getList(){
        return list;
    }
    
    public void setList (List<Integer> list){
        this.list = list;
    }
    
    @Override
    public String toString(){
        return list.toString();
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
        System.out.println("Original List");
        Numbers original = new Numbers(list);
        System.out.println(original);
        
        System.out.println("Addition of elements");
        
        GreaterStream obj = new GreaterStream();
        int res = obj.AddElements(original.getList());
        
        System.out.println(res);
        
        sc.close();
    }
    
}
