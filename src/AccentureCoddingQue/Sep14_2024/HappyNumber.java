package AccentureCoddingQue.Sep14_2024;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>(); // To track numbers we've seen to detect cycles
        while (n != 1 && !seen.contains(n)) {
            seen.add(n); // Add the current number to the set
            n = getNext(n); // Compute the next number
        }
        return n == 1; // Return true if we ended up with 1, false otherwise
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10; // Get the last digit
            n = n / 10; // Remove the last digit
            totalSum += d * d; // Add the square of the digit to the total sum
        }
        return totalSum; // Return the sum of squares of digits
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        // Test cases
        int[] testNumbers = {19, 2, 7, 23, 4};

        for (int num : testNumbers) {
            boolean result = happyNumber.isHappy(num);
            System.out.println("Is " + num + " a happy number? " + result);
        }
    }
}
