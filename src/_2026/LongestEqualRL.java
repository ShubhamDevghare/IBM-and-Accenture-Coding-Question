package _2026;
// date : 09-03-2026
/*
Given a String,  you have to find the length of the longest substring having equal number of R and L
Input : RLRRLLRLRL
Output: 10
*/

/*
Solution:🧠 The Logic: The "Net Balance" Technique
-----------------------------------------------------
If the "Position" (Balance) is the same at two different times, it means everything that
happened between those two times canceled each other out.
  At Index 0, the balance was 1.
  At Index 4, the balance is 1 again.
  Conclusion: Between index 0 and 4, the 'R's and 'L's were equal, so they didn't change the net balance.
  Length calculation: 4 - 0 = 4.

  🛠️ Why use a HashMap?
  ---------------------
  In Java, we use a HashMap<Integer, Integer> to remember the earliest time we saw a specific balance.
  Key: The balance value (e.g., 1, 2, -1).
  Value: The first index where that balance occurred.

  We only store the first index because we want the longest substring. If we see balance "1" at
  index 0 and again at index 10, the distance (10 - 0 = 10) is much better than if we had
  updated the map at index 5.
 */

import java.util.HashMap;

public class LongestEqualRL {
    public static int findMaxLength(String s) {
        // Map to store (runningBalance, firstIndexEncountered)
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningBalance = 0;
        int maxLength = 0;

        // Base case: a balance of 0 is effectively seen at index -1
        map.put(0, -1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                runningBalance++;
            } else {
                runningBalance--;
            }

            if (map.containsKey(runningBalance)) {
                // If we've seen this balance before, calculate distance
                int prevIndex = map.get(runningBalance);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Only store the first time we see a balance to keep it "longest"
                map.put(runningBalance, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "RLRRLLRLRL";
        System.out.println("Longest balanced substring length: " + findMaxLength(input));
        // For "RLRRLLRLRL", the entire string is balanced, so output is 10.
    }
}

/*

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

 */