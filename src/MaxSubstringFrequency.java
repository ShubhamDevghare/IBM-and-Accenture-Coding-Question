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

/*
1️⃣ What the Question Is Asking
You are given:

A string
minLength
maxLength
maxUnique

You must:

Find all substrings whose length is between minLength and maxLength
The substring must contain at most maxUnique different characters
Among those substrings, find which substring appears the most times
Return the frequency (count) of that most frequent substring.

2️⃣ Example From Your Code
--------------------------
s = "aababcaab"
minLength = 3
maxLength = 4
maxUnique = 2

Meaning:
Substring length must be 3 or 4
Substring can contain at most 2 unique characters
We must return the maximum frequency of a valid substring

1️⃣ All substrings of length = 3
| Substring | Unique chars | Valid?  |
| --------- | ------------ | ------  |
| aab       | 2            | ✅      |
| aba       | 2            | ✅      |
| bab       | 2            | ✅      |
| abc       | 3            | ❌      |
| bca       | 3            | ❌      |
| caa       | 2            | ✅      |
| aab       | 2            | ✅      |

Valid ones:
aab
aba
bab
caa
aab
Frequency:
aab → 2
aba → 1
bab → 1
caa → 1

2️⃣ Substrings of length = 4
| Substring | Unique chars | Valid? |
| --------- | ------------ | ------ |
| aaba      | 2            | ✅      |
| abab      | 2            | ✅      |
| babc      | 3            | ❌      |
| abca      | 3            | ❌      |
| bcaa      | 3            | ❌      |
| caab      | 3            | ❌      |

Valid:
aaba
abab

Frequency:
aaba → 1
abab → 1

3️⃣ Combine Frequencies
aab → 2
aba → 1
bab → 1
caa → 1
aaba → 1
abab → 1

4️⃣ Maximum Frequency
aab → 2
So answer:
2

✅ Final Output
2

⚠️ Important Interview Trick
==============================
Even though the problem says:
minLength ≤ substring length ≤ maxLength

We only check minLength because longer substrings will not increase the frequency.
That’s why your code uses window size = minLength only.

 */