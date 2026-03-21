package MostFrequent.Strings;

import java.util.*;

/**
 * ============================================================
 *   TOP 30 MOST IMPORTANT & REPEATING DSA STRING QUESTIONS
 * ============================================================
 *
 * Topics Covered:
 *  Q01 - Reverse a String
 *  Q02 - Check Palindrome
 *  Q03 - Check Anagram
 *  Q04 - First Non-Repeating Character
 *  Q05 - Count Character Frequency
 *  Q06 - Longest Palindromic Substring (Expand Around Center)
 *  Q07 - Longest Common Prefix
 *  Q08 - Valid Parentheses
 *  Q09 - String Compression / Run-Length Encoding
 *  Q10 - Reverse Words in a Sentence
 *  Q11 - Check if Two Strings are Rotations
 *  Q12 - Remove Duplicates from String
 *  Q13 - Longest Substring Without Repeating Characters (Sliding Window)
 *  Q14 - Count and Say
 *  Q15 - Roman to Integer
 *  Q16 - Implement strStr() / indexOf
 *  Q17 - Group Anagrams
 *  Q18 - Minimum Window Substring
 *  Q19 - Longest Repeating Character Replacement
 *  Q20 - Decode Ways (DP)
 *  Q21 - Palindrome Partitioning
 *  Q22 - Word Break (DP)
 *  Q23 - Wildcard Matching
 *  Q24 - Regular Expression Matching (. and *)
 *  Q25 - Minimum Edit Distance (Levenshtein)
 *  Q26 - Interleaving String
 *  Q27 - Largest Number from Array of Numbers
 *  Q28 - Reverse Only Letters
 *  Q29 - Check if String is a Valid Shuffle of Two Others
 *  Q30 - Zigzag Conversion
 */
public class StringDSA30Questions {

    // ============================================================
    // Q01: Reverse a String
    // Approach: Two-pointer swap
    // Time: O(n), Space: O(n)
    // ============================================================
    public static String reverseString(String s) {
        char[] ch = s.toCharArray();
        int left = 0, right = ch.length - 1;
        while (left < right) {
            char temp = ch[left];
            ch[left++] = ch[right];
            ch[right--] = temp;
        }
        return new String(ch);
    }


    // ============================================================
    // Q02: Check if a String is Palindrome
    // Approach: Two-pointer from both ends
    // Time: O(n), Space: O(1)
    // ============================================================
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }


    // ============================================================
    // Q03: Check if Two Strings are Anagrams
    // Approach: Frequency count array of size 26
    // Time: O(n), Space: O(1)
    // ============================================================
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char c : t.toCharArray()) freq[c - 'a']--;
        for (int f : freq) if (f != 0) return false;
        return true;
    }


    // ============================================================
    // Q04: First Non-Repeating Character
    // Approach: LinkedHashMap preserves insertion order
    // Time: O(n), Space: O(1) — at most 26 entries
    // ============================================================
    public static char firstNonRepeating(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (Map.Entry<Character, Integer> e : map.entrySet())
            if (e.getValue() == 1) return e.getKey();
        return '\0'; // no unique character
    }


    // ============================================================
    // Q05: Count Character Frequency
    // Approach: int array of size 26
    // Time: O(n), Space: O(1)
    // ============================================================
    public static void printFrequency(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                System.out.print((char)('a' + i) + ":" + freq[i] + " ");
        System.out.println();
    }


    // ============================================================
    // Q06: Longest Palindromic Substring
    // Approach: Expand Around Center (for both odd & even length)
    // Time: O(n^2), Space: O(1)
    // ============================================================
    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // odd length
            int len2 = expandFromCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end   = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    // ============================================================
    // Q07: Longest Common Prefix
    // Approach: Horizontal scanning — compare prefix iteratively
    // Time: O(n*m), Space: O(1)
    // ============================================================
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (!strs[i].startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() - 1);
        return prefix;
    }


    // ============================================================
    // Q08: Valid Parentheses
    // Approach: Stack — push open, pop & match on close
    // Time: O(n), Space: O(n)
    // ============================================================
    public static boolean isValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }


    // ============================================================
    // Q09: String Compression (Run-Length Encoding)
    // Approach: Iterate and count consecutive characters
    // Time: O(n), Space: O(n)
    // ============================================================
    public static String compress(String s) {
        if (s == null || s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1));
                if (count > 1) sb.append(count);
                count = 1;
            }
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }


    // ============================================================
    // Q10: Reverse Words in a Sentence
    // Approach: Split by spaces, reverse array, join
    // Time: O(n), Space: O(n)
    // ============================================================
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }


    // ============================================================
    // Q11: Check if One String is a Rotation of Another
    // Approach: s2 is rotation of s1 iff s2 is a substring of s1+s1
    // Time: O(n), Space: O(n)
    // ============================================================
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }


    // ============================================================
    // Q12: Remove Duplicate Characters
    // Approach: LinkedHashSet preserves order, removes dupes
    // Time: O(n), Space: O(n)
    // ============================================================
    public static String removeDuplicates(String s) {
        Set<Character> seen = new LinkedHashSet<>();
        for (char c : s.toCharArray()) seen.add(c);
        StringBuilder sb = new StringBuilder();
        for (char c : seen) sb.append(c);
        return sb.toString();
    }


    // ============================================================
    // Q13: Longest Substring Without Repeating Characters
    // Approach: Sliding Window + HashMap
    // Time: O(n), Space: O(min(n, m)) where m = charset size
    // ============================================================
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left)
                left = map.get(c) + 1;
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


    // ============================================================
    // Q14: Count and Say
    // Approach: Simulate — describe previous term in terms of counts
    // Time: O(2^n), Space: O(2^n)
    // ============================================================
    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= result.length(); j++) {
                if (j < result.length() && result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            result = sb.toString();
        }
        return result;
    }


    // ============================================================
    // Q15: Roman to Integer
    // Approach: Map values; subtract if smaller value precedes larger
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);   map.put('V', 5);   map.put('X', 10);
        map.put('L', 50);  map.put('C', 100);  map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur  = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
            result += (cur < next) ? -cur : cur;
        }
        return result;
    }


    // ============================================================
    // Q16: Implement strStr() (Find needle in haystack)
    // Approach: Sliding window comparison (KMP in production)
    // Time: O(n*m), Space: O(1)
    // ============================================================
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) return i;
        }
        return -1;
    }


    // ============================================================
    // Q17: Group Anagrams
    // Approach: Sort each word as a key in a HashMap
    // Time: O(n * k log k), Space: O(n*k)
    // ============================================================
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }


    // ============================================================
    // Q18: Minimum Window Substring
    // Approach: Sliding window with two frequency maps
    // Time: O(n + m), Space: O(n + m)
    // ============================================================
    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, formed = 0, required = need.size();
        Map<Character, Integer> window = new HashMap<>();
        int[] ans = {-1, 0, 0}; // length, left, right

        while (right < s.length()) {
            char c = s.charAt(right++);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue())
                formed++;
            while (left < right && formed == required) {
                if (ans[0] == -1 || right - left < ans[0]) {
                    ans[0] = right - left;
                    ans[1] = left;
                    ans[2] = right;
                }
                char lc = s.charAt(left++);
                window.put(lc, window.get(lc) - 1);
                if (need.containsKey(lc) && window.get(lc) < need.get(lc))
                    formed--;
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]);
    }

    /* ============================================================
Q19: Longest Repeating Character Replacement
     Approach: Sliding window — keep track of max frequency char
     Time: O(n), Space: O(1)
    ============================================================*/
/*
Que: You are given a string s and an integer k. You can choose any character of the string and change it to any other
     uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the
above operations.

Example 1:
---------
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

*/
    /*
    Approch :
  ------------
    Instead of actually replacing characters, we:   **(means here we are not actually replacing characters we are other approch/logic)

          Maintain a window [left, right]
          Track the most frequent character count (maxCount) inside the window
          Check if the window is valid using:
          window size − maxCount  ≤ 𝑘
          If this condition fails → shrink the window
     */
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);

            // Window size - most frequent char > k → shrink from left
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left++) - 'A']--;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /* ============================================================
     Q20: Decode Ways
    Approach: Dynamic Programming
    dp[i] = number of ways to decode s[0..i-1]
    Time: O(n), Space: O(n)

 Que:  You are given a string s containing only digits. Each digit (or pair of digits) can be mapped to letters as follows:
            '1' -> 'A'
            '2' -> 'B'
            ...
            '26' -> 'Z'
    Return the total number of ways to decode the string.
Ex:
   Input: "12"
   Output: 2
Explanation:
   "12" → "AB" (1 2)
   "12" → "L"  (12)

ex:
🔁 Step-by-Step Example: "226"
_______________________________________________
| i | Substring | oneDigit | twoDigit | dp[i] |
| - | --------- | -------- | -------- | ----- |
| 0 | ""        | -        | -        | 1     |
| 1 | "2"       | 2        | -        | 1     |
| 2 | "22"      | 2        | 22       | 2     |
| 3 | "226"     | 6        | 26       | 3     |
-----------------------------------------------

Initial Setup:
dp[0] = 1   // empty string
dp[1] = 1   // "2"

Step i = 2 → substring "22"
  oneDigit = "2" ✅ valid
  twoDigit = "22" ✅ valid

Start:
  dp[2] = 0
  Add from dp[i-1]
  dp[2] += dp[1]   → 0 + 1 = 1
  Add from dp[i-2]
  dp[2] += dp[0]   → 1 + 1 = 2
  Final:
  dp[2] = 2

Step i = 3 → substring "226"
oneDigit = "6" ✅ valid
twoDigit = "26" ✅ valid

Start:
   dp[3] = 0
   First line
   dp[3] += dp[2]   → 0 + 2 = 2
   👉 Ways so far:
(2)(2)(6)
(22)(6)
   Second line
   dp[3] += dp[1]   → 2 + 1 = 3
👉 New way added:
(2)(26)
   Final Answer
   dp[3] = 3
    ============================================================*/
    public static int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') return 0; //If string is empty or starts with '0', no valid decoding.
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1; //empty string has 1 way
        dp[1] = 1; //first char already checked (not '0')

        for (int i = 2; i <= n; i++) {
           // Extract last 1 digit and last 2 digits
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            //If single digit valid → add ways from previous index
            if (oneDigit >= 1)
                dp[i] += dp[i - 1];

            //If two digits valid → add ways from two steps back
            if (twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n]; //Final answer is stored in dp[n]
    }


    /* ============================================================
     Q21: Palindrome Partitioning
     Approach: Backtracking — try every partition, check palindrome
     Time: O(n * 2^n), Space: O(n)
🔁 How the Algorithm Works
                         Start from index 0
                         Try all possible substrings
                         If substring is a palindrome → choose → explore → backtrack
     ============================================================
     Que: Given a string s, partition the string such that every substring of the partition is a palindrome.
          Return all possible palindrome partitionings of the string.
     Example 1:
             Input: s = "aab"
             Output: [["a","a","b"],["aa","b"]]

     */
    public static List<List<String>> palindromePartition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    private static void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);  // substring(start, end) here start → inclusive   end → exclusive (NOT included)
            if (isPalindrome(sub)) {
                current.add(sub); // → choose
                backtrack(s, end, current, result);// →  explore          // → go forward
                current.remove(current.size() - 1);// → undo        //→ remove last block and try a different one
            }
        }
    }
    /*
🌳Example 1:  "aabcc"

Start: [], index = 0
1️⃣ Pick "a" (0→1) ✅ palindrome

Current → ["a"]

From index = 1
2️⃣ Pick "a" (1→2) ✅

Current → ["a", "a"]

From index = 2
3️⃣ Pick "b" (2→3) ✅

Current → ["a", "a", "b"]

From index = 3
4️⃣ Pick "c" (3→4) ✅

Current → ["a", "a", "b", "c"]

From index = 4
5️⃣ Pick "c" (4→5) ✅

Current → ["a", "a", "b", "c", "c"]

👉 Reached end → ✅ ADD RESULT

["a", "a", "b", "c", "c"]
🔙 Backtrack to index = 3

Try "cc" (3→5) ✅ palindrome
Current → ["a", "a", "b", "cc"]

👉 Reached end → ✅ ADD RESULT

["a", "a", "b", "cc"]
🔙 Backtrack to index = 2

Try "bc" ❌
Try "bcc" ❌
→ No more options → backtrack

🔙 Backtrack to index = 1

Try "ab" ❌
Try "abc" ❌
Try "abcc" ❌

🔙 Backtrack to index = 0
6️⃣ Pick "aa" (0→2) ✅

Current → ["aa"]

From index = 2
7️⃣ Pick "b" (2→3) ✅

Current → ["aa", "b"]

From index = 3
8️⃣ Pick "c" → then "c"

Result:

["aa", "b", "c", "c"]
9️⃣ Pick "cc"

Result:

["aa", "b", "cc"]
✅ Final Output
[
  ["a", "a", "b", "c", "c"],
  ["a", "a", "b", "cc"],
  ["aa", "b", "c", "c"],
  ["aa", "b", "cc"]
]
     */


    // ============================================================
    // Q22: Word Break
    // Approach: Dynamic Programming
    // dp[i] = true if s[0..i-1] can be segmented
    // Time: O(n^2), Space: O(n)
    // ============================================================
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    // ============================================================
    // Q23: Wildcard Matching ('?' matches any single char, '*' matches any sequence)
    // Approach: Dynamic Programming
    // Time: O(n*m), Space: O(n*m)
    // ============================================================
    public static boolean wildcardMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // '*' can match empty sequence
        for (int j = 1; j <= n; j++)
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // match ≥1 OR match empty
                else if (pc == '?' || s.charAt(i - 1) == pc)
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }


    // ============================================================
    // Q24: Regular Expression Matching ('.' matches any single char, '*' matches 0+ preceding)
    // Approach: Dynamic Programming
    // Time: O(n*m), Space: O(n*m)
    // ============================================================
    public static boolean regexMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // Patterns like a*, a*b*, a*b*c* can match empty string
        for (int j = 2; j <= n; j += 2)
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1), sc = s.charAt(i - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 2]; // zero occurrences
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == sc)
                        dp[i][j] |= dp[i - 1][j]; // one+ occurrences
                } else if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }


    // ============================================================
    // Q25: Minimum Edit Distance (Levenshtein Distance)
    // Approach: Classic DP table
    // dp[i][j] = min ops to convert word1[0..i-1] to word2[0..j-1]
    // Time: O(m*n), Space: O(m*n)
    // ============================================================
    public static int minEditDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],     // replace
                                    Math.min(dp[i - 1][j],          // delete
                                             dp[i][j - 1]));         // insert
            }
        }
        return dp[m][n];
    }


/*============================================================
Q26: Interleaving String
Problem:
Given three strings s1, s2, and s3, determine whether s3 is formed by an interleaving of s1 and s2.
An interleaving of two strings means combining their characters while preserving the left-to-right order of characters
from each string.
Conditions :
1. Characters from s1 and s2 can be mixed together.
2. The relative order of characters from s1 must remain the same.
3. The relative order of characters from s2 must remain the same.
4. All characters from s1 and s2 must be used to form s3.

Approach: 2D DP
dp[i][j] = true if s3[0..i+j-1] is interleaving of s1[0..i-1] and s2[0..j-1]
Time: O(m*n), Space: O(m*n)
 ============================================================*/
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == c)
                         || (dp[i][j-1] && s2.charAt(j-1) == c);
            }
        }
        return dp[m][n];
    }


    // ============================================================
    // Q27: Largest Number formed from Array
    // Approach: Custom comparator — compare (a+b) vs (b+a) as strings
    // Time: O(n log n), Space: O(n)
    // ============================================================
    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        if (strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }


    // ============================================================
    // Q28: Reverse Only Letters (keep non-letter chars in place)
    // Approach: Two-pointer, skip non-letters
    // Time: O(n), Space: O(n)
    // ============================================================
    public static String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int left = 0, right = ch.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(ch[left]))  left++;
            while (left < right && !Character.isLetter(ch[right])) right--;
            char temp = ch[left]; ch[left++] = ch[right]; ch[right--] = temp;
        }
        return new String(ch);
    }

/* ============================================================
Q29: Check if String is a Valid Shuffle of Two Others:

You are given three strings: str1, str2, result
You must check whether result is formed by mixing (shuffling) characters of str1 and str2 while keeping the original
order of characters from each string.
  Key Rules:
     1.All characters of str1 and str2 must appear in result.
     2.The relative order of characters from each string must stay the same.
     3.Characters from both strings can interleave.

Example 1 (Valid Shuffle)
--------------------------
str1 = "abc"
str2 = "def"
result = "adbcef"

Order of abc and def is preserved ✔
So this is a valid shuffle.

Example 2 (Invalid Shuffle)
----------------------------
str1 = "abc"
str2 = "def"
result = "abdfec"

Here order of "def" changed (e comes before f correctly but c placed incorrectly relative to others),
so it breaks the original sequence ❌.

Approach: Sort all three; interleave pointers through s1 & s2 matching s3
Time: O(n log n), Space: O(n)
============================================================*/
    public static boolean isValidShuffle(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        // Verify same character counts
        int[] freq = new int[256];
        for (char c : s3.toCharArray()) freq[c]++;
        for (char c : s1.toCharArray()) freq[c]--;
        for (char c : s2.toCharArray()) freq[c]--;
        for (int f : freq) if (f != 0) return false;
        // DP to verify actual interleaving
        return isInterleave(s1, s2, s3);
    }

    /*
 ============================================================
 Q30: Zigzag Conversion

You are given:
A string s
A number of rows numRows
You must write the string in a zigzag pattern and then read it row by row.
Example
s = "PAYPALISHIRING"
numRows = 3
Pattern becomes:

P   A   H   N
A P L S I I G
Y   I   R

Now read row by row:
Row1 → PAHN
Row2 → APLSIIG
Row3 → YIR
Final output: PAHNAPLSIIGYIR

ie:
"PAYPALISHIRING" with numRows=3 → "PAHNAPLSIIGYIR"

Time: O(n), Space: O(n)
 */
    // ============================================================
    public static String zigzagConvert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int row = 0, step = 1;
        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row == 0)            step = 1;   // going down
            if (row == numRows - 1)  step = -1;  // going up
            row += step;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) result.append(sb);
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println("=== Q01: Reverse a String ===");
        System.out.println(reverseString("hello"));           // "olleh"

        System.out.println("\n=== Q02: Check Palindrome ===");
        System.out.println(isPalindrome("racecar"));          // true
        System.out.println(isPalindrome("hello"));            // false

        System.out.println("\n=== Q03: Check Anagram ===");
        System.out.println(isAnagram("listen", "silent"));    // true
        System.out.println(isAnagram("hello", "world"));      // false

        System.out.println("\n=== Q04: First Non-Repeating Character ===");
        System.out.println(firstNonRepeating("aabbcde"));     // 'c'
        System.out.println(firstNonRepeating("aabb"));        // '\0' (none)

        System.out.println("\n=== Q05: Count Character Frequency ===");
        printFrequency("programming");                         // counts each char

        System.out.println("\n=== Q06: Longest Palindromic Substring ===");
        System.out.println(longestPalindromicSubstring("babad"));  // "bab" or "aba"
        System.out.println(longestPalindromicSubstring("cbbd"));   // "bb"

        System.out.println("\n=== Q07: Longest Common Prefix ===");
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"})); // "fl"

        System.out.println("\n=== Q08: Valid Parentheses ===");
        System.out.println(isValidParentheses("()[]{}")); // true
        System.out.println(isValidParentheses("(]"));     // false

        System.out.println("\n=== Q09: String Compression ===");
        System.out.println(compress("aabcccdddd")); // "a2bc3d4"

        System.out.println("\n=== Q10: Reverse Words in a Sentence ===");
        System.out.println(reverseWords("the sky is blue")); // "blue is sky the"

        System.out.println("\n=== Q11: Check if Rotation ===");
        System.out.println(isRotation("abcde", "cdeab")); // true
        System.out.println(isRotation("abcde", "abced")); // false

        System.out.println("\n=== Q12: Remove Duplicates ===");
        System.out.println(removeDuplicates("programming")); // "progamin"

        System.out.println("\n=== Q13: Longest Substring Without Repeating Characters ===");
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3

        System.out.println("\n=== Q14: Count and Say ===");
        System.out.println(countAndSay(4)); // "1211"

        System.out.println("\n=== Q15: Roman to Integer ===");
        System.out.println(romanToInt("IX"));    // 9
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994

        System.out.println("\n=== Q16: strStr() / indexOf ===");
        System.out.println(strStr("hello", "ll"));  // 2
        System.out.println(strStr("aaaaa", "bba")); // -1

        System.out.println("\n=== Q17: Group Anagrams ===");
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));

        System.out.println("\n=== Q18: Minimum Window Substring ===");
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // "BANC"

        System.out.println("\n=== Q19: Longest Repeating Character Replacement ===");
        System.out.println(characterReplacement("AABABBA", 1)); // 4

        System.out.println("\n=== Q20: Decode Ways ===");
        System.out.println(numDecodings("226")); // 3
        System.out.println(numDecodings("06"));  // 0

        System.out.println("\n=== Q21: Palindrome Partitioning ===");
        System.out.println(palindromePartition("aab")); // [[a,a,b],[aa,b]]

        System.out.println("\n=== Q22: Word Break ===");
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen"))); // true

        System.out.println("\n=== Q23: Wildcard Matching ===");
        System.out.println(wildcardMatch("aa", "a*")); // true
        System.out.println(wildcardMatch("cb", "?a")); // false

        System.out.println("\n=== Q24: Regular Expression Matching ===");
        System.out.println(regexMatch("aa", "a*")); // true
        System.out.println(regexMatch("ab", ".*")); // true

        System.out.println("\n=== Q25: Minimum Edit Distance ===");
        System.out.println(minEditDistance("horse", "ros")); // 3
        System.out.println(minEditDistance("intention", "execution")); // 5

        System.out.println("\n=== Q26: Interleaving String ===");
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true

        System.out.println("\n=== Q27: Largest Number ===");
        System.out.println(largestNumber(new int[]{3,30,34,5,9})); // "9534330"

        System.out.println("\n=== Q28: Reverse Only Letters ===");
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj")); // "j-Ih-gfE-dCba"

        System.out.println("\n=== Q29: Valid Shuffle ===");
        System.out.println(isValidShuffle("abc", "def", "adbecf")); // true

        System.out.println("\n=== Q30: Zigzag Conversion ===");
        System.out.println(zigzagConvert("PAYPALISHIRING", 3)); // "PAHNAPLSIIGYIR"
    }

}
