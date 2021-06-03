/***********************************************************************************
 *
 * Given an array of strings, return all groups of strings that are anagrams.
 * The groups must be created in order of their appearance in the original array.
 * Look at the sample case for clarification.
 *
 * Input:
 * N = 5
 * words[] = {act,god,cat,dog,tac}
 * Output:
 * god dog
 * act cat tac
 * Explanation:
 * There are 2 groups of
 * anagrams "god", "dog" make group 1.
 * "act", "cat", "tac" make group 2.
 *
 ************************************************************************************/

import java.util.*;

public class AnagramsOfString {

    public static void main(String[] args) {

        AnagramsOfString anagramsOfString = new AnagramsOfString();

        String[] words = {"act", "god", "cat", "dog", "tac"};
        System.out.println(anagramsOfString.getAnagrams(words));
    }

    public List<List<String>> getAnagrams(String[] string_list) {

        List<List<String>> anagrams = new ArrayList<List<String>>();

        Map<String, Integer> map = new HashMap();
        int grp = 0;

        for (int i = 0; i < string_list.length; i++) {

            String s = string_list[i];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            System.out.println(arr);

            if (map.containsKey(String.valueOf(arr))) {
                int index = map.get(String.valueOf(arr));
                List<String> targetGroup = anagrams.get(index);
                targetGroup.add(s);
            } else {
                List<String> groups = new ArrayList<>();
                groups.add(s);
                map.put(String.valueOf(arr), grp++);
                anagrams.add(groups);
            }
        }

        return anagrams;

    }
}
