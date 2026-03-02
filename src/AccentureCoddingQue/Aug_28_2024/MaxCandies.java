package AccentureCoddingQue.Aug_28_2024;
/*
Que: Maximize the Number of Candies
You are given N candies, each with a price. Some candies are free if their price is divisible by 5.
 You also have a limited amount of money M. Your goal is to buy as many candies as possible,
 keeping in mind that:

Candies with prices divisible by 5 are free.
You can buy any other candy as long as its price is less than or equal to the remaining money.
You should try to maximize the number of candies you can acquire.
Input:
An integer N, the number of candies.
A list of N integers representing the prices of the candies.
An integer M, representing the total money you have.
Output:
An integer representing the maximum number of candies you can acquire, including both free and purchased
candies.

 */
import java.util.Arrays;
import java.util.Scanner;

public class MaxCandies {

    public static int maxCandies(int N, int[] prices, int M) {
        int freeCandies = 0;
        Arrays.sort(prices);
        // Iterate through the prices after sorting
        for (int price : prices) {
            if (price % 5 == 0) {
                // Count candies that are free
                freeCandies++;
            } else {
                // Try to buy candies that are not free
                if (price <= M) {
                    M -= price;
                    freeCandies++;
                } else {
                    // If we can't buy this candy, break out
                    break;
                }
            }
        }

        return freeCandies;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();

        // Sort the prices to buy cheaper ones first


        System.out.println(maxCandies(N, arr, M));

        scanner.close();
    }
}
