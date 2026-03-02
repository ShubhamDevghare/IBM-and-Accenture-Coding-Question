package AccentureCoddingQue.Aug_23_2024;

import java.util.Scanner;

public class SecondLargestCounter {

    public static int countSecondLargest(int[] sortedArray, int size) {
        int count = 0;
        int index = size - 1;

        // Skip all occurrences of the largest element
        while (index >= 0 && sortedArray[index] == sortedArray[size - 1]) {
            index--;
        }

        // If all elements are the same, return 0
        if (index < 0) {
            return 0;
        }

        // The second largest element is at sortedArray[index]
        int secondLargestValue = sortedArray[index];

        // Count occurrences of the second largest element
        while (index >= 0 && sortedArray[index] == secondLargestValue) {
            count++;
            index--;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        int[] sortedArray = new int[size];

        // Input array elements
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < size; i++) {
            sortedArray[i] = sc.nextInt();
        }

        // Call the countSecondLargest method to count occurrences of second largest element
        int result = countSecondLargest(sortedArray, size);
        System.out.println("Count of second largest element: " + result);

        sc.close();
    }
}
