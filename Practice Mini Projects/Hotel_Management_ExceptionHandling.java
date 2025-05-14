package capgemini_practice;

import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.Period;

class InvalidBookingDetailsException extends Exception{
	public InvalidBookingDetailsException(String excep) {
		super(excep);
	}
}

class HotelBooking{
	
	 //1.
	  public boolean validUserDetails(int age, String email, String creditCard) throws InvalidBookingDetailsException {
		  if(age<18 || age>100) {
			  throw new InvalidBookingDetailsException("Invalid age");
		  }
		  String emailRegex = "[a-z]+@gmail.com";
		  if(!email.matches(emailRegex))
		  {
			  throw new InvalidBookingDetailsException("Email format is incorrect");
		  }
		  if(!creditCard.matches("[0-9]{16}")) {
			  throw new InvalidBookingDetailsException("Credit card no. is invalid");
		  }
		  return true;
	  }
	  
	  //2.
	  public boolean validBookingDetails(String hotelName, String roomType, LocalDate checkInDate, LocalDate checkOutDate) throws InvalidBookingDetailsException {
		  
		  if(!hotelName.equals("Hilton")&&!hotelName.equals("Marriot")&&!hotelName.equals("Taj")) {
			  throw new InvalidBookingDetailsException("Invalid hotel name");
		  }
		  
		  if(!roomType.equalsIgnoreCase("Standard")&&!roomType.equalsIgnoreCase("Deluxe")&&!roomType.equalsIgnoreCase("Suite")) {
			  throw new InvalidBookingDetailsException("Invalid room Type");
		  }
		  	  
		  
		  if(checkInDate==null || checkOutDate==null) {
			  throw new InvalidBookingDetailsException("Invalid date ");
		  }
		  
		  if(checkInDate.isBefore(LocalDate.now())) {
			  throw new InvalidBookingDetailsException("Invalid check-in Date");
		  }
		  
		  if(checkOutDate.isBefore(checkInDate)) {
			  throw new InvalidBookingDetailsException("Invalid check-out Date");
		  }	
		  
		  
		  return true;
	  }
	  
	  //3. 
	  
	  public double calculateBookingCost(String roomType, int numNights, boolean breakfastIncluded) throws InvalidBookingDetailsException{
		 
		  double totalCost = 0; 
		  if(roomType.equalsIgnoreCase("Standard")) {
			  totalCost = numNights*1000;
		  }
		  if(roomType.equalsIgnoreCase("Deluxe")) {
			  totalCost = numNights*2000;
		  }
		  if(roomType.equalsIgnoreCase("Suite")) {
			  totalCost = numNights*3000;
		  }
		  
		  if(breakfastIncluded) {
			  totalCost = totalCost + (numNights*100);
		  }	  
		  
		  return totalCost;
	  }
}

public class HotelManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		HotelBooking obj = new HotelBooking();
		
		try {		
		System.out.println("Enter Name");
		String name = sc.nextLine();
		
		System.out.println("Enter age");
		int age = sc.nextInt();
		sc.nextLine();
        
		
		System.out.println("Enter Email");
		String email = sc.nextLine();
		
		System.out.println("Enter Credit Card Number");
		String creditCard = sc.nextLine();
		
		if(obj.validUserDetails(age, email, creditCard)) {
		
		System.out.println("Enter Hotel Name");
		String hotel = sc.nextLine();
		
		System.out.println("Select Room type");
		String roomType = sc.nextLine();
		
		System.out.println("Enter Check-in Date (yyyy-MM-dd)");
		String stringCechkIn = sc.nextLine();
		LocalDate checkIn = LocalDate.parse(stringCechkIn, format);
		
		System.out.println("Enter Check-out-Date (yyyy-MM-dd)");
		String stringCheckOut = sc.nextLine();
		LocalDate checkOut = LocalDate.parse(stringCheckOut, format);
		 
		if(obj.validBookingDetails(hotel, roomType, checkIn, checkOut)){
			
			Period period = Period.between(checkIn, checkOut);
			int days = period.getDays();
			
			double total = obj.calculateBookingCost(roomType, days, false);
			
			System.out.printf("Total Booking Cost: $%.2f",total);
			
		}
		
		}
		
		}
		catch(InvalidBookingDetailsException e) {
			 System.err.println(e); 
		}
		
		
		
		

	}

}
