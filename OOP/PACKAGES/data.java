// importing package operation to perform ADDITION and MULTIPLICATION
// focus on syntax
package input; // must write
import operation.calculate;
public class data {
	public static void main(String[] args)
	{
	calculate obj = new calculate();
    System.out.println("ADDITION :"+obj.add(10,20));
    System.out.println("MULTIPLICATION :"+obj.multiply(5, 10));
 }
}
