/****
 *
 * Length of the longest substring
 *
 * Given a string S, find the length of the longest substring without repeating characters.
 *
 * Input:
 * S = "abdefgabef"
 *
 * Output:
 * 6
 *
 * Explanation:
 * Longest substring are
 * "abdefg" , "bdefga" and "defgab".
 *
 */

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    public static void main(String[] arge) {

        LongestUniqueSubstring longestUniqueSubstring = new LongestUniqueSubstring();
        System.out.println(longestUniqueSubstring.longestUniqueSubsttr("aaaaaaaaaa"));
    }


    int longestUniqueSubsttr(String input) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < input.length(); ) {

            char ch = input.charAt(i);
            Integer index = map.get(ch);

            if (index == null) {
                map.put(ch, i);
                currentLength++;
                i++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 0;

                i = index + 1;
            }
        }
        return Math.max(maxLength, currentLength);
    }
}


