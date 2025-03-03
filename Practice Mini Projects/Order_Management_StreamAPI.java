/*
 
 INPUT & OUTPUT
 
 Enter number of orders
5
Enter order details (orderId : Customer name : Product Category : total Amount : Order Status)
101:Alice:Electronics:500.75:Shipped
102:Bob:Clothing:150.50:Pending
103:Alice:Books:200.00:Delivered
104:Charlie:Electronics:800.00:Shipped
105:Bob:Books:120.00:Delivered
Enter customer name to search orders:
bob
Orders found for customer bob
102 Bob Clothing 150.5 Pending
105 Bob Books 120.0 Delivered
Enter price range (min max)
100 500
Orders in price range 100.0 and 500.0 is
102 Bob Clothing 150.5 Pending
103 Alice Books 200.0 Delivered
105 Bob Books 120.0 Delivered
Enter product category to search orders
Books
Orders in category Books
103 Alice Books 200.0 Delivered
105 Bob Books 120.0 Delivered
Most Expensive order:
104 Charlie Electronics 800.0 Shipped
Enter order status to count:
Shipped
Total orders with status 'Shipped':2
 */

import java.util.*;
import java.util.stream.*;

class Order {
    private int orderId;
    private String customerName;
    private String productCategory;
    private double totalAmount;
    private String orderStatus;

    public Order(int orderId, String customerName, String productCategory, double totalAmount, String orderStatus) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productCategory = productCategory;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getProductCategory() { return productCategory; }
    public double getTotalAmount() { return totalAmount; }
    public String getOrderStatus() { return orderStatus; }

    @Override
    public String toString() {
        return orderId + " " + customerName + " " + productCategory + " " + totalAmount + " " + orderStatus;
    }
}

class OrderUtility {

    // 1. Get orders by customer name
    public Stream<Order> getOrdersByCustomer(Stream<Order> orderStream, String customerName) {
          return orderStream.filter(e->e.getCustomerName().equalsIgnoreCase(customerName));
    }

    // 2. Get orders in a given price range
    public Stream<Order> getOrdersInPriceRange(List<Order> orderList, double minPrice, double maxPrice) {
       return orderList.stream().filter(e -> e.getTotalAmount()>=minPrice && e.getTotalAmount()<=maxPrice);
    }

    // 3. Get orders by product category
    public Stream<Order> getOrdersByCategory(Stream<Order> orderStream, String category) {
         return orderStream.filter(e -> e.getProductCategory().equalsIgnoreCase(category));
    }

    // 4. Find the order with the highest total amount
    public Optional<Order> getMostExpensiveOrder(List<Order> orderList) {
        return orderList.stream().max(Comparator.comparingDouble(Order::getTotalAmount));
    }

    // 5. Count orders with a specific status
    public long countOrdersByStatus(List<Order> orderList, String status) {
       return orderList.stream().filter(e->e.getOrderStatus().equalsIgnoreCase(status)).count();
    }
}

public class OrderManagementStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      OrderUtility obj = new OrderUtility();
      List<Order> list = new ArrayList<>();
      
      System.out.println("Enter number of orders");
      int size = sc.nextInt();
      sc.nextLine();
      
      System.out.println("Enter order details (orderId : Customer name : Product Category : total Amount : Order Status)");
      for(int i = 0; i<size; i++) {
    	  String details = sc.nextLine();
    	  
    	  String[] arr = details.split(":");
    	  int orderId = Integer.parseInt(arr[0]);
    	  String customerName = arr[1];
    	  String productCategory = arr[2];
    	  double totalAmount = Double.parseDouble(arr[3]);
    	  String orderStatus =  arr[4];
    	  Order obj2 = new Order(orderId,customerName,productCategory,totalAmount,orderStatus);
    	  list.add(obj2);
      }
       
      System.out.println("Enter customer name to search orders:");
      String custName = sc.nextLine();
      
      Stream<Order> s1 = obj.getOrdersByCustomer(list.stream(), custName);
      List<Order> newList1 = s1.collect(Collectors.toList());
        if(newList1.isEmpty()) {
    	  System.out.println("No order found");
      }
      else {
    	  System.out.println("Orders found for customer "+custName);
    	  for(Order i : newList1) {
    		  System.out.println(i);
    	  }
      }
      
        System.out.println("Enter price range (min max)");
        double min = sc.nextDouble();
        double max = sc.nextDouble();
        
        sc.nextLine();
        
        Stream<Order> s2 = obj.getOrdersInPriceRange(list, min, max);
        List<Order> newList2 = s2.collect(Collectors.toList());
        if(newList2.isEmpty()) {
        	System.out.println("No orders found in the given range");
        }
        else {
        	System.out.println("Orders in price range "+min+" and "+max+" is");
        	for(Order i : newList2) {
        		System.out.println(i);
        	}
        }
        
        System.out.println("Enter product category to search orders");
        String searchProduct = sc.nextLine();
        
        Stream<Order> s3 = obj.getOrdersByCategory(list.stream(), searchProduct);
        List<Order> newList3 = s3.collect(Collectors.toList());
        if(newList3.isEmpty()) {
        	System.out.println("No product found in the given category");
        }
        else {
        	System.out.println("Orders in category "+searchProduct);
        	for(Order i : newList3) {
        		System.out.println(i);
        	}
        }
        
        
        Optional<Order> o1 = obj.getMostExpensiveOrder(list);
        if(!o1.isPresent()) {
        	System.out.println("No orders found");
        }
        else {
        	System.out.println("Most Expensive order:");
           System.out.println(o1.get());   
        	
        }
        
        System.out.println("Enter order status to count:");
        String checkStatus = sc.nextLine();
        
        long status = obj.countOrdersByStatus(list, checkStatus);
        	System.out.println("Total orders with status '"+checkStatus+"':"+status);
    }
}
