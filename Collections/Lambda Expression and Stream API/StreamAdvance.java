/*Earphone management platform designed to provide detailed information about each earphone, including brand, release date, price, and rating. The platform offers various functionalities using Java streams to enhance user experience.

Create a Java application that uses streams to perform the same task.

Requirements:

1.      Retrieve earphones by a specified brand name.

2.      Retrieve earphones within a specified price range.

Component Specification: Earphone (POJO Class)

Type(Class) Earphone 
Attributes
 String brandName

LocalDate releaseDate

double price

double rating

Methods
 
Getters and setters, toString, no-argument, and four-argument constructors are given in the code skeleton.
 




Component Specification: EarphoneUtil (Utility class)
Type (Class)  EarphoneUtil
 
Methods  

public Stream<Earphone> getEarphonesByBrandName(Stream<Earphone> earphoneStream, String brandName)
 
Responsibilities
 
This method takes a stream of Earphone objects and a brandName as input parameters. It filters the earphones from the provided stream by the specified brandName and returns a stream of the filtered earphone objects.
 

EarphoneUtil
 
public List<Earphone> getEarphonesWithinPriceRange(Stream<Earphone> earphoneStream, double minimumPrice, double maximumPrice)

 
This method takes a stream of Earphone objects, minimumPrice and maximumPrice as input parameters. It filters the earphones from the provided stream to find those whose prices fall within the specified range and returns a list of these earphones. 

Condition:

•Both minimumPrice and maximumPrice are inclusive.

 

 

In the UserInterface class, the main method gets the total number of earphones and their details from the user, creates Earphone objects, stores them in a list, and performs various operations based on user input.

Get the brand name from the user. Invoke the getEarphonesByBrandName() method to filter earphones by the specified brand. If earphones are found, display them using the toString() method. If no earphones are found, print "No earphones found for the brand <brandName>".

Get the minimum and maximum price range from the user. Invoke the getEarphonesWithinPriceRange() method to retrieve earphones within the specified price range. If earphones are found, display them using the toString() method. If no earphones are found,print "No earphones found within the price range <minimumPrice> to <maximumPrice>".

Assumptions

•The number of earphones needed to be entered into the list is always a valid positive number.
•The earphone details provided by the user are always valid.
•The specified price range entered by the user for filtering earphones is a valid positive number.
•The brand name specified by the user for filtering earphones is a valid name.


Note:
•In the sample input / output provided, thehighlighted text in bold corresponds to the input given by the user, andthe rest of the text represents the output.
•Ensure to follow the object-oriented specifications provided in the question description. 
•Ensure to provide the names for classes, attributes, and methods as specified in the question description.
•Adhere to the code template, if provided.
•Do not use System.exit(0) toterminate the code.

Sample Input / Output 1

Enter the number of earphones

5

Enter the earphone details

LG:2023-01-01:15000.00:4.5

Panasonic:2022-06-15:12500.00:4.7

JBL:2021-12-25:10000.00:4.3

Panasonic:2023-06-18:13000.00:4.8

Boat:2022-12-10:12500.00:4.6

Enter the brand name

Panasonic

Earphones by brand Panasonic are

Panasonic|2022-06-15|12500.0|4.7

Panasonic|2023-06-18|13000.0|4.8

Enter the minimum and maximum price range

12500

15000

Earphones within the price range 12500.0 to 15000.0 are

LG|2023-01-01|15000.0|4.5

Panasonic|2022-06-15|12500.0|4.7

Panasonic|2023-06-18|13000.0|4.8

Boat|2022-12-10|12500.0|4.6

 

Sample Input / Output 2

Enter the number of earphones

2

Enter the earphone details

Boat:2023-02-10:11800.00:4.2

Apple:2022-08-20:12200.00:4.4

Enter the brand name

LG

No earphones found for the brand LG

Enter the minimum and maximum price range

13500

15000

No earphones found within the price range 13500.0 to 15000.0
*/

import java.time.*;
import java.util.*;
import java.util.stream.*;

public class Earphone {

	private String brandName;
	private LocalDate releaseDate;
	private double price;
	private double rating;

	public Earphone() {
		super();
	}

	public Earphone(String brandName, LocalDate releaseDate, double price, double rating) {
		super();
		this.brandName = brandName;
		this.releaseDate = releaseDate;
		this.price = price;
		this.rating = rating;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return brandName + "|" + releaseDate + "|" + price + "|" + rating;
	}
}
public class EarphoneUtil {

	public Stream<Earphone> getEarphonesByBrandName(Stream<Earphone> earphoneStream, String brandName) {
		
	Stream<Earphone> filteredStream =	earphoneStream.filter(e -> e.getBrandName().equalsIgnoreCase(brandName));		
		return filteredStream;
	}

	public List<Earphone> getEarphonesWithinPriceRange(Stream<Earphone> earphoneStream, double minimumPrice, double maximumPrice) {
		List<Earphone> range = earphoneStream.filter(e -> e.getPrice()>=minimumPrice && e.getPrice()<=maximumPrice).collect(Collectors.toList());
		
		return range;
	}
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Earphone> list = new ArrayList<>();
        EarphoneUtil obj = new EarphoneUtil();
        
        System.out.println("Enter the number of earphones");
        int size = sc.nextInt();
         sc.nextLine();
         
         System.out.println("Enter the earphone details");
         for(int i = 0; i<size; i++) {
        	 String details = sc.nextLine();
        	 String[] arr = details.split(":");
        	 
        	 String brandName = arr[0];
        	 LocalDate date = LocalDate.parse(arr[1]);
        	 double price = Double.parseDouble(arr[2]);
        	 double rating = Double.parseDouble(arr[3]);
        	 
        	  Earphone obj2 = new Earphone(brandName, date, price, rating);
        	  list.add(obj2);
        	 
        	 //list.add(new Earphone(brandName,date,price,rating));
         }
       
         System.out.println("Enter the brand name");
         String brand = sc.nextLine();
         
        Stream<Earphone> filteredStream = obj.getEarphonesByBrandName(list.stream(), brand);
        List<Earphone> filteredList = filteredStream.collect(Collectors.toList()); 
        
        if(filteredList.isEmpty()) {
        	System.out.println("No earphones found for the brand "+brand);
        }
        else {
        	 System.out.println("Earphones by brand "+brand+" are");
        	 for(Earphone e : filteredList) {
        		 System.out.println(e);
        	 }
        }
        
        System.out.println("Enter the minimum and maximum price range");
        double minimumPrice = sc.nextDouble();
        double maximumPrice = sc.nextDouble();
        sc.nextLine();
        
        List<Earphone> priceRange = obj.getEarphonesWithinPriceRange(list.stream(), minimumPrice, maximumPrice);
         if(priceRange.isEmpty()) {
        	 System.out.println("No earphones found within the price range "+minimumPrice+" to "+maximumPrice);
         }
         else {
        	 System.out.println("Earphones within the price range "+minimumPrice+" to "+maximumPrice+" are");
        	 for(Earphone e : priceRange) {
        		 System.out.println(e);
        	 }
         }
       
    }
}
