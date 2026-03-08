/*SLF
A Fibonacci Triangle prints Fibonacci numbers in a triangular pattern.
Example for 5 rows:
1
1 2
3 5 8
13 21 34 55
89 144 233 377 610
 */
import java.util.Scanner;

public class FibonacciTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        int a = 0, b = 1, c;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                c = a + b;
                System.out.print(c + " ");
                a = b;
                b = c;
            }
            System.out.println();
        }

        sc.close();
    }
}