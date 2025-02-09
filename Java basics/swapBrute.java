// brute force for swap of two numbers

import java.util.*;
public class swap2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter A");
		int a = sc.nextInt();
		
		System.out.println("Enter B");
		int b = sc.nextInt();

		
		int temp = a;
		 a = b;
		 b = temp;
		 
		 System.out.println("A :"+a+"\nB :"+b);
		 
	}

}
