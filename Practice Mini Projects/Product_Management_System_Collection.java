import java.util.*;
/*
 Enter the no. of Apartment
4
A101:1500
A102:1800
A103:2000
A104:2500
Find total rent in a given range
1500
2000
there are total 3.0 found in the range
Enter the Apartment name to be removed
A104
Apartment removed Successfully
Update the rent of an Apartment
Enter an Existing apartment number
A103
Enter new rent for the apartment
2500
New Rent of Apartment no. A103 is 2500.0
Apartment with the heighest Rent is A103
Apartment with the Lowest Rent is A101
Total no. of Apartments
Total no. of apartment present is 3
Get all apartment in a given rent range
Enter min Rent
1500
Enter max Rent
2500
A102
A103
A101

EDGE CASES

Enter the no. of Apartment
4
A101:1500
A102:1800
A103:2000
A104:2500
Find total rent in a given range
1500
2800
there are total 4.0 found in the range
Enter the Apartment name to be removed
A111
Apartment not found
Update the rent of an Apartment
Enter an Existing apartment number
A109
Enter new rent for the apartment
2000
Apartment no. does not exist
Apartment with the heighest Rent is A104
Apartment with the Lowest Rent is A101
Total no. of apartment present is 4
Get all apartment in a given rent range
Enter min Rent
3000
Enter max Rent
6000
No apartment found in the given range
 
 */


class Apartment {
    private String apartmentNumber;
    private double rent;

    // Constructor
    public Apartment(String apartmentNumber, double rent) {
        this.apartmentNumber = apartmentNumber;
        this.rent = rent;
    }

    // Getters
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public double getRent() {
        return rent;
    }

    // Setters
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
}

class PropertyManagement {
    private Map<String, Double> apartmentDetailsMap;

    // Constructor
    public PropertyManagement() {
        this.apartmentDetailsMap = new HashMap<>();
    }

    // Getter
    public Map<String, Double> getApartmentDetailsMap() {
        return apartmentDetailsMap;
    }

    // Setter
    public void setApartmentDetailsMap(Map<String, Double> apartmentDetailsMap) {
        this.apartmentDetailsMap = apartmentDetailsMap;
    }

    
    
    
    // Method to add an apartment
    public void addApartmentDetails(String apartmentNumber, double rent) {
         getApartmentDetailsMap().put(apartmentNumber, rent);
    	
    }

    //1. Method to find total rent in a given range
    public double findTotalRentOfApartmentsInTheGivenRange(double minRent, double maxRent) {
         double total = 0;
    	for(Map.Entry<String, Double> mp : apartmentDetailsMap.entrySet()) {
        	  if(mp.getValue()>=minRent && mp.getValue()<=maxRent)
        	  {
        		  total++;
        	  }
         }
    	return total;
    }
     
    // 2.
    public boolean removeApartment(String apartmentNumber) {
             if(apartmentDetailsMap.containsKey(apartmentNumber)) {
    	    	apartmentDetailsMap.remove(apartmentNumber);	
    	    	return true;
             }
    	return false;
    }

    // 3. Update the rent of an existing apartment
    public boolean updateRent(String apartmentNumber, double newRent) {
    	if(apartmentDetailsMap.containsKey(apartmentNumber)) {
    	apartmentDetailsMap.replace(apartmentNumber, newRent);
    	return true;
    	}
     return false; 
    }

    // 4. Find the apartment with the highest rent
    public String findApartmentWithHighestRent() {
        double max = Double.MIN_VALUE; // 10, 20, 30, 40
        String apartment = "";
    	for(Map.Entry<String , Double> mp : apartmentDetailsMap.entrySet()){
           if(mp.getValue()>max) {
        	   max = mp.getValue();
               apartment = mp.getKey();
           }
        }
         return apartment;
    }

    // 5. Find the apartment with the lowest rent
    public String findApartmentWithLowestRent() {
        double min = Double.MAX_VALUE; 
    	String apartment = ""; // 10, 20, 30, 40
    	for(Map.Entry<String, Double> mp : apartmentDetailsMap.entrySet()) {
    		if(mp.getValue()<min) {
    			min = mp.getValue();
    			apartment = mp.getKey();
    		}
    	}
   	 return apartment;
    }

    // 6. Count the total number of apartments available
    public int getTotalApartments() {
    	int count = 0;
      for(Map.Entry<String, Double> mp : apartmentDetailsMap.entrySet()) {
    	  count++;
      }
    	return count;
    }

    // 7. Get all apartments within a given rent range
    public List<String> getApartmentsInRange(double minRent, double maxRent) {
       List<String> apartmentInRange = new ArrayList<>();
       for(Map.Entry<String, Double> mp : apartmentDetailsMap.entrySet()) {
    	   if(mp.getValue()>=minRent && mp.getValue()<=maxRent) {
    		   apartmentInRange.add(mp.getKey());
    	   }
       }
    	return apartmentInRange;
    }

}

public class PropertyManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PropertyManagement obj = new PropertyManagement();
        
        System.out.println("Enter the no. of Apartment");
        int size = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i<size; i++) {
        	String details = sc.nextLine();
        	String arr[] = details.split(":");
        	String apartmentNumber = arr[0];
        	double rent = Double.parseDouble(arr[1]);
        	obj.addApartmentDetails(apartmentNumber, rent);
        	
        }
        
        System.out.println("Find total rent in a given range");
        double minRange = sc.nextDouble();
        double maxRange = sc.nextDouble();
         sc.nextLine();
         
        double totalApartment = obj.findTotalRentOfApartmentsInTheGivenRange(minRange, maxRange);
        
        if(totalApartment == 0) {
        	System.out.println("No apartment found in this range"); 
        }
        else {
        	System.out.println("there are total "+totalApartment+" found in the range");
        }
        
        System.out.println("Enter the Apartment name to be removed");
        String removeApartment = sc.nextLine();
        
        if(!obj.removeApartment(removeApartment))
        {
        	System.out.println("Apartment not found");
        }
        else {
        	System.out.println("Apartment removed Successfully");
        }
        
        System.out.println("Update the rent of an Apartment");
        System.out.println("Enter an Existing apartment number");
        String ExistingAPno = sc.nextLine();
        System.out.println("Enter new rent for the apartment");
        double newRent = sc.nextDouble();
        if(!obj.updateRent(ExistingAPno, newRent)) {
        	System.out.println("Apartment no. does not exist");
        }
        else {
        	System.out.println("New Rent of Apartment no. "+ExistingAPno+" is "+newRent);
        }
        
        System.out.println("Apartment with the heighest Rent is "+obj.findApartmentWithHighestRent());
        
        
        System.out.println("Apartment with the Lowest Rent is "+obj.findApartmentWithLowestRent());
        
        if(obj.getTotalApartments()==0) {
        	System.out.println("No apartments exist");
        }
        else {
        	System.out.println("Total no. of apartment present is "+obj.getTotalApartments());
        }
        
        System.out.println("Get all apartment in a given rent range");
        System.out.println("Enter min Rent");
        double min = sc.nextDouble();
        System.out.println("Enter max Rent");
        double max = sc.nextDouble();
        List<String> list = obj.getApartmentsInRange(min,max);
        if(list.isEmpty()) {
        	System.out.println("No apartment found in the given range");
        }
        else {
        	 for(String i : list) {
        		System.out.println(i); 
        	 }
        }
        
    }
}
