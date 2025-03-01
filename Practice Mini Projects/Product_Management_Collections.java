/*

INPUT AND OUTPUT

Enter number of records to be added
4
Enter the records (Customer Name:Product)
Alice:Laptop
Bob:Monitor
Charlie:Keyboard
Ram:Laptop
Enter the product to be searched
Laptop
The number of customer who purchased Laptop is 2
Enter the product to identify the customer Names
Laptop
Customer names who purchased Laptop are
Alice
Ram
Enter the Customer name to find the Product purchased
Ram
Product purchased by Ram is Laptop
*/

import java.util.*;

class SalesTracker {
    private Set<String> salesSet;
    
    // Constructor
    public SalesTracker() {
        salesSet = new HashSet<>();
    }
    
    // Setter and Getter for salesSet
    public void setSalesSet(Set<String> salesSet) {
        this.salesSet = salesSet;
    }
    
    public Set<String> getSalesSet() {
        return salesSet;
    }
    
    // Requirement 1: Method to add a sales record
    public void addSalesRecord(String record) {
    	salesSet.add(record);
    	
    }
    
    // Requirement 2: Count unique customers for a product
    public int findNumberOfCustomersByProduct(String product) {
    	int count = 0;
       for(String s : salesSet) {
    	   String[] arr = s.split(":");
    	   if(arr.length == 2 && arr[1].equalsIgnoreCase(product)) {
    		   count++;
    		   }
       }
       return count;
       }
    // Requirement 3: Retrieve customers who bought a product
    public List<String> getCustomersByProduct(String product) {
        
    	List<String> list= new ArrayList<>();
         for(String r : salesSet) {
        	 String arr[] = r.split(":");
        	 if(arr.length == 2 && arr[1].equalsIgnoreCase(product))
        	 list.add(arr[0]);
         }
        return list;
    }
    
    // Requirement 4: Find product by customer name
    public String getProductByCustomer(String customerName) {
         
    	for(String s : salesSet) {
    		String arr[] = s.split(":");
    	    if(arr.length == 2 && arr[0].equals(customerName)) {
    	    	return arr[1];
    	    }
    	}
    	   return ""; // return null;
    }
}

public class productManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       SalesTracker obj = new SalesTracker();
        
        System.out.println("Enter number of records to be added");
        int size = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the records (Customer Name:Product)");
        for(int i = 0; i<size; i++) {
        	String record = sc.nextLine();
        	obj.addSalesRecord(record);
        }
        
        System.out.println("Enter the product to be searched");
        String search = sc.nextLine();
        int res = obj.findNumberOfCustomersByProduct(search);
        if(res==0) {
        	System.out.println("Customers not found");
        }
        else {
        	System.out.println("The number of customer who purchased "+search+" is "+res);
        }
        
       System.out.println("Enter the product to identify the customer Names");
       String productSearch = sc.nextLine();
       List<String> list =  obj.getCustomersByProduct(productSearch);
        if(list.isEmpty()) {
        	System.out.println("Customers not found");
        }
        else {
        	System.out.println("Customer names who purchased "+productSearch+" are");
        	  for(String names : list)
        	System.out.println(names);
        }
        
        
      System.out.println("Enter the Customer name to find the Product purchased");
       String customerSearch = sc.nextLine();
       
       String productFound = obj.getProductByCustomer(customerSearch);
        if(productFound.isEmpty()) {
        	System.out.println("Customer not found");
        }
        else {
        	System.out.println("Product purchased by "+customerSearch+" is "+productFound);
        }
       
    
    }
}
