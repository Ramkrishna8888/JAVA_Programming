// Constructor Syntax 
import java.util.*;
class Sample{
     int i,j;
	Sample(int i, int j)
	{
       // when your data member and arguments have the same name then you can use this keyword so that compiler can understand
		this.i= i;
		this.j = j;
	}
	void disp()
	{
		System.out.println("value of i "+i+" and value of j is "+j);
	}
}
public class constructor1 {
     public static void main(String[] args)
     {
    	 Sample obj = new Sample(10,20); // constuctor automatically called
    	 obj.disp();
    	 
     }
}
