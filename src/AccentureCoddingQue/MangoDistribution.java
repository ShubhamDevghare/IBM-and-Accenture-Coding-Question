package AccentureCoddingQue;

//nCr = n! / [r!(n-r)!]
//3mango 2 person:
//  Total Ways= (n+m−1)C(n-1) => (2+3-1)C(2-1) =>4C1 =>4
//2mango 2 person:
//  Total Ways= (n+m−1)C(n-1) => (2+2-1)C(2-1) =>3C1 =>3

// if n is the number of mangoes ; k is the number of persons
// C(n+k−1,k−1)C(n+k−1,k−1),


// binomial_coefficient(n + m - 1, n - 1).
//If there are fewer mangoes than people (m < n), it returns 0 because it's not possible to give at least one mango to each person under those conditions.

import java.util.Scanner;

public class MangoDistribution {

    // Function to calculate the binomial coefficient
    public static int binomialCoefficient(int n, int r) {
        int result = 1;

        if (r > n - r) {
            r = n - r;
        }

        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    // Function to calculate the number of ways to distribute mangoes
    public static int distributeMangoes(int mangoes, int persons) {
        // If there are fewer mangoes than persons, no way to distribute
        if (mangoes < persons) {
            return 0;
        }

        // Calculate ways using the formula (n + m - 1) C (n - 1)
        return binomialCoefficient(persons + mangoes - 1, persons - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of mangoes and persons
        System.out.print("Enter number of mangoes: ");
        int mangoes = scanner.nextInt();
        System.out.print("Enter number of persons: ");
        int persons = scanner.nextInt();

        // Calculate the result
        int ways = distributeMangoes(mangoes, persons);

        // Output the result
        System.out.println("Number of ways to distribute mangoes: " + ways);

        scanner.close();
    }
}
