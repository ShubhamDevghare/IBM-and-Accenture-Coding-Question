/*
For each element of an array, a counter is set to 0. The element is compared to each element to its left.
If the element to the left is greater, the absolute difference is subtracted from the counter.
If the element to the left is less, the absolute difference is added to the counter.
For each element of the array, determine the value of the counter.
These values should be stored in an array and returned.
 */

/*
Problem Explanation
===================
For each element arr[i] in an array:
1. Set counter = 0.
2. Compare arr[i] with every element to its left (arr[j] where j < i).
3. For each comparison:

    If arr[j] > arr[i]
    → counter -= |arr[i] - arr[j]|

    If arr[j] < arr[i]
    → counter += |arr[i] - arr[j]|

4. Store the final counter value for that element.
5. Return the resulting array.

Note:
|x| means absolute difference.
 */
/*
Example
--------
Input: arr = [3, 1, 5]

i = 0 → element = 3
No elements to the left
counter = 0
Result → 0

i = 1 → element = 1
Compare with 3
3 > 1
difference = |1 - 3| = 2
counter = 0 - 2 = -2
Result → -2

i = 2 → element = 5
Compare with 3
3 < 5
difference = 2
counter = 0 + 2 = 2

Compare with 1
1 < 5
difference = 4
counter = 2 + 4 = 6

Result → 6
 */
public class CounterArray {

    public static int[] calculateCounter(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int counter = 0;

            for (int j = 0; j < i; j++) {
                int diff = Math.abs(arr[i] - arr[j]);

                if (arr[j] > arr[i]) {
                    counter -= diff;
                } else if (arr[j] < arr[i]) {
                    counter += diff;
                }
            }

            result[i] = counter;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5};

        int[] res = calculateCounter(arr);

        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}