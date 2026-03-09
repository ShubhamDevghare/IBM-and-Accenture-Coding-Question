package _2026;
// date : 09-03-2026
import java.util.*;
/*
Given a String,  you have to find the length of the longest substring having equal number of R and L
Input : RLRRLLRLRL
Output: 10
*/
public class LongestEqualRL {

    public static int longestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        map.put(0, -1); // base case

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'R') {
                sum += 1;
            } else if (s.charAt(i) == 'L') {
                sum -= 1;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(longestSubstring(s));
    }
}