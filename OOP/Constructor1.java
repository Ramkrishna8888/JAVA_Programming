// Constructor Syntax 
import java.util.*;
class Sample{
     int a,b;
	Sample(int i, int j)
	{
		a = i;
		b = j;
	}
	void disp()
	{
		System.out.println("value of a "+a+" and value of b is "+b);
	}
}
public class constructor1 {
     public static void main(String[] args)
     {
    	 Sample obj = new Sample(10,20); // constuctor automatically called
    	 obj.disp();
    	 
     }
}
