/**
 * Given a string, find all distinct palindromic sub-strings of length>1. For example, str=”abaaa” then possible palindromic sub-strings are: aa, aaa, aba.
 */

//imports
import java.util.Scanner;
import java.util.HashSet;

public class PalindromicSubstrings {
    //check whether a string is a palindrome or not
    private static boolean isPalindrome(String str) {        
        str = str.toLowerCase();
        for(int i = 0, j = str.length()-1; i < j; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    //generates substrings and adds them to a hashset if they're a palindrome
    private static HashSet<String> generateSubstrings(String str) {
        HashSet<String> palindromes = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            for(int j = i+2; j <= str.length(); j++) {
                String substr = str.substring(i,j);
                if(isPalindrome(substr) && substr.length()>1)
                    palindromes.add(substr);
            }
        }
        return palindromes;
    }
    
    //main driver code
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String str = sc.nextLine();
            
            HashSet<String> palindromes = generateSubstrings(str);
            for(String palindrome : palindromes) {
                System.out.print(palindrome+" ");
            }
        }
    }
}
