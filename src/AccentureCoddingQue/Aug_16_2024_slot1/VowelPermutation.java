package AccentureCoddingQue.Aug_16_2024_slot1;
/*
Que:
You are given a string S and your task is to find and return the count of permutation formed by
fixing the positions of the vowels present in the string.
Note:
• Ensure the result is non-negative • If there are no consonants then return 0
---------------------------------------------------------------------------------------------------------

Self Note:
Post-Decrement (n--):
--------------------
The post-decrement operator first uses the current value of n and
then decrements n after the expression is evaluated.

Before: n = 5
After: n = 4 (but the value 5 is used in the current expression)

 */
import java.util.HashSet;
import java.util.Scanner;

public class VowelPermutation {

    // Limit for factorial calculation to avoid overflow (optional)
    private static final long MAX_FACTORIAL = Integer.MAX_VALUE;

    // Function to calculate factorial with overflow check
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        long ans = 1;
        while (n > 0) {
            ans *= n--;
            // Check if the result exceeds MAX_FACTORIAL (optional)
            if (ans > MAX_FACTORIAL) {
                System.out.println("Factorial too large, overflow may occur.");
                return -1;  // Indicate overflow
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // Set to store vowels for fast lookup
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int consonantCount = 0;

        // Loop to count consonants in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Check if the character is a letter and not a vowel
            if (Character.isLetter(ch) && !vowels.contains(ch)) {
                consonantCount++;
            }
        }

        // If there are no consonants, return 0
        if (consonantCount == 0) {
            System.out.println(0);
        } else {
            // Calculate the factorial and check for overflow
            long result = factorial(consonantCount);
            if (result != -1) {  // Only print if no overflow
                System.out.println(result);
            }
        }
    }
}
