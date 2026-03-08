/*
An English lecture at HackerElementary School is aimed at teaching students the letters of the alphabet.
The students are provided with a string word that consists of lowercase English letters.
In one move, they can choose any index i and let the character at that index be c.
Then, the first occurrence of c to the left of i and the first occurrence of c to the right of i are deleted
(Note the operation can still be carried out even if either the left or right occurrence doesn't exist).

For example, if
word = "adabacbea", and index 4 is chosen (0-based),
the first occurrence of 'a' to the left and right of index 4 (indices 2 and 6) are deleted leaving word = "adbacea".
Find the minimum number of moves the students need to perform in order to get a word of minimal length.
 */
/*
Example
-------
Consider word = "baabacaa"
The following moves are optimal.
Choose index 0, "baabacaa" → then word = "baaacaa"`.
Delete the b to its right at index 3. There is no b to its left so the operation is finished.
Now choose index 2, "baaacaa" → then **word = "bacaa"`.
Now choose index 3, "bacaa" → then **word = "bca"`.
 */
public class MinimalMove {
    public static int getMinMoves(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        int totalMoves = 0;
        for (int count : freq) {
            totalMoves += count / 2;
        }

        return totalMoves;
    }
}
