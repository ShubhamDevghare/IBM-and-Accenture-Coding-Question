package AccentureCoddingQue.Aug_12_2024;
/*
Find the sum of prime number till N.
Ex: InPUT: 8                           then prime numbers are [2,3,5,7]
    OutPUT : sum of prime no = 17

 */
public class PrimeSum {
    public static void main(String[] args) {
        int N = 100; // Change this to your desired value of N
        int sum = sumOfPrimes(N);
        System.out.println("The sum of prime numbers up to " + N + " is: " + sum);
    }

    public static int sumOfPrimes(int N) {
        int sum = 0;
        for (int num = 2; num <= N; num++) {
            if (isPrime(num)) {
                sum += num;
            }
        }
        return sum;
    }

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
}
