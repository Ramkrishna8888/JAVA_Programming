/*
INPUT & OUTPUT

Enter the number of movies you want to add:
3
Enter the details of the movies:
Inception:Sci-Fi:Christopher Nolan:5:3.99
Interstellar:Sci-Fi:Christopher Nolan:3:4.99
Titanic:Romance:James Cameron:2:2.99
Movies grouped by genre:
Sci-Fi
Inception Sci-Fi Christopher Nolan 5 3.99
Interstellar Sci-Fi Christopher Nolan 3 4.99
Romance
Titanic Romance James Cameron 2 2.99
Enter movie title to get directors and prices: 
Inception
Director and prices of Inception:
Christopher Nolan 3.99
Enter the Late days:
2
Late days Rental fees: 9.0
Summary Report:
Total movies: 3
Total revenue: 11.97
Average price: 3.99
Search movie by director: 
Titanic | Romance | James Cameron | Available: 2 | Price: $2.99
Inception | Sci-Fi | Christopher Nolan | Available: 5 | Price: $3.99
Interstellar | Sci-Fi | Christopher Nolan | Available: 3 | Price: $4.99

*/
import java.util.*;
import java.util.stream.*;
import java.time.*;

class MoviePOJO {
    private String title;
    private String genre;
    private String director;
    private int quantityAvailable;
    private double rentalPrice;

    // Default Constructor
    public MoviePOJO() {
    }

    // Parameterized Constructor
    public MoviePOJO(String title, String genre, String director, int quantityAvailable, double rentalPrice) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.quantityAvailable = quantityAvailable;
        this.rentalPrice = rentalPrice;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    
    @Override
    public String toString() {
        return title + " | " + genre + " | " + director + " | Available: " + quantityAvailable + " | Price: $" + rentalPrice;
    }
}


class MovieCatalogUtility {

    // Retrieves movies grouped by genre
    public Map<String, List<MoviePOJO>> retrieveMoviesGroupedByGenre(Stream<MoviePOJO> movies) {
        return movies.collect(Collectors.groupingBy(MoviePOJO::getGenre));
    }
    
 // Retrieves directors and prices by movie title
    public Map<String, Double> getDirectorsAndPricesByTitle(Stream<MoviePOJO> movies, String title) {
        Map<String, Double> result = new HashMap<>();
        
        movies.filter(e -> e.getTitle().equalsIgnoreCase(title))
              .forEach(e -> result.put(e.getDirector(), e.getRentalPrice()));

        return result;
    }


    // Calculates late fees for rentals
    public double calculateLateFees(List<MoviePOJO> rentals, int daysLate) {
      double fixPrice = 1.50;
      return rentals.size()*daysLate*fixPrice;
    }

    // Generates a summary report for movies
    public Stream<String> generateSummaryReport(List<MoviePOJO> movies) {
        int totalBooks = movies.size();
        
        double totalPrice = movies.stream().mapToDouble(e -> e.getRentalPrice()).sum();
        
        double avg = totalPrice/totalBooks;
        
         return Stream.of(
        		 String.valueOf(totalBooks),
        		 String.valueOf(totalPrice),
        		 String.valueOf(avg)
        		 );
    }

    // Searches movies by director
    public List<MoviePOJO> searchMoviesByDirector(Stream<MoviePOJO> movies, String directorName) {
        return movies.filter(e -> e.getDirector().equalsIgnoreCase(directorName)).collect(Collectors.toList());
    }
    

    // Sorts movies by price in ascending or descending order
    public List<MoviePOJO> sortMoviesByPrice(Stream<MoviePOJO> movies, boolean ascendingOrder) {
        return movies.sorted(ascendingOrder ? Comparator.comparing(MoviePOJO::getRentalPrice) : Comparator.comparing(MoviePOJO::getRentalPrice).reversed()).collect(Collectors.toList());
    }
}


public class MoviesManagementSystem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MovieCatalogUtility obj = new MovieCatalogUtility();
		
		List<MoviePOJO> list = new ArrayList<>();
		
		System.out.println("Enter the number of movies you want to add:");
		int size = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the details of the movies:");
		for(int i = 0; i<size; i++) {
			String details = sc.nextLine();
			
			String[] arr = details.split(":");
			String title = arr[0];
			String genre = arr[1];
			String director = arr[2];
			int quantityAvailable = Integer.parseInt(arr[3]);
			double rentalPrice = Double.parseDouble(arr[4]);
			
			MoviePOJO obj2 = new MoviePOJO(title,genre,director,quantityAvailable,rentalPrice);
			list.add(obj2);
		}
		
		//1. movies grouped by genre
		
		System.out.println("Movies grouped by genre:");
	     Map<String, List<MoviePOJO>> map =obj.retrieveMoviesGroupedByGenre(list.stream());

	     for(Map.Entry<String, List<MoviePOJO>> mp : map.entrySet()) {
	    	 System.out.println(mp.getKey());
	    	 for(MoviePOJO i : mp.getValue()) {
	    		 System.out.println(i.getTitle()+" "+i.getGenre()+" "+i.getDirector()+" "+i.getQuantityAvailable()+" "+i.getRentalPrice());
	    	 }
	     }
		
	     //2. director and price by movie title
	     
	    System.out.println("Enter movie title to get directors and prices: ");
	    String searchTitle = sc.nextLine();
	    
	    Map<String, Double> mp2 = obj.getDirectorsAndPricesByTitle(list.stream(), searchTitle);
	    if(mp2.isEmpty()) {
	    	System.out.println("No movie title found");
	    }
	    else {
	    	System.out.println("Director and prices of "+searchTitle+":");
	    	for(Map.Entry<String, Double> mp : mp2.entrySet()) {
                System.out.println(mp.getKey()+" "+mp.getValue());
	    	}
	    }
	    
	    //3. Late days fees 
	    
	    System.out.println("Enter the Late days:");
	    int late = sc.nextInt();
	    
	    double res = obj.calculateLateFees(list, late);
	    System.out.println("Late days Rental fees: "+res);
	    
	    //4. summary report
    
	     Stream<String> str =  obj.generateSummaryReport(list);
         System.out.println("Summary Report:");
	     Iterator<String> itr = str.iterator();
         
         System.out.println("Total movies: "+itr.next());
         System.out.println("Total revenue: "+itr.next());
         System.out.println("Average price: "+itr.next());
         
         
        //5. search movies by director
         
         System.out.println("Search movie by director: ");
 	    String searchDirector = sc.nextLine();
 	    
         List<MoviePOJO> listMovie = obj.searchMoviesByDirector(list.stream(), searchDirector);
         listMovie.forEach(System.out::println);
         
       // 6. sorting by price
         boolean ascendingOrder = true;
         List<MoviePOJO> sortedByPrice = obj.sortMoviesByPrice(list.stream(), ascendingOrder);
         sortedByPrice.forEach(System.out::println);
	}

}
