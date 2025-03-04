/*
 Enter the no. of events
5
Enter the details:
E001|Tech Summit|Alice|2025-04-10|New York
E002|AI Conference|Bob|2025-05-15|San Francisco
E003|Dev Meetup|Alice|2025-03-20|Boston
E004|Startup Expo|Charlie|2025-06-01|New York
E005|Java Workshop|Alice|2025-02-28|Boston
Enter the organizer name to find the events
Alice
Events by organizer
E001 | Tech Summit | Alice | 2025-04-10 | New York
E003 | Dev Meetup | Alice | 2025-03-20 | Boston
E005 | Java Workshop | Alice | 2025-02-28 | Boston
Enter date to get upcoming events
2025-03-01
List of Upcoming 
E001 | Tech Summit | Alice | 2025-04-10 | New York
E002 | AI Conference | Bob | 2025-05-15 | San Francisco
E003 | Dev Meetup | Alice | 2025-03-20 | Boston
E004 | Startup Expo | Charlie | 2025-06-01 | New York
Grouped events by location 
San Francisco->[E002 | AI Conference | Bob | 2025-05-15 | San Francisco]
New York->[E001 | Tech Summit | Alice | 2025-04-10 | New York, E004 | Startup Expo | Charlie | 2025-06-01 | New York]
Boston->[E003 | Dev Meetup | Alice | 2025-03-20 | Boston, E005 | Java Workshop | Alice | 2025-02-28 | Boston]
Get Earliest Event 
Optional[E005 | Java Workshop | Alice | 2025-02-28 | Boston]
 
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

class Event {
    private String eventId;
    private String eventName;
    private String organizer;
    private LocalDate eventDate;
    private String location;

    // Constructor
    public Event(String eventId, String eventName, String organizer, LocalDate eventDate, String location) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.organizer = organizer;
        this.eventDate = eventDate;
        this.location = location;
    }

    // Getters
    public String getEventId() { return eventId; }
    public String getEventName() { return eventName; }
    public String getOrganizer() { return organizer; }
    public LocalDate getEventDate() { return eventDate; }
    public String getLocation() { return location; }

    // toString Method for readable output
    @Override
    public String toString() {
        return eventId + " | " + eventName + " | " + organizer + " | " + eventDate + " | " + location;
    }
}

class EventUtility {
    public Stream<Event> getEventsByOrganizer(List<Event> eventList, String organizer) {
        return eventList.stream().filter(e->e.getOrganizer().equalsIgnoreCase(organizer));
    }
    
    public Stream<Event> getUpcomingEvents(List<Event> eventList, LocalDate currentDate) {
        return eventList.stream().filter(e->e.getEventDate().isAfter(currentDate));
    }
    
    public Map<String, List<Event>> groupEventsByLocation(List<Event> eventList) {
        return eventList.stream().collect(Collectors.groupingBy(Event::getLocation));
    	
    }
    
    public Optional<Event> getEarliestEvent(List<Event> eventList) {
        return eventList.stream().min(Comparator.comparing(Event::getEventDate));
   }
}
public class EventManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventUtility obj = new EventUtility();
        List<Event> list = new ArrayList<>();
    	System.out.println("Enter the no. of events");
        int size = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the details:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
      for(int i = 0; i<size; i++) {
        	String details = sc.nextLine();
        	String[] arr = details.split("\\|");
        	
        	
        	String eventId = arr[0];
            String eventName = arr[1];
            String organizer = arr[2];
            LocalDate eventDate = LocalDate.parse(arr[3],formatter);
            String location = arr[4];
            
            Event obj2 = new Event(eventId,eventName,organizer,eventDate,location);
            list.add(obj2);
        }
        
        System.out.println("Enter the organizer name to find the events");
        String eventOrganizer = sc.nextLine();
        
        Stream<Event> s1 = obj.getEventsByOrganizer(list, eventOrganizer);
        List<Event> list1 = s1.collect(Collectors.toList());
        if(list1.isEmpty()) {
        	System.out.println("No event found by the given organizer");
        }
        else {
        System.out.println("Events by organizer");
        list1.forEach(System.out::println);
        }
        
        System.out.println("Enter date to get upcoming events");
         String curDate = sc.nextLine();
         LocalDate currentDate = LocalDate.parse(curDate,formatter);
         
         Stream<Event> s2 = obj.getUpcomingEvents(list, currentDate);
         List<Event> list2 = s2.collect(Collectors.toList());
         System.out.println("List of Upcoming ");
         list2.forEach(System.out::println);
         
         
        System.out.println("Grouped events by location ");
        
        Map<String, List<Event>> mp = obj.groupEventsByLocation(list);
        
        for(Map.Entry<String, List<Event>> i : mp.entrySet()) {
        	System.out.println(i.getKey()+"->"+i.getValue());
        }
        
        System.out.println("Get Earliest Event ");
        Optional<Event> o = obj.getEarliestEvent(list);
        System.out.println(o);
        
    }
}
