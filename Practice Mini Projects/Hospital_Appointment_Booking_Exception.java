// focus more on the use of Date time API

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.*;

class InvalidAppointmentException extends Exception {
    InvalidAppointmentException(String message) {
        super(message);
    }
}

class UnavailableDoctorException extends Exception {
    UnavailableDoctorException(String message) {
        super(message);
    }
}

class AppointmentBooking {

    boolean validatePatientDetails(int age, String phoneNumber, String insuranceId) throws InvalidAppointmentException {
        if (age < 1 || age > 120) {
            throw new InvalidAppointmentException("Invalid age");
        }

        if (!phoneNumber.matches("^[0-9]{10}$")) {
            throw new InvalidAppointmentException("Invalid phone number");
        }

        if (!insuranceId.matches("^[a-zA-Z0-9]+$")) {
            throw new InvalidAppointmentException("Invalid insurance ID");
        }

        return true;
    }

    boolean validateDoctorAvailability(String doctorSpecialization, LocalDateTime appointmentDateTime) 
            throws InvalidAppointmentException, UnavailableDoctorException {

        if (!doctorSpecialization.equals("Cardiology") &&
            !doctorSpecialization.equals("Dermatology") &&
            !doctorSpecialization.equals("Pediatrics")) {
            throw new UnavailableDoctorException("Doctor specialization not available");
        }

        if (appointmentDateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidAppointmentException("Appointment date and time should be in the future");
        }
       
       int hour = appointmentDateTime.getHour();
        if (hour < 9 || hour >= 17) {
            throw new InvalidAppointmentException("Doctor not available for this time");
        }

        return true;
    }

    void scheduleAppointment(String patientName, String doctorSpecialization, LocalDateTime appointmentDateTime) {
        System.out.println("Appointment scheduled successfully with Dr. " 
            + doctorSpecialization + " on " 
            + appointmentDateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy 'at' hh:mm a")));
    }
}

class HospitalAppointmentBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentBooking appointment = new AppointmentBooking();

        try {
            System.out.print("Enter patient name: ");
            String patient = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter phone number: ");
            String phoneNumber = sc.nextLine();

            System.out.print("Enter insurance ID: ");
            String insuranceId = sc.nextLine();

            System.out.print("Enter doctor specialization: ");
            String doctorSpecialization = sc.nextLine();

            System.out.print("Enter appointment Date and Time (yyyy-MM-dd HH:mm): ");
            LocalDateTime appointmentDateTime = LocalDateTime.parse(sc.nextLine(), 
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            appointment.validatePatientDetails(age, phoneNumber, insuranceId);
            appointment.validateDoctorAvailability(doctorSpecialization, appointmentDateTime);

            appointment.scheduleAppointment(patient, doctorSpecialization, appointmentDateTime);
            
        } catch (InvalidAppointmentException | UnavailableDoctorException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date or time format. Please enter in yyyy-MM-dd HH:mm format.");
        } 
    }
}
