package AccentureCoddingQue.Aug_21_2024;

import java.util.Scanner;
/*
Que:
convert a number N into its binary form [String]

 */
import java.util.Scanner;

public class NumberToBinaryManual {
    public static String toBinary(int N) {
        if (N == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        // Divide the number by 2 repeatedly and store the remainders
        while (N > 0) {
            int remainder = N % 2;  // Get the remainder when N is divided by 2
            binary.append(remainder);  // Append remainder (0 or 1) to the binary string
            N = N / 2;  // Update N by dividing it by 2
        }

        // The binary string will be in reverse order, so reverse it
        return binary.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int N = scanner.nextInt();

        String binaryString = toBinary(N);

        System.out.println("Binary form of " + N + " is: " + binaryString);
        scanner.close();
    }
}

/*
public class NumberToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int N = scanner.nextInt();

        // Convert the number to binary string
        String binaryString = Integer.toBinaryString(N);

        System.out.println("Binary form of " + N + " is: " + binaryString);

        scanner.close();
    }
}
*/