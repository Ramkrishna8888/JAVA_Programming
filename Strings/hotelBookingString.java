import java.util.*;
public class HotelbookingString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the customer details");
		String details = sc.nextLine();

		String[] arr1 = details.split(":");
		
		String name = arr1[0];
		int adults,childs,days;
		try {
		adults = Integer.parseInt(arr1[1]);
		childs = Integer.parseInt(arr1[2]);
		days = Integer.parseInt(arr1[3]);
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid input format");
			return;
		}
		
		if(adults<0) {
			System.out.println("Invalid input for the adults");
		    return;
		}
		if(childs<0) {
			System.out.println("Invalid input for the childs");
		    return;
		}

		if(days<=0) {
			System.out.println("Invalid input for the days");
			return;
		}
		
		int bill = ((adults*1000) + (childs*650)) * days; 
		
		System.out.println(name+" your booking is confirmed and the total cost is "+bill);
	
	}

}
