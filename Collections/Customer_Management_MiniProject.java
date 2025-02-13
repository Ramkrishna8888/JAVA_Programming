import java.util.*;
class User{
	
	    private String username = "";
	    private String password = "";
	    private String email = "";
	    
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
	    
	    // Creating a constructor
	    User(){
	    	this.username = username;
	    	this.password = password;
	    	this.email = email;
	    }	
	
}

class AccountManager{
	
	     private LinkedList userList = new LinkedList();
	     
	     public LinkedList getUserList() {
	    	 return userList;
	     }
	     
	     public void setUserList(LinkedList userList) {
	    	 this.userList = userList;
	     }
	     
	     AccountManager(){
	    	 this.userList = userList;
	     }
	     
	     
	     // Register User
	     boolean registerUser(String username, String password, String email) {
	    	 if(userList.contains(username) || userList.contains(email) || userList.contains(password))
	    	 return false;
	    	 else {
	    		 userList.add(username);
	    		 userList.add(password);
	    		 userList.add(email);
	    	 }
	    	 return true;
	     }
	      
	     
	     // Login Authenticate
	    String login(String username, String password){
	    	
	    	int index = userList.indexOf(password);
	    	 if(index != -1 && index + 1 < userList.size() && userList.get(index+1).equals(password)) {
	    		 return username;
	    	 }
	    	 else
	    		 return null;
	     }
	    
	    // reset Password
	    
	    boolean resetPassword(String username, String newPassword) {
	    	
	    	int index = userList.indexOf(username);
	    	if(index != -1 && index+1 < userList.size())
	    	{
	    		userList.set(index+1, newPassword);
	    		return true;
	    	}
	    	else
	    		return false;
	    }
	    
	    // update Email
	    
	    boolean updateEmail(String username,String newEmail) {
	    	
	    	int index = userList.indexOf(username);
	    	if(index != -1 && index+2 < userList.size())
	    	{
	    		userList.set(index+2, newEmail);
	    	    return true;
	    	}
	    	else
	    		return false;
	    }
	     
	    // Delete User
	    
	    boolean deleteUser(String username)
	    {
	    	
	    	int index = userList.indexOf(username);
	    	if(index != -1 && index+2 <=userList.size()) {
	    		System.out.println("index of username is : "+index);
	    		for(int i = index; i<index+2; i++)
	    		   userList.remove(i);
	    		
	    		return true;
	    	}
	    	else
	    		return false;
	    }
	    
	
	
}


public class customerManagementList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User obj = new User();
		AccountManager obj2 = new AccountManager();
		while (true) {
			String username = "";
			String password = "";
			String email = "";
			String newPassword = "";
			String newEmail = "";
		System.out.println("Enter action (register, login, reset password, update email, delete user, exit):");
         String choice = sc.nextLine();
         
         
         switch(choice) {
         
         case "register": {
        	 
        	 System.out.print("Enter username: ");
        	  username = sc.nextLine();
        	  obj.setUsername(username);
        	 System.out.print("Enter password: ");
        	  password = sc.nextLine();
        	  obj.setPassword(password);
        	 System.out.print("Enter the email");
        	  email = sc.nextLine();
        	  obj.setEmail(email);
        	  
        	  if(obj2.registerUser(username, password, email))
        	  {
        		  System.out.println("User registered successfully.");
        	  }
        	  break;
         }
         
         case "login": {
        	 
        	 System.out.print("Enter username: ");
        	 username = sc.nextLine();
        	 obj.setUsername(username);
        	 
        	 System.out.print("Enter password: ");
        	 password = sc.nextLine();
        	 obj.setPassword(password);
        	 
        	String name = obj2.login(username, password);
        	if(name!=null) {
        		System.out.println("Login successful. Welcome, "+name+"!");
        	}
        	else {
        		System.out.println("Invalid credentials. Please try again.");
        	}
        	break; 
         }
         
         case "reset password":{
        	 
        	 System.out.print("Enter username: ");
        	 username = sc.nextLine();
        	 obj.setUsername(username);
        	 
        	 System.out.print("Enter new password");
        	 newPassword = sc.nextLine();
        	 
        	 if(obj2.resetPassword(username, newPassword)){
        		 System.out.println("Password reset succeccfully.");
        	 }
        	 else {
        		 System.out.println("User not founnd.");
        	 }
        	 break;
         }
         
        case "update email": {
        	
        	System.out.print("Enter username: ");
        	username = sc.nextLine();
        	obj.setUsername(username);
        	
        	System.out.print("Enter new email: ");
        	newEmail = sc.nextLine();
        	
        	if(obj2.updateEmail(username, newEmail)) {
        		System.out.println("Email updated successfully.");
        	}
        	else
        		System.out.println("User not found");
        	
         break;
         
         }
        
        
       case "delete user": {
    	   
    	   System.out.print("Enter username: ");
    	   username = sc.nextLine();
    	   obj.setUsername(username);
    	   
    	   System.out.println("Are you sure you want to delete user '"+username+"'?(yes/no):");
    	   String choice2 = sc.nextLine();
    	   
    	   if(choice2.equalsIgnoreCase("yes"))
    	   {
    		   if(obj2.deleteUser(username)) {
    			   System.out.println("User "+username+" deleted successfully.");
    		   }
    		   else
    		   {
    			   System.out.println("User not found.");
    		   }
    	   }
    	   else
    		    System.out.println("User not deleted.");
    	         break;
       }
        	  
       case "exit": {
    	   
    	    System.out.println("Thankyou for using the application !");
    	    sc.close();
        	return; 
       }
        
         default : System.out.println("Invalid Choice! Enter  the choice again");
         
         }
		}
	}
}
