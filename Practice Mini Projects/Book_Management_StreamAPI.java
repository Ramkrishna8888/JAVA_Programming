/*

 INPUTS AND OUTPUTS
  
Enter the number of books to be added: 4
Enter book details:
Book ID, Title, Author, Genre, Price, Availability
B001, The Great Gatsby, F. Scott Fitzgerald, Fiction, 12.99, true
B002, Algorithms Unlocked, Thomas Cormen, Computer Science, 34.50, true
B003, Java Programming, John Doe, Computer Science, 45.00, true
B004, Pride and Prejudice, Jane Austen, Fiction, 9.99, true
Enter the Book ID to retrieve details: 
B004
B004 Pride and Prejudice Jane Austen Fiction 9.99 true
Enter the Genre to retrieve details: Fiction
Books found of genre Fiction are
B001 The Great Gatsby F. Scott Fitzgerald Fiction 12.99 true
B004 Pride and Prejudice Jane Austen Fiction 9.99 true
Enter the minimum and maximum price range to show book IDs: 
20.00 40.00
Book IDs present in this price range: 
B002
*/


import java.util.*;
import java.util.stream.*;

class BookPOJO{
	private String bookId;
	private String title;
	private String author;
	private String genre;
	private double price;
	private boolean available;
	
	BookPOJO(String bookId, String title, String author, String genre, double price, boolean available){
		 this.bookId = bookId;
		 this.title = title;
		 this.author = author;
		 this.genre = genre;
		 this.price = price;
		 this.available = available;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	@Override
	public String toString() {
		return bookId+" "+title+" "+author+" "+genre+" "+price+" "+available;
	}
}

class LibraryUtil{
	
	// IMPORTANT HOW TO RETURN DIRECT OBJECT 
	// get details of book by id
	
	public BookPOJO retrieveBookDetailsById(Stream<BookPOJO> bookStream, String bookId) {
		return bookStream.filter(e -> e.getBookId().equalsIgnoreCase(bookId)).findFirst().orElse(null);
	}
	
	// get details of book by genre
	public List<BookPOJO> retrieveBooksByGenre(Stream<BookPOJO> bookStream, String genre){
		return bookStream.filter(e -> e.getGenre().equalsIgnoreCase(genre)).toList();
	}
	
	// get details of books in price range 
	
	public List<String> retrieveBookIdsInPriceRange(Stream<BookPOJO> bookStream, double minPrice, double maxPrice){
		 return bookStream.filter(e -> e.getPrice()>=minPrice && e.getPrice()<=maxPrice).map(BookPOJO::getBookId).collect(Collectors.toList());
	}
	
}


public class BookManagementStream {

	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
		
		LibraryUtil obj = new LibraryUtil();
       List<BookPOJO> list = new ArrayList<>();
	   
       
      System.out.print("Enter the number of books to be added: ");
      int size = sc.nextInt();
      sc.nextLine();
      
      System.out.println("Enter book details:");
      System.out.println("Book ID, Title, Author, Genre, Price, Availability");
      for(int i = 0; i<size; i++){
    	  String details = sc.nextLine();
    	  String[] arr = details.split(",");
    	  
    	  String bookId = arr[0].trim();
    	  String title = arr[1].trim();
    	  String author = arr[2].trim();
    	  String genre = arr[3].trim();
    	  double price = Double.parseDouble(arr[4]);
    	  boolean available = Boolean.parseBoolean(arr[5].trim());
    	  
    	  BookPOJO obj2 = new BookPOJO(bookId, title, author, genre, price, available);
    	  list.add(obj2);
      }
      
      
      //1.
      System.out.println("Enter the Book ID to retrieve details: ");
      String searchId = sc.nextLine();
      
      BookPOJO searchedBooks= obj.retrieveBookDetailsById(list.stream(), searchId);
      if(searchedBooks==null) {
    	  System.out.println("Book not found");
      }
      else {
    	  System.out.println(searchedBooks);
      }
      
      //2.
      System.out.print("Enter the Genre to retrieve details: ");
      String searchGenre = sc.nextLine();
        
       List<BookPOJO> searchedByGenre = obj.retrieveBooksByGenre(list.stream(), searchGenre);
       if(searchedByGenre.isEmpty()) {
    	   System.out.println("No books found of "+searchGenre+" genre");
       }
       else {
           System.out.println("Books found of genre "+searchGenre+" are");
    	   searchedByGenre.forEach(e -> System.out.println(e.getBookId()+" "+e.getTitle()+" "+e.getAuthor()+" "+e.getGenre()+" "+e.getPrice()+" "+e.isAvailable()));
       }
       
       
       //3.
       System.out.println("Enter the minimum and maximum price range to show book IDs: ");
	   double minPrice = sc.nextDouble();
	   double maxPrice = sc.nextDouble();
	   
	   List<String> foundId = obj.retrieveBookIdsInPriceRange(list.stream(), minPrice, maxPrice);
       if(foundId.isEmpty()) {
    	   System.out.println("No Book IDs are present in this price range ");
       }
       else {
    	   System.out.println("Book IDs present in this price range: ");
           for(String listRes : foundId) {
        	   System.out.println(listRes);
           }
       }
	}

}
