// understand the use of collections

import java.util.*;

class User {
    private String username;
    private String password;
    private String email;

    // Default constructor
    public User() {
        this.username = "";
        this.password = "";
        this.email = "";
    }

    // Parameterized constructor
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString() {
    	return username+" "+password+" "+email;
    }

}

class AccountManager {
    private List<User> userList;

    // Default constructor
    public AccountManager() {
        this.userList = new ArrayList<>();
    }

    // Getter for userList
    public List<User> getUserList() { return userList; }
    public void setUserList(List<User> userList) { this.userList = userList; }

    // Method to register a new user
    public boolean registerUser(String username, String password, String email) {
         for(User i : userList) {
        	 if(i.getUsername().equals(username) || i.getEmail().equals(email)) {
        		 return false;
        	 }
         }
         
         User obj = new User(username,password,email);
         userList.add(obj);
         return true ;
       
     }

    // Method to login a user
    public User login(String username, String password) {
       for(User i : userList) {
    	   if(i.getUsername().equals(username) && i.getPassword().equals(password)) {
    		   return i;
    	   }
       }
       
    	return null;  	
    }

    // Method to reset password
    public boolean resetPassword(String username, String newPassword) {
        
    	for(User i : userList) {
    		if(i.getUsername().equals(username))
    		{
    			i.setPassword(newPassword);
    			return true;
    		}
    	}
    	
        return false;
    }

    // Method to update email
    public boolean updateEmail(String username, String newEmail) {
       for(User i : userList) {
    	   if(i.getUsername().equals(username)) {
    		   i.setEmail(newEmail);
    		   return true;
    	   }
       }   	
       return false;
    	
    }

    /* Method to delete a user
    public boolean deleteUser(String username) {
        for (int i = 0; i < userList.size(); i++) {  
            if (userList.get(i).getUsername().equals(username)) {  
                userList.remove(i);  
                return true; 
            }
        }
        return false; 
    } */
    
    
    // using iterator to avoide index shifting issue
    public boolean  deleteUser(String username) {
    	Iterator<User> itr = userList.iterator();
    	while(itr.hasNext()) {
    		User i = itr.next();
    		if(i.getUsername().equals(i)) {
    			itr.remove();
    			return true;
    		}
    	}
    	
    	return false;
    }

}

public class AccountManagement{
    public static void main(String[] args) {
        AccountManager obj = new AccountManager();
    	Scanner sc = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();
        String choice,username,password,email = "";
        
         boolean loop = true;
        while(loop) {
        System.out.print("Enter action (register,login,reset password, update email, delete user, exit): ");
        choice = sc.nextLine();
        
        switch(choice.toLowerCase()) {
        
        case "register": {
        	
        	  System.out.println("Enter username: ");
              username = sc.nextLine();
              System.out.println("Enter password: ");
              password = sc.nextLine();
              System.out.println("Enter email: ");
              email = sc.nextLine();
              if(!obj.registerUser(username, password, email)) {
            	  System.out.println("User already present");
              }
              else {
            	  System.out.println("User registered successfully!");
              }
               break;
        }
        
        case "login": {
        	  
      	  System.out.println("Enter username: ");
          username = sc.nextLine();
          System.out.println("Enter password: ");
          password = sc.nextLine();
          
          User name = obj.login(username, password);
          if(name==null) {
        	System.out.println("User not found");  
          }
          else {
        	  System.out.println("Welcome "+name.getUsername()+" you're successfully logged in");
          }          
          break;
        }
        
        case "reset password":  {
        	
        	  System.out.println("Enter username: ");
              username = sc.nextLine();
              System.out.println("Enter new password: ");
              password = sc.nextLine();
              
              if(!obj.resetPassword(username, password)) {
            	  System.out.println("User not found");
              }
              else {
            	  System.out.println("Password reset successfully");
              }
            break;
        }
        
        case  "update email": {
        	
      	     System.out.println("Enter username: ");
      	     username = sc.nextLine();
             System.out.println("Enter new Email: ");
             email = sc.nextLine();
           
           if(!obj.updateEmail(username, email))
           {
        	   System.out.println("User not found");
           }
           else {
        	   System.out.println("Email updated successfully");
           }
           break;
        }
        
        case "delete user": {
        	
        	 System.out.println("Enter username: ");
             username = sc.nextLine();
        	if(!obj.deleteUser(username)) {
        		System.out.println("User not found");
        	}
        	else {
        		System.out.println("User deleted successfully");
        	}
        	
        	break;
             
        }
    
        case "exit" :
        	System.out.println("Thanks for using the application.");
        	loop = false;
        	sc.close();
        	break;
        }
       }
    }
}
