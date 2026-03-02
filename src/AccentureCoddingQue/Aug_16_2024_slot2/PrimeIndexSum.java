package AccentureCoddingQue.Aug_16_2024_slot2;
/*
Que:
Given an array with 'N' elements, you are expected to find the sum of the values that are
present in prime indexes of the array. Note that the array index starts with 0 i.e. the position

 */
public class PrimeIndexSum {
    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to find the sum of elements at prime indexes
    public static int sumAtPrimeIndexes(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(i)) {
                sum += arr[i]; // Add element at prime index
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int result = sumAtPrimeIndexes(arr);
        System.out.println("Sum of values at prime indexes: " + result);
    }
}