import java.util.*;
class Operations{
	
	private LinkedList<Integer> obj = new LinkedList<>();
	
	void AddElementsAtFirst(int ele){
		obj.addFirst(ele);
	}
	
	void AddElementAtLast(int ele) {
		obj.add(ele);
	}
	
	void AddElementAtIndex(int ele, int index) {
		obj.add(index, ele);
	}
	
	void UpdateElement(int ele, int index) {
		obj.set(index, ele);
	}
	
	void DeleteFirst() {
		obj.removeFirst();
	}
	
	void  DeleteLast() {
		obj.removeLast();
	}
	
	void DeleteOnElements(int ele) {
		obj.remove(ele);
	}
	
	void DelOnIndex(int index) {
		obj.remove(index);
	}
	
	void DiplayElements() {
		for(int i : obj) {
			System.out.println(i);
		}
	}
	
}

public class LinkedListOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Operations obj = new Operations();
		
		while(true) {
			
		System.out.println("Enter the choice");
		System.out.println("1. Add element at last");
		System.out.println("2. Add element at first");
		System.out.println("3. Add element at the given index");
		System.out.println("4. Update element at the given index");
		System.out.println("5. Delete the first element");
		System.out.println("6. Delete the last element");
		System.out.println("7. Delete the given element");
		System.out.println("8. Delete the element at given index");
		System.out.println("9. Display the elements using loop");
		System.out.println("10. Exit");
		
		int choice = sc.nextInt();

			switch(choice) {
			
			case 1:
				   System.out.println("Enter the element to add at last");
				   int ele = sc.nextInt();
				   obj.AddElementAtLast(ele);
				   break;
				   
			case 2:
				  System.out.println("Enter the element to add at first");
				  int ele2 = sc.nextInt();
				  obj.AddElementsAtFirst(ele2);
				  break;
				  
			case 3:
				System.out.println("Enter the element");
				int ele3 = sc.nextInt();
				System.out.println("Enter the index");
				int index1 = sc.nextInt();
				break;
				
			case 4:
				System.out.println("Enter the element");
				int ele4 = sc.nextInt();
				System.out.println("Enter the index");
				int index2 = sc.nextInt();
				break;
				
			case 5:
				obj.DeleteFirst();
				break;
				
			case 6:
				obj.DeleteLast();
				break;
				
			case 7:
				  System.out.println("Enter the element to delete");
				  int ele5 = sc.nextInt();
				  obj.DeleteOnElements(ele5);
				  break;
				  
			case 8:
				System.out.println("Enter the index of element to delete");
				int index3 = sc.nextInt();
				obj.DelOnIndex(index3);
				break;
				
			case 9:
				System.out.println("All present Element");
				obj.DiplayElements();
				break;
				
			case 10:
				System.out.println("Closing the application...");
				sc.close();
				break;
				
			default:
				System.out.println("Invalid input Renter the choice");
				break;
				
			}
			
			
			
		}

	}

}
