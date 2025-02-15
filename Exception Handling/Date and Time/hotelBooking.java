import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

class InvalidBookingDetailsException extends Exception {
    public InvalidBookingDetailsException(String excep) {
        super(excep);
    }
}

class HotelBooking {
    public static void validateUserDetails(int age, String email, String creditCard) throws InvalidBookingDetailsException {
        if (age < 18 || age > 100) throw new InvalidBookingDetailsException("Invalid age");
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) throw new InvalidBookingDetailsException("Invalid email");
        if (!creditCard.matches("\\d{16}")) throw new InvalidBookingDetailsException("Invalid credit card number");
    }
    
    public static void validateBookingDetails(String hotelName, String roomType, String checkIn, String checkOut) throws InvalidBookingDetailsException {
        if (!hotelName.equals("Hilton") && !hotelName.equals("Marriott") && !hotelName.equals("Taj"))
        	throw new InvalidBookingDetailsException("Invalid hotel name");
        if (!roomType.equals("Standard") && !roomType.equals("Deluxe") && !roomType.equals("Suite"))
        	throw new InvalidBookingDetailsException("Invalid room type");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate checkInDate = LocalDate.parse(checkIn, formatter);
            LocalDate checkOutDate = LocalDate.parse(checkOut, formatter);
            if (!checkInDate.isAfter(LocalDate.now())) throw new InvalidBookingDetailsException("Invalid check-in date");
            if (!checkOutDate.isAfter(checkInDate)) throw new InvalidBookingDetailsException("Invalid check-out date");
        } catch (DateTimeParseException e) {
            throw new InvalidBookingDetailsException("Invalid date format");
        }
    }
    
    public static int calculateBookingCost(String roomType, int numNights, boolean breakfastIncluded) {
        int cost = roomType.equals("Standard") ? 1000 : roomType.equals("Deluxe") ? 2000 : 3000;
        return (cost * numNights) + (breakfastIncluded ? 100 * numNights : 0);
    }
}

public class hotelBookingException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter Name:");
            String name = sc.nextLine();
            System.out.println("Enter Age:");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Email:");
            String email = sc.nextLine();
            System.out.println("Enter Credit Card Number:");
            String creditCard = sc.nextLine();
            HotelBooking.validateUserDetails(age, email, creditCard);
            System.out.println("Enter Hotel Name:");
            String hotelName = sc.nextLine();
            System.out.println("Select Room Type:");
            String roomType = sc.nextLine();
            System.out.println("Enter Check-in Date (yyyy-MM-dd):");
            String checkIn = sc.nextLine();
            System.out.println("Enter Check-out Date (yyyy-MM-dd):");
            String checkOut = sc.nextLine();
            System.out.println("Include Breakfast? (true/false):");
            boolean breakfastIncluded = sc.nextBoolean();
            HotelBooking.validateBookingDetails(hotelName, roomType, checkIn, checkOut);
            int numNights = LocalDate.parse(checkOut).getDayOfYear() - LocalDate.parse(checkIn).getDayOfYear();
            System.out.println("Total Booking Cost: " + HotelBooking.calculateBookingCost(roomType, numNights, breakfastIncluded));
        } catch (InvalidBookingDetailsException e) {
            System.err.println(e);
        } 
    }
}
