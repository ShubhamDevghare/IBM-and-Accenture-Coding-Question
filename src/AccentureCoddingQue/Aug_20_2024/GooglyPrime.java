package AccentureCoddingQue.Aug_20_2024;
/*
Que:
A googly prime number is defined as a number that is derived from the sum of its individual
digits.
For example, if N = 43, the sum of its individual digits is 4+3 = 7,
which is prime making it a googly prime number. 4
Your task is to find whether the current number is googly prime number or not.

What is Googly prime number?
---------------------------------
A "Googly prime number" is a number where the sum of its digits is a prime number.
It doesn’t require the number itself to be prime, but rather the sum of its digits.
 */
import java.util.Scanner;

public class GooglyPrime {

    // Function to calculate the sum of digits of a number
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Main function to check if the number is a googly prime number
    public static boolean isGooglyPrime(int num) {
        int sum = sumOfDigits(num);
        return isPrime(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (isGooglyPrime(num)) {
            System.out.println(num + " is a googly prime number.");
        } else {
            System.out.println(num + " is not a googly prime number.");
        }
    }
}
