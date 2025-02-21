import java.util.*;
import java.util.stream.*;

// It'll take hours to understand so go for Stream basics first 
// used Iterator itr.next(),Comparator,String.Format,Stream.of(),String.valueOf

//Input Output

/*Enter the number of books you want to add:
3
Enter the details of the books:
Java Programming:Computer Science:John Doe:10:45.99
Python Basics:Computer Science:Jane Smith:8:39.95
Data Structures:Computer Science:John Doe:5:55.50
Books grouped by genre:
Computer Science
Books grouped by genre: 
Computer Science
Java Programming Computer Science 10 45.99
Python Basics Computer Science 8 39.95
Data Structures Computer Science 5 55.50
Enter book title to get authors and prices:
Python Basics
Author and prices of Python Basics
Jane Smith 39.95
Summary Report:
Total books: 3
Total price: 141.44
Total quantity: 23 */

class AllBooks{

	private String title;
	private String genre;
	private String author;
	private int quantity;
	private double price;
	
	// getters
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	//setters
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
		
	//Parameterized constructor
	AllBooks(String title, String genre, String author, int quantity, double price){
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return title+" "+genre+" "+author+" "+quantity+" "+price;
	}
}

class BooksUtility{
	    
	    public Map<String, List<AllBooks>> retriveBooksGroupedByGenre(Stream<AllBooks> books){
	    
	    Map<String, List<AllBooks>> mp = books.collect(Collectors.groupingBy(AllBooks::getGenre));
	    return mp;	
	    }
	    
	    public Map<String,Double> getAuthorsandPricesByTitle(Stream<AllBooks> books, String title){
	    	return books.filter(e -> e.getTitle().equalsIgnoreCase(title)).collect(Collectors.toMap(AllBooks::getAuthor,AllBooks::getPrice));
	    }
	    
	    public Stream<String> generateSummaryReport(List<AllBooks> books){
	    
	    	int totalBooks = books.size();
	    	
	    	double totalPrice = books.stream()
	    			.mapToDouble(AllBooks::getPrice)
	    			.sum();
	        int totalQuantity = books.stream()
	        		.mapToInt(AllBooks::getQuantity).sum();
	    
	        return Stream.of(
	        		String.valueOf(totalBooks),
	        		String.valueOf(totalPrice),
	        		String.valueOf(totalQuantity)
	        		);
	    }
}


public class libraryManagement {

	public static void main(String[] args) {
		
		List<AllBooks> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of books you want to add:");
		int size = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the details of the books:");
		for(int i = 0; i<size; i++) {
			String details = sc.nextLine();
			
			String[] arr = details.split(":");
			String title = arr[0];
			String genre = arr[1];
			String author = arr[2];
			int quantity = Integer.parseInt(arr[3]);
			double price = Double.parseDouble(arr[4]);
			
			AllBooks obj = new AllBooks(title,genre,author,quantity,price);
			list.add(obj);		
		}
		
		System.out.println("Books grouped by genre:");
		String searchGenre = sc.nextLine();
		
		BooksUtility obj2 = new BooksUtility();
		Map<String, List<AllBooks>> map = obj2.retriveBooksGroupedByGenre(list.stream()
				.filter(e->e.getGenre().equalsIgnoreCase(searchGenre)));
		
		if(map.isEmpty()) {
			System.out.println("No books found of genre"+searchGenre);
		}
		else {
			System.out.println("Books grouped by genre: \n"+searchGenre);		
		     for(Map.Entry<String, List<AllBooks>> mp : map.entrySet()) {
		    	 for(AllBooks i : mp.getValue()) {
		    		 System.out.println(i.getTitle()+" "+i.getGenre()+" "+i.getQuantity()+" "+String.format("%.2f", i.getPrice()));
		    	 }
		     }
		}
		
		System.out.println("Enter book title to get authors and prices:");
		String searchByTitle = sc.nextLine();
		
		Map<String, Double> result = obj2.getAuthorsandPricesByTitle(list.stream(), searchByTitle);
		if(result.isEmpty()) {
			System.out.println("No Author and prices of "+searchByTitle+" found");
		}
		else {
			System.out.println("Author and prices of "+searchByTitle);
			for(Map.Entry<String, Double> mp : result.entrySet()) {
	         System.out.println(mp.getKey()+" "+mp.getValue());
			}
		}
		
		Stream<String> stream = obj2.generateSummaryReport(list);
		
		System.out.println("Summary Report:");
		Iterator<String> itr = stream.iterator();
		
		System.out.println("Total books: "+itr.next());
		System.out.println("Total price: "+String.format("%.2f", Double.parseDouble(itr.next()))); // upto two decimal points only
		System.out.println("Total quantity: "+itr.next());
		  
	}

  }
