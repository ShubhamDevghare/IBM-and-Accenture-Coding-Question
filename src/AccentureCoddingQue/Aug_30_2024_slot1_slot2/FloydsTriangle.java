package AccentureCoddingQue.Aug_30_2024_slot1_slot2;
/*
Que:
To print the Floyd's triangle pattern for a given input number N,

Ex: Input N = 5
O/P:

1
2 3
4 5 6
7 8 9 10
11 12 13 14 15

 */
import java.util.Scanner;

public class FloydsTriangle {

    public static void printFloydsTriangle(int N) {
        int num = 1;  // Start with the first number

        // Loop through rows
        for (int i = 1; i <= N; i++) {
            // Print numbers in the ith row
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;  // Increment the number for each element
            }
            System.out.println();  // Move to the next line after each row
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input N
        System.out.print("Enter the number of rows (N): ");
        int N = sc.nextInt();

        // Print Floyd's triangle for N rows
        printFloydsTriangle(N);

        sc.close();
    }
}
