// Use of Date and Calender
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
public class dateUse {

	public static void main(String[] args) {
		 Date obj = new Date();
		 System.out.println(obj);
		 long millisec = System.currentTimeMillis();
		 Date obj2 = new Date(millisec);
		 System.out.println(obj2);
		 
		 // date comparison
		 
		 Date dateobj1 = new Date(2025,01,28);
		 Date dateobj2 = new Date(2025,01,25);
		 int status = dateobj1.compareTo(dateobj2);
		 if(dateobj1.after(dateobj2))
		 {
			 System.out.println("dateobj1 is after dateobj2");
		 }
		 else if(dateobj1.before(dateobj2))
		 {
			 System.out.println("dateibj2 is before dateobj2");
		 }
		 else
			 System.out.println("Both dates are same");
		 
		 //Calender
		 Calendar calendar = Calendar.getInstance();
		 
		 System.out.println("The current date is : "+calendar.getTime());
		 
		 
	}

}
