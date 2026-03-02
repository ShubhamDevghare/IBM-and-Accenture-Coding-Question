package AccentureCoddingQue.Aug_12_2024;
/*

//  If num is even, the least significant bit is 0
//  If num is odd, the least significant bit is 1
Que:
find the count of magical numbers from 1 to N
A magical number is defined by the following criteria:
- Convert each number in the range 1 to N (inclusive) to its binary representation.
- Replace '0' with '1' and '1' with '2' in the binary string.
- Calculate the sum of the digits in the modified binary string. If the resultant number is odd,
  then it is considered a magical number

Your task is to find and return an integer value representing the count of the magical numbers
present within the given range.


note :
in java we can directly apply bitwise operator on number without converting it into its binary representation
The bitwise operations work directly on the binary representation of the integers as they are stored in memory.
 */
import java.util.Scanner;

public class MagicalNumbersCount {

    // Function to count the number of magical numbers from 1 to N
    public static int solve(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int zeroCount = 0;
            int num = i;

            while (num > 0) {
                // Check if the  least significant bit [right most bit] is zero
                if ((num & 1) == 0) {
                    zeroCount++;
                }
                num >>= 1; // shifts the bits of the num one position to the right
            }

            // If the number of zeros is odd, increment the count of magical numbers
            if (zeroCount % 2 == 1) {
                count++;
            }
        }

        return count;
    }

    // Driver program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();
            System.out.println("Number of magical numbers: " + solve(n));
            sc.close();
    }
}
