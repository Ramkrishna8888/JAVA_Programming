import java.util.*;
public class StringReplace {
	static boolean validString(String s) {
		String regex = "[A-Za-z! ]*";
		if(s.matches(regex)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first string");
		String s1 = sc.nextLine();
		System.out.println("Enter the second string");
        String s2 = sc.nextLine();
        	if((!validString(s1))&&(!validString(s2)))
        	{
        		System.out.println(s1+" and "+s2+" contains invalid symbols");
        		return;
        	}
        	else if(!validString(s1)) {
        		System.out.println(s1+" contains invalid symbols");
        		return;
        	}
        	else if(!validString(s2)){
        	System.out.println(s2+" contains invalid symbols");
        	return;
        	}
        
        if(s1.length()!=s2.length()) {
        	System.out.println("Length of "+s1+" and "+s2+" does not match");
        	return;
        }
        
        char[] arr = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for(int i = 0; i<s1.length(); i++) {
        	if(arr[i] == '!')
        	{
        		arr[i] = arr2[i];
        	}
        }
        
        System.out.println(arr);
	}

}
