/*
Given an array arr of n integers, a sequence of n - 1 operations must be performed on the array.
In each operation:
Remove the minimum and maximum elements from the current array and add their sum back to the array.
The cost of an operation is

⌈(minimum_element+maximum_element)/(maximum_element−minimum_element+1)⌉

Find the total cost to reduce the array to a single element.
Example :

Given
arr = [2, 3, 4, 5, 7]

The possible sequence of operations are:

Choose 2 and 7,
cost = ⌈(2 + 7) / (7 − 2 + 1)⌉
= ⌈9 / 6⌉ = 2
Remove 2 and 7, append 9 → arr = [3, 4, 5, 9], total_cost = 2

Choose 3 and 9,
cost = ⌈(3 + 9) / (9 − 3 + 1)⌉
= ⌈12 / 7⌉ = 2
arr = [4, 5, 12], total_cost = 4

Choose 4 and 12,
cost = ⌈(4 + 12) / (12 − 4 + 1)⌉
= ⌈16 / 9⌉ = 2
arr = [5, 16], total_cost = 6

Choose 5 and 16,
cost = ⌈(5 + 16) / (16 − 5 + 1)⌉
= ⌈21 / 12⌉ = 2
arr = [21], total_cost = 8

Return 8.

 */
/*
🔹 How TreeMap Works
---------------------
TreeMap in Java:

- Stores keys in sorted (ascending) order
- Internally implemented using a Red-Black Tree
- All operations like firstKey() and lastKey() are O(log n)

firstKey() returns:
-------------------
➡️ The smallest key in the sorted map
➡️ That is your minimum element

lastKey() returns:
------------------
➡️ The largest key in the sorted map
➡️ That is your maximum element
 */

import java.util.*;

public class ArrayReduction3 {

    public static long getTotalCost(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long totalCost = 0;

        while (map.size() > 1 || map.firstEntry().getValue() > 1) {

            int min = map.firstKey();
            int max = map.lastKey();

            remove(map, min);
            remove(map, max);

            long numerator = (long) min + max;
            long denominator = (long) max - min + 1;
            long cost = (numerator + denominator - 1) / denominator;

            totalCost += cost;

            int sum = min + max;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return totalCost;
    }

    private static void remove(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }
}