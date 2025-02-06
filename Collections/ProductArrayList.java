import java.util.*;
class Products{
     
	List<String> productList = new ArrayList<>();
	
	public List<String> getArrayList(){
		 
		return productList;
	}
	
	public void setArrayList(List<String> productList) {
		
		this.productList = productList;
	}

	public void addProductToList(String products) {
		productList.add(products);
	}
	
	public void sortProductList() {
		Collections.sort(productList);
		System.out.println(productList);
	}
	
}


public class ProductsArrayList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Products obj = new Products();
		while(true) {
			
			System.out.println("1.Add");
			System.out.println("2.Display");
			System.out.println("3.Exit");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			
			case 1:
				System.out.println("Enter the product");
				String products = sc.nextLine();
				obj.addProductToList(products);
				break;
				
			case 2:
				if(obj.getArrayList().isEmpty()) {
					System.out.println("The list is empty");
				}
				else
				{
			     obj.sortProductList();
				}
			     break;
			     
			case 3:
			     System.out.println("Thank you for using the application");
				sc.close();
			     return;
			}
			
			
		}

	}

}
