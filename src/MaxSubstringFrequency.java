import java.util.*;
/*
Given a string containing a number of characters, find the substrings within the string that satisfy the conditions below:
The substring's length should be in the inclusive interval [minLength, maxLength].

 - The total number of unique characters should not exceed maxUnique.
 - Using those conditions, determine the frequency of the maximum occurring substring.
Example :
components = 'abcde'
minLength = 2
maxLength = 3
 */
public class MaxSubstringFrequency {

    public static int maxFreq(String s, int minLength, int maxLength, int maxUnique) {
        Map<String, Integer> substringCount = new HashMap<>();
        Map<Character, Integer> charCount = new HashMap<>();

        int left = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            charCount.put(s.charAt(right),
                    charCount.getOrDefault(s.charAt(right), 0) + 1);

            // Maintain window size = minLength
            if (right - left + 1 > minLength) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            // When window size equals minLength
            if (right - left + 1 == minLength) {
                if (charCount.size() <= maxUnique) {
                    String sub = s.substring(left, right + 1);
                    int count = substringCount.getOrDefault(sub, 0) + 1;
                    substringCount.put(sub, count);
                    maxFrequency = Math.max(maxFrequency, count);
                }
            }
        }

        return maxFrequency;
    }

    public static void main(String[] args) {
        String components = "abcde";
        int minLength = 2;
        int maxLength = 3;
        int maxUnique = 3;

        System.out.println(maxFreq(components, minLength, maxLength, maxUnique));
    }
}