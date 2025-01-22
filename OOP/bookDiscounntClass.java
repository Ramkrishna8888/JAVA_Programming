/*Question:
Write a Java program to create a class called Book with the following attributes:

title (String)
author (String)
price (double)
The class should include:

A method displayDetails() to print the book's details.
A method applyDiscount(double percentage) to reduce the price of the book by the given percentage.*/
import java.util.*;
class Books{
	String title;
	String author;
	double price;
	Scanner sc = new Scanner(System.in);
	void booksDetails()	{
		System.out.println("Enter the title of book  : ");
		title = sc.nextLine();
		System.out.println("Enter the author of book : ");
		author = sc.nextLine();
		System.out.println("Enter the price of book  : ");
		price = sc.nextDouble();
	}
	void displayDetails() {
		System.out.println("Title of  book : "+title);
		System.out.println("Author of book : "+author);
		System.out.println("Price of  book : "+price);
	}
}
public class bookDiscountClasses {
    public static void main(String[] args) {
    	Books obj = new Books();
    	obj.booksDetails();
    	obj.displayDetails();
    }
}
