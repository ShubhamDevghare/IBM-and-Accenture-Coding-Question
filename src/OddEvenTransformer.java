/*
Odd-Even-Transform Problem works on an array of integers (both positive, negative, and zero),
by taking in a value (a whole number) that specifies the number of times the transformation has to be applied.

On an array of integers, the transformation that n number of times needs to occur:

Adds three (+3) to each odd integer.
Subtracts three (-3) from each EVEN integer.

Example:

[3, 4, 9] means the array with integers 3, 4, 9 has to undergo transformation 3 times.

[3, 4, 9] -> [6, 1, 12] -> [3, 4, 9] -> [6, 1, 12]

So the result is [6, 1, 12].

 */
/*   SLF ::

Logic Trick for Odd-Even-Transform
--------------------------------

Observation 👇

If we apply the transformation once:
     Odd number → +3 → becomes even
     Even number → -3 → becomes odd
If we apply the transformation again, it returns to the original number.

Example:
     3 → 6 → 3
     4 → 1 → 4
     9 → 12 → 9

So the pattern repeats every 2 transformations.

If n is even → array remains same as original
If n is odd → apply transformation once

This reduces time complexity from O(n × k) to O(n)
 */
import java.util.*;

public class OddEvenTransformer {

    public static void transformArray(int[] numbers, int k) {

        if (k % 2 == 0) {
            return ; // no change needed
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                numbers[i] += 3;
            } else {
                numbers[i] -= 3;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 9};
        int k = 3;

        transformArray(numbers, k);

        System.out.println(Arrays.toString(numbers));
    }
}

/*
import java.util.*;

public class OddEvenTransformer {

    public static List<Integer> transformArray(List<Integer> numbers, int k) {

        if (k % 2 == 0) {
            return numbers;
        }

        List<Integer> result = new ArrayList<>();

        for (int num : numbers) {
            if (num % 2 != 0) {
                result.add(num + 3);
            } else {
                result.add(num - 3);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 9);
        int k = 3;

        System.out.println(transformArray(numbers, k));
    }
}
 */