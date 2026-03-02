package AccentureCoddingQue.Aug_23_2024;
/*
Que:
Given string and two characters ch1,ch2 as input, replace all occurrence of ch1 with ch2
and ch2 with ch1 in the input string.
 */
import java.util.Scanner;

public class SwapCharactersInString {

    public static String solve(String str, char ch1, char ch2) {
        // Convert the string to a character array for easy modification
        char[] charArray = str.toCharArray();

        // Traverse the character array and swap the characters
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ch1) {
                charArray[i] = ch2; // Replace ch1 with ch2
            } else if (charArray[i] == ch2) {
                charArray[i] = ch1; // Replace ch2 with ch1
            }
        }

        // Convert the character array back to a string and return
        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the string and the two characters
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        System.out.print("Enter first character to be swapped: ");
        char ch1 = scanner.next().charAt(0);

        System.out.print("Enter second character to be swapped: ");
        char ch2 = scanner.next().charAt(0);

        // Call the solve method to swap characters and print the result
        String result = solve(str, ch1, ch2);
        System.out.println("String after swapping characters: " + result);

        scanner.close();
    }
}
