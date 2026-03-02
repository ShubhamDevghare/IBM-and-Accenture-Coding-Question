package AccentureCoddingQue.Sep14_2024;
/*
Given 2 numbers, dice and num, if dice is even then print the sum of digits in odd index,
if dice is odd then print the sum of digits in even index

 */
import java.util.Scanner;

public class DiceandNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dice = scanner.nextInt();
        int num = scanner.nextInt();

        int countDigit = 0;   // to count no of digits in num
        int sum1 = 0;
        int sum2 = 0;
        int flag = 0;

        // Process the digits of 'num'
        while (num > 0) {
            if (flag == 0) {
                sum1 += num % 10;
            } else {
                sum2 += num % 10;
            }

            num /= 10;       // update value of num
            countDigit++;
            flag = 1 - flag; // Alternates between 0 and 1
        }

        int evenIndexSum, oddIndexSum;

        if (countDigit % 2 == 1) {
            evenIndexSum = sum1;
            oddIndexSum = sum2;
        } else {
            evenIndexSum = sum2;
            oddIndexSum = sum1;
        }

        if (dice % 2 == 1) {
            System.out.println(evenIndexSum);
        } else {
            System.out.println(oddIndexSum);
        }

        scanner.close();
    }
}

//-------------------------Alternative Approach ---------------------------------

/*

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dice = scanner.nextInt();
        int num = scanner.nextInt();

        String numStr = Integer.toString(num); // Convert the number to a string
        int length = numStr.length();

        int evenIndexSum = 0;
        int oddIndexSum = 0;

        // Iterate over each digit in the string representation of num
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            if (i % 2 == 0) { // Even index
                evenIndexSum += digit;
            } else { // Odd index
                oddIndexSum += digit;
            }
        }

        // Print the appropriate sum based on the value of dice
        if (dice % 2 == 0) {
            // If dice is even, print the sum of digits at odd indices
            System.out.println(oddIndexSum);
        } else {
            // If dice is odd, print the sum of digits at even indices
            System.out.println(evenIndexSum);
        }

        scanner.close();
    }
}


 */