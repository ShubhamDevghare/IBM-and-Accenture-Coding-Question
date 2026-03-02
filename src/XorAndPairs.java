/*
For an array arr of n positive integers,
 count the unordered pairs (i, j) (0 ≤ i < j < n) where arr[i] XOR arr[j] > arr[i] AND arr[j].
 XOR denotes the bitwise XOR operation and AND denotes the bitwise AND operation.

Example :

Given n = 4, arr = [4, 3, 5, 2]. All unordered pairs (i, j) are:
___________________________________
| Indices | XOR | AND | XOR > AND |
| ------- | --- | --- | --------- |
| (0,1)   | 7   | 0   | True      |
| (0,2)   | 1   | 4   | False     |
| (0,3)   | 6   | 0   | True      |
| (1,2)   | 6   | 1   | True      |
| (1,3)   | 1   | 2   | False     |
| (2,3)   | 7   | 0   | True      |

Output:
4
 */
import java.util.*;
public class XorAndPairs {
    public static long countPairs(int[] arr) {
            // Group numbers by their highest set bit
            Map<Integer, Long> bitCount = new HashMap<>();

            for (int num : arr) {
                int highBit = Integer.highestOneBit(num);
                bitCount.merge(highBit, 1L, Long::sum);
            }

            long total = (long) arr.length * (arr.length - 1) / 2; // all pairs
            long invalidPairs = 0;

            // Pairs with SAME highest bit → XOR > AND is FALSE
            for (long count : bitCount.values()) {
                invalidPairs += count * (count - 1) / 2;
            }

            return total - invalidPairs;
        }

        public static void main(String[] args) {
            int[] arr = {4, 3, 5, 2};
            System.out.println(countPairs(arr)); // Output: 4
        }
    }