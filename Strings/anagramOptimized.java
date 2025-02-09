import java.util.*;
// optimized approach for Anagram
public class anagram {

	boolean checkAnagram(String word1, String word2){
		
		
		   if(word1.length()!=word2.length()) {
				return false;
			}
		   char[] arr1 = word1.toCharArray();
		   char[] arr2 = word2.toCharArray();
		   
		   Arrays.sort(arr1);
		   Arrays.sort(arr2);
		   
		   if(Arrays.equals(arr1, arr2))
		     	return true;
		   else
		        return false;
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
