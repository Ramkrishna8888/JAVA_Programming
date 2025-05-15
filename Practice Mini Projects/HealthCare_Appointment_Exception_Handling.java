package capgemini_practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Exception 1.
class InvalidAppointmentException extends Exception{
	public InvalidAppointmentException(String excep) {
		super(excep);
	}
}

// Exception 2.
class UnavailableDoctorException extends Exception{
	public UnavailableDoctorException(String excep) {
		super(excep);
	}
}

class AppointmentBookingSystem{
	
	//1.
	public boolean validatePatientDetails(int age, String phoneNumber, String insuranceId) throws InvalidAppointmentException{
		if(age<1 || age>120) {
			throw new InvalidAppointmentException("Invalid age");
		}
		
		if(!phoneNumber.matches("[0-9]{10}"))
		{
			throw new InvalidAppointmentException("Invalid phone Number");
		}
		
		if(!insuranceId.matches("[A-Z].*[0-9].*")) {
			throw new InvalidAppointmentException("Invalid Insurance ID");
		}
		
		return true;
	}
	
	//2.
	public boolean validateDoctorAvailability(String doctorSpecialization, LocalDateTime appointmentDateTime) throws UnavailableDoctorException{
		
		if(!doctorSpecialization.equalsIgnoreCase("Cardiology")&&!doctorSpecialization.equalsIgnoreCase("Dermatology")&&!doctorSpecialization.equalsIgnoreCase("pediatrics")) {
			throw new UnavailableDoctorException("Doctor Specialization not available");
		}
		
		LocalTime startTime = LocalTime.of(10, 0);
		LocalTime endTime = LocalTime.of(17, 0);
		
		LocalTime appointmentTime = appointmentDateTime.toLocalTime();
		
		
		if(appointmentDateTime.isBefore(LocalDateTime.now()) || appointmentTime.isBefore(startTime) ||  appointmentTime.isAfter(endTime)){
			throw new UnavailableDoctorException("Doctor not available at specified time");
		}		
		
		
		return true;
	}
	
	//3.
	public void scheduleAppointment(String patientName, String doctorSpecialization, LocalDateTime appointmentDateTime) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d'th' MMMM yyyy");		
		String newDateFormat = appointmentDateTime.format(formatter);
		LocalTime time = appointmentDateTime.toLocalTime();
		
		
		if(doctorSpecialization.equalsIgnoreCase("Cardiology")) {
			
			System.out.println("Appointment scheduled successfully with Dr. Smith (Cardiology) on "+newDateFormat+" at "+time);
		}
		else if(doctorSpecialization.equalsIgnoreCase("Dermatology")) {
			System.out.println("Appointment scheduled successfully with Dr. corner (Dermatology) on "+newDateFormat+" at "+time);
		}
		else if(doctorSpecialization.equalsIgnoreCase("pediatrics")) {
			System.out.println("Appointment scheduled successfully with Dr. jener (pediatrics) on "+newDateFormat+" at "+time);
		}
		else {
			System.out.println("Doctor of the given specialization is not available");
		}
		
	}
	
	
}

public class HealthCareAppointmentBooking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AppointmentBookingSystem obj = new AppointmentBookingSystem();
		
		try {
		System.out.println("Enter patient name:");
		String name = sc.nextLine();
		
		System.out.println("Enter age:");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter phone number:");
		String phoneNo = sc.nextLine();
		
		System.out.println("Enter Insurance ID:");
		String iD = sc.nextLine();
		
		System.out.println("Enter doctor specialization");
		String specialization = sc.nextLine();
		
		System.out.println("Enter appointment date/time (yyyy-MM-dd HH:mm)");
		String date = sc.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateAndTime = LocalDateTime.parse(date, formatter);
		
		if(obj.validatePatientDetails(age, phoneNo, iD)){
			if(obj.validateDoctorAvailability(specialization, dateAndTime)) {
				obj.scheduleAppointment(name, specialization, dateAndTime);
			}
			
		}
			
		}
		catch (InvalidAppointmentException e) {
			System.err.println(e);
		}
		catch (UnavailableDoctorException f) {
			System.err.println(f);
		}
		

	}

}
