package AccentureCoddingQue.Aug_6_2024;

/*
Que :Find k words of a string Example :      Input : My name is shubham         Output : My name is
=======================================================================================================

input.split("\\s+") method :
-------------------------------
splits a string into an array of words based on one or more spaces
(\\s+ is a regular expression for whitespace).
This means it splits the string wherever it encounters spaces, regardless of how many there are.

-  " \\s " is a regular expression that matches any whitespace character (space, tab, newline, etc.).
-  The " + " indicates one or more occurrences" of the whitespace characters.
This means that the  split("\\s+")  -->  method will split the input string wherever there is one or more
consecutive whitespace characters.

Note:
[
    \s is the actual regular expression symbol for any whitespace character.
    \\s is how you write \s in a Java string because Java uses \ as an escape character,
        so you need to double it.
]
result.toString().trim() :
------------------------
The result.toString().trim() method is used to convert the StringBuilder object to a String and then
remove any leading or trailing whitespace.
Breakdown:
----------
result.toString(): This converts the StringBuilder object (which accumulates the words in the loop) to a String.

.trim(): This removes any leading or trailing whitespace from the resulting string.
Since we append a space after each word in the loop, the final string might have an extra space at the end.
The trim() method helps get rid of that
 */
import java.util.Scanner;

public class FirstKWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the string and number of words to extract
        System.out.println("Enter the string:");
        String str = scanner.nextLine();

        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        // Split the input string by spaces
        String[] words = str.split("\\s+");

        // StringBuilder to store the result
        StringBuilder sb = new StringBuilder();

        // Extract the first k words
        for (int i = 0; i < k && i < words.length; i++) {
            sb.append(words[i]).append(" ");
        }

        // Trim the final result to remove extra space
        System.out.println("First " + k + " words: " + sb.toString().trim());
    }
}
