package programs;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

class User{
	   
	  private String username;
	  private String password;
	  private String email;
	  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	User(){
		
	}
	
	User(String username, String password, String email){
		this.username = username;
		this.password = password;
		this.email = email;
	}

	
}

class AccountManager{
	  
  private List<User> userList = new LinkedList<User>();
	
	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}
	
	AccountManager(){
		this.userList = userList;
	}
	
	// Requirements
	//Register User
	
	public boolean registerUser(String username, String password, String email){
		for(User u : userList)
		if(u.getUsername().equals(username) || u.getPassword().equals(password) || u.getEmail().equals(email))
		{
			return false;
		}
		User obj = new User();           // safer for beginners
	    obj.setUsername(username);
	    obj.setPassword(password);
	    obj.setEmail(email);
	    
	    userList.add(obj);
	    return true;
	    
		/*
		 * User user = new User(username, password, email); 
		 * userList.add(user); return
		 * true;
		 */
	}
	
	//login
	
	public String login(String username, String password) {
		
		for(User u : userList) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u.getUsername();
			}
		}
		return null;
	}
	
  //reset password
	
	public boolean resetPassword(String username, String newPassword) {
		for(User i : userList) {
			if(i.getUsername().equals(username)) {
				i.setPassword(newPassword);
				return true;
			}
		}
		
		return false;
	}
	
	//Update Email
	
	public boolean updateEmail(String username, String newEmail){
		
		for(User i : userList) {
			if(i.getUsername().equals(username)) {
				i.setEmail(newEmail);
				return true;
			}
		}
		return false;	
	}
	
	public boolean deleteUser(String username) {
		for(User i : userList) {
			if(i.getUsername().equals(username)) {
			    userList.remove(i);
			    return true;
			}
		}
		return false;
	}

	
}


public class Collection1_Online_BookStore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AccountManager obj = new AccountManager();
		
		while(true){
		
		String username,password,email,newPassword,newEmail;
		boolean res;
		
		System.out.println("Enter action (register, login, reset password, update email, delete user, exit):");
		String action = sc.nextLine().toLowerCase();
		
		
		switch(action) {
		  
		case "register": {
			
			System.out.print("Enter username: ");
			username = sc.nextLine();
			
			System.out.print("Enter password: ");
			password = sc.nextLine();
			
			System.out.print("Enter email: ");
			email = sc.nextLine();
			
			res = obj.registerUser(username, password, email);
			
			if(res){
				System.out.println("User registered successfully.");
			}
			else {
				System.out.println("User already exist");
			}
			
			break;
		}
		
		case "login": {
			System.out.print("Enter username: ");
			username = sc.nextLine();
			
			System.out.print("Enter password: ");
			password = sc.nextLine();
			
			String personName = obj.login(username, password);
			
			if(personName==null) {
				System.out.println("No user found");
			}
			else {
				System.out.println("Login successful. Welcome, "+personName+" !");
			}
			
			break;
		}
		
		case "reset password": {
			System.out.print("Enter username: ");
			username = sc.nextLine();
			
			System.out.print("Enter new password: ");
			newPassword = sc.nextLine();
			
			res = obj.resetPassword(username, newPassword);
			if(res) {
				System.out.println("Password reset successful.");
			}
			else {
				System.out.println("User not found.");
			}
			
			break;
		}
		
		case "update email": {
			System.out.print("Enter username: ");
			username = sc.nextLine();
			
			System.out.print("Enter new email: ");
			newEmail = sc.nextLine();
			
			res = obj.updateEmail(username, newEmail);
			
			if(res) {
				System.out.println("Email updated successfully.");
			}
			else {
				System.out.println("No user found.");
				
			}
			
			break;
		}
		
		case "delete user" : {
			
			System.out.print("Enter username: ");
			username = sc.nextLine();
			System.out.print("Are you sure you want to delete user "+username+" ? (yes/no): ");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("yes")) {
				res = obj.deleteUser(username);
				if(res) {
				System.out.println("User "+username+" deleted successfully.");
			   }
				else {
					System.out.println("User not found.");
				}
			}
			else {
				System.out.println("User not deleted.");
			}
			
			break;
		       }
		
		case "exit" : {
			
			System.out.println("Thankyou for using the application !");
			sc.close();
			return;
		}
		
		default :
		{
			System.out.println("Invalid input kindly input again.");
		}
		
	    	}  
		
		}
		

	}

}
