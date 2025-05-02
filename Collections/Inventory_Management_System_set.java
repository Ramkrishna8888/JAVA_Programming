package programs;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class salesSet {
    
	private Set<String> salesDetails;
	
	public Set<String> getSalesDetails() {
		return salesDetails;
	}

	public void setSalesDetails(Set<String> salesDetails) {
		this.salesDetails = salesDetails;
	}
	
	salesSet() {
	    this.salesDetails = new HashSet<>();
	}

	
	// adding sales records
	
	public void addSalesRecord(String Record) {
		salesDetails.add(Record);
	}
	
	// find no. of customers by product
	
	public int findNumberOfCustomersByProduct(String product) {
		Set<String> Customers = new HashSet<>();
		
		for(String i : salesDetails) {
			String arr[] = i.split(":");
			if(arr.length==2 && arr[1].equals(product)) {
				Customers.add(arr[0]);
			}
		}
		if(Customers.isEmpty()) {
			return -1;
		}
		
		return Customers.size();
	}
	
	// get customers by product
	
	public List getCustomersByProduct(String product){
		List<String> Customers = new ArrayList<>();
		
		for(String i : salesDetails) {
			String arr[] = i.split(":");
			if(arr.length==2 && arr[1].equals(product)) {
				Customers.add(arr[0]);
			}
		}
		return Customers;
	}
	
	public List getProductByCustomer(String customerName) {
		
       List<String> Customers = new ArrayList<>();
       for(String i : salesDetails) {
    	   String arr[] = i.split(":");
    	   if(arr.length==2 && arr[0].equals(customerName)) {
    		   Customers.add(arr[1]);
    	   }
       }
       
		return Customers;
	}
	

}

public class inventory_management_system {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	salesSet obj = new salesSet();
    	String details = "";
    	
    	System.out.println("Enter number of records to be added");
    	int size = sc.nextInt();
    	
    	sc.nextLine();
    	
    	System.out.println("Enter the records (Customer Name : Product)");
    	for(int i = 0; i<size; i++) { 
    	  details = sc.nextLine();
    	  obj.addSalesRecord(details);
    	}
    	
    	// finding number of customers by product
    	
    	System.out.println("Enter the product to be searched");
    	String searchItem = sc.nextLine();
    	
    	int res = obj.findNumberOfCustomersByProduct(searchItem);
    	if(res<=0) {
    		System.out.println("No customers found");
    	}
    	else {
    		System.out.println("The number of customers who purchased laptop is "+res);
    	}
    	
    	// getting customers by product
    	
    	System.out.println("Enter the product to identify the Customer Names");
    	 String searchItem2 = sc.nextLine();
    	 
    	 List<String> totalCustomers = obj.getCustomersByProduct(searchItem2);
    	  
    	 if(totalCustomers.isEmpty()) {
    		 System.out.println("No customers found");
    	 }
    	 else {
    		 System.out.println("Customer names who purchased "+searchItem2+" are");
    		 for(String i : totalCustomers) {
    			 System.out.println(i);
    		 }
    	 }
    	 
    	 // get product by customer name
    	 
    	 System.out.println("Enter the Customer name to find the product purchased");
    	 String searchCustomer = sc.nextLine();
    	 
    	 List<String> totalProducts = obj.getProductByCustomer(searchCustomer);
    	 
    	 if(totalProducts.isEmpty()) {
    		 System.out.println("No customers found");
    	 }
    	 else {
    		 System.out.println("Product purchased by "+searchCustomer+" is ");
    	     for(String i : totalProducts) {
    	    	 System.out.println(i);
    	     }
    		 
    	 }
    	
    }
	
	
}
