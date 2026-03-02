/*
Two strings are given: word and substr.
Some of the characters in word are question marks (?). You need to replace every ? with a lowercase English letter (a–z) such that:
 - substr appears at least once as a substring of the modified word.
 - The resulting string is lexicographically smallest among all possible valid strings.
If it is not possible to make substr appear** even after replacements, return "-1".

Note:
1. A substring is a contiguous sequence of characters within a string.
   For example, "bcd" is a substring of "abcde" but "ac" is not

2. For two strings a and b of the same length,
   a is lexicographically smaller than b if at the first position where they differ,
   a has a character that comes before b in alphabetical order.

Example :
Input:
       word = "a?c?e"
       substr = "bcd"

Output :
       abcde
 */
public class StringReplacement {

    public static String getSmallestString(String word, String substr) {
        int n = word.length();
        int m = substr.length();
        String smallest = null;

        for (int i = 0; i <= n - m; i++) {
            char[] temp = word.toCharArray();
            boolean possible = true;

            // Try placing substr at index i
            for (int j = 0; j < m; j++) {
                if (temp[i + j] == '?' || temp[i + j] == substr.charAt(j)) {
                    temp[i + j] = substr.charAt(j);
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) continue;

            // Replace remaining '?' with 'a'
            for (int k = 0; k < n; k++) {
                if (temp[k] == '?') {
                    temp[k] = 'a';
                }
            }

            String candidate = new String(temp);

            if (smallest == null || candidate.compareTo(smallest) < 0) {
                smallest = candidate;
            }
        }

        return smallest == null ? "-1" : smallest;
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString("a?c?e", "bcd"));
    }
}