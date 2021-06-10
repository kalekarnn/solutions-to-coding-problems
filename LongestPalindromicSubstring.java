/***********************************************************************************
 *
 * Longest Palindromic Substring
 *
 * Given a string S, find the longest palindromic substring in S. Substring of
 * string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string
 * which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
 * Incase of conflict, return the substring which occurs first
 * ( with the least starting index ).
 *
 * Example 1:
 *
 * Input:
 * S = "aaaabbaa"
 * Output:
 * aabbaa
 * Explanation:
 * The longest palindrome string present in
 * the given string is "aabbaa".
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function
 * longestPalindrome() which takes string S as input parameters and returns longest
 * pallindrome present in string.
 *
 *****************************************************************************************/

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
        System.out.println(substring.longestPalindrome("aaaabbaa"));
    }

    String longestPalindrome(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {

                String str = input.substring(i, j + 1);
                String revStr = new StringBuilder(str).reverse().toString();

                if (str.equals(revStr)) {
                    if (str.length() > result.length()) {
                        result = str;
                    }
                }
            }
        }

        return result;
    }
}
