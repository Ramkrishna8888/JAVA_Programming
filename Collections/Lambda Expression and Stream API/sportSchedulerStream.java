import java.util.*;
import java.util.stream.*;
import java.time.*;
import java.time.format.*;

class Match{
   private String matchCode;
   private String matchTitle;
   private String coordinator;
   private LocalDate matchDate;
   private String venue;
   
   //getters
   
   public String getMatchCode() {return matchCode;}
   public String getMatchTitle() {return matchTitle;}
   public String getCoordinator() {return coordinator;}
   public LocalDate getMatchDate() {return matchDate;}
   public String getVenue() {return venue;}
   
   // setters
   
   public void setMatchCode(String matchCode) {this.matchCode = matchCode;}
   public void setMatchTitle(String matchTitle) {this.matchTitle = matchTitle;}
   public void setCoordinator(String coordinator) {this.coordinator = coordinator;}
   public void setLocalDate(LocalDate matchDate) {this.matchDate = matchDate;}
   public void setVenue(String Venue) {this.venue = venue;}
   
   //No argument Constructor
   Match(){};
   
   // five Argument Constructor
   Match(String matchCode,String matchTitle, String coordinator, LocalDate matchDate, String venue){
	   this.matchCode = matchCode;
	   this.matchTitle = matchTitle;
	   this.coordinator = coordinator;
	   this.matchDate = matchDate;
	   this.venue = venue;
   }
   
   // Overriding To string to get the output in readable format 
   
   @Override
   public String toString() {
	   return matchCode+" | "+matchTitle+" | "+coordinator+" | "+matchDate+" | "+venue;
   }
   
}

class MatchUtility{
	
	public Stream<Match> getMatchesByCoordinator(List<Match> matchList, String coordinator){
		return matchList.stream().filter(e -> e.getCoordinator().equalsIgnoreCase(coordinator));
	}
	
	public Stream<Match> getMatchesInOrderByDate(List<Match> matchList){
		return matchList.stream().sorted(Comparator.comparing(Match::getMatchDate));
		
	}
	
	public Stream<String> getDistinctMatches(List<Match> matchList){
		return matchList.stream().map(Match::getMatchTitle).distinct();
	}
	
}


public class SportScheduler {

	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   MatchUtility obj = new MatchUtility();
	   List<Match> list = new ArrayList<>();
	   
	   System.out.println("Enter the number of Matches");
	   int size = sc.nextInt();
	   sc.nextLine();
	   
	   System.out.println("Enter the Match details:");
	   for(int i = 0; i<size; i++) {
		   String details = sc.nextLine();
		   String[] arr = details.split(":");
		   
		   String matchCode = arr[0];
		   String matchTitle = arr[1];
		   String coordinator = arr[2];
	       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   LocalDate matchDate = LocalDate.parse(arr[3], formatter);
	       String venue = arr[4];
		   
		   Match obj2 = new Match(matchCode, matchTitle, coordinator, matchDate, venue);
	       list.add(obj2);
	   }
	   
	   System.out.println("Enter the coordinator:");
	   String name = sc.nextLine();
	   
	   Stream<Match> s1 = obj.getMatchesByCoordinator(list, name);
	   List<Match> newList1 = s1.collect(Collectors.toList());
		if(newList1.isEmpty()) {
			System.out.println("Matches not found for the given coordinator ");
		}
		else {
			System.out.println("Matches for the given coordinator :");
			for(Match i : newList1) {
				System.out.println(i);
			}
		}
		
	 System.out.println("Matches in ascending order based on match date:");
	 
	 Stream<Match> s2 = obj.getMatchesInOrderByDate(list);
	 List<Match> newList2 = s2.collect(Collectors.toList());
	 for(Match i : newList2) {
		 System.out.println(i);
	 }
		
	 System.out.println("Distinct Matches are :");
	 Stream<String> s3 = obj.getDistinctMatches(list);
	 List<String> newList3 = s3.collect(Collectors.toList());
	 
	 for(String i : newList3){
		 System.out.println(i);
	 }
	   
	}

}
