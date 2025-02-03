// getter setters use
import java.util.*;
class vehicle{
	private int speed;
	private int time;
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed<=0 || speed>=20) {
			System.out.println("The value is out of range (0 - 20) exclusive");
			System.exit(0);
		}
		this.speed = speed;
		
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		
		if(time <=0 || time>=30) {
			System.out.println("Time out of range (0-30) exclusive");
			System.exit(0);
		}
		this.time = time;
	}
	public int Distance() {
		return speed*time;
	}
}
public class inherit1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vehicle obj = new vehicle();
		System.out.println("Enter the speed");
		obj.setSpeed(sc.nextInt());
;
		System.out.println("Enter the time");
		obj.setTime(sc.nextInt());
		
	   int distance =	obj.Distance();
		System.out.println("The distance is "+distance);
	}

}
