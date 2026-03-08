/*
Q2. Consider a string, S, that is a series of characters, each followed by its frequency as an integer.
The string is not compressed correctly, so there may be multiple occurrences of the same character.
A properly compressed string will consist of one instance of each character in alphabetical order followed by the
total count of that character within the string.

Ex :
input
Str = "a3c2b1a2c1";
Output a5b1c3
 */
import java.util.*;

public class CompressString {
    public static String compress(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i += 2) {
            char ch = s.charAt(i);
            int count = s.charAt(i + 1) - '0';
            map.put(ch, map.getOrDefault(ch, 0) + count);
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder result = new StringBuilder();
        for (char c : keys) {
            result.append(c).append(map.get(c));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "a3c2b1a2c1";
        System.out.println(compress(s));
    }
}
/*
Why - '0' is used
------------------
In Java, char values are stored using ASCII (Unicode) codes.
| Character | ASCII value |
| --------- | ----------- |
| '0'       | 48          |
| '1'       | 49          |
| '2'       | 50          |
| '3'       | 51          |
| '9'       | 57          |


When you do:
s.charAt(i + 1)
you get a character, not a number.
Example:char c = '3';
System.out.println((int)c);
Output:51
But we want 3, not 51.
So we subtract '0':
'3' - '0'
ASCII calculation:  51 - 48 = 3
So we get the actual integer value.

---------------------------------
 */