package AccentureCoddingQue.Aug_30_2024_slot1_slot2;
/*
Que: To print the sum of even and odd numbers in an array
 */
import java.util.Scanner;

public class SumEvenOdd {

    public static void sumEvenOdd(int[] arr, int n) {
        int evenSum = 0;
        int oddSum = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                evenSum += arr[i];  // Add to evenSum if the number is even
            } else {
                oddSum += arr[i];   // Add to oddSum if the number is odd
            }
        }

        // Print the results
        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        // Input the elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the function to calculate the sum of even and odd numbers
        sumEvenOdd(arr, n);

        sc.close();
    }
}
