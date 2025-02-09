import java.util.*;
// basic brute force for Anagram
public class anagram {

	boolean checkAnagram(String word1, String word2){
		
		boolean result = false;
		int count = 0;
		if(word1.length()!=word2.length()) {
			result = false;
		}
			
			for(int i = 0; i<word1.length(); i++)
			{
				for(int j = 0; j<word2.length(); j++) {
					
					if(word1.charAt(i)==word2.charAt(j))
					{
						count++;
						break;
					}
				}a
			}
			
			if(count==word1.length()) {
				result = true;
			}
			else
			{
				result = false;
			}
			return result;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first word");
		String word1 = sc.nextLine();
		

		System.out.println("Enter Second word");
		String word2 = sc.nextLine();
		
		anagram obj = new anagram();
		boolean res = obj.checkAnagram(word1, word2);
		
		if(res==true)
			System.out.println("Given word is an anagram");
		else
			System.out.println("Given word is not an anagram");

	}

}
