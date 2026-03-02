package AccentureCoddingQue.Aug_27_28_2024;
/*
Que:
calculate spaces of two given input strings and return a string with whether their differences is odd or even
with ":" and count

example:
input1: "abc bcd cda"
input2: "abc bc"
Output: "Odd:1"
 */
public class SpaceDifference {

    // Method to count spaces in a given string
    public static int countSpaces(String str) {
        int spaceCount = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }

    // Method to calculate and return the result based on space difference
    public static String calculateSpaceDifference(String input1, String input2) {
        // Count spaces in both strings
        int spacesInInput1 = countSpaces(input1);
        int spacesInInput2 = countSpaces(input2);

        // Calculate the absolute difference between the space counts
        int difference = Math.abs(spacesInInput1 - spacesInInput2);

        // Determine if the difference is odd or even
        String result = (difference % 2 == 0) ? "Even:" : "Odd:";

        // Return the result in the required format
        return result + difference;
    }

    public static void main(String[] args) {
        // Test case
        String input1 = "abc bcd cda";
        String input2 = "abc bc";

        String result = calculateSpaceDifference(input1, input2);
        System.out.println(result);  // Output: Odd:1
    }
}
