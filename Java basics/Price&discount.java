import java.util.*;
public class Price {
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the item number");
    	int num = sc.nextInt();
    	System.out.println("Enter the name of item");
        String name = sc.next();
        System.out.println("Enter the rate of the item");
        int rate = sc.nextInt();
        System.out.println("Enter the Quantity of the item");
        int quantity = sc.nextInt();
        int mrp = (rate*quantity);
        double discount = 0;
        if(mrp>=1000 && mrp<2000)
        {
        	discount = 0.10*mrp;
        }
        if(mrp>=2000 && mrp<3000)
        {
        	discount = 0.15*mrp;
        }
        if(mrp>=3000 && mrp<5000)
        {
        	discount = 0.20*mrp;
        }
        if(mrp>=5000)
        {
        	discount = 0.25*mrp;
        }
        
        double Netprice = (mrp - discount);
        System.out.println("Item no.          : "+num);
        System.out.println("Item name         : "+name);
        System.out.println("Item rate         : "+rate);
        System.out.println("Item Quantity     : "+quantity);
        System.out.println("MRP of item       : "+mrp);
        System.out.println("Discount on item  : "+discount);
        System.out.println("Net price of item : "+Netprice);
    }
}
