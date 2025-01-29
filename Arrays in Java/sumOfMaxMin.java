import java.util.Scanner;
public class UserInterface{
    
    public static void main(String[] args){
        
       Scanner sc=new Scanner(System.in);
       int i =0;
       int max = Integer.MIN_VALUE;
       int min = Integer.MAX_VALUE;
        System.out.println("Enter the array size");
        int size = sc.nextInt();
        if(size%2==1)
        {
            System.out.println(size+" is an odd number.Please enter even number");
        }
        else if(size<=0)
        {
            System.out.println(size+" is an invalid array size");
        }
         else{
             int[] arr = new int[size];
            System.out.println("Enter the number");
            for(i=0; i<size; i++){
                arr[i] = sc.nextInt();
            }
            for(i=0; i<size; i++)
            {
              if(arr[i]>max)
              {
                  max = arr[i];
              }
              if(arr[i]<min)
              {
                  min = arr[i];
              }
            }
            int sum = max+min;
            System.out.println("The maximum number is "+sum);
        }
    }
}
