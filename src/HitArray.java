/*
You are given an array A and an integer value K. In one round, you can hit every element strictly greater than K
by reducing its value by K. Your task is to perform one round of hitting and return an integer value representing
the number of elements that remain hit-able (i.e., still greater than K) after one round.

Input Specification:

input1: An integer value N representing the size of array.
input2: An integer value K representing the hitting threshold.
input3: An integer array A.

Output Specification:
Return an integer value representing the number of elements that remain hit-able (i.e., still greater than K) after one round.

Example 1:

input1: 5
input2: 5
input3: {12,9,10,15,5}

Output: 2

 */
/*  SLF ::
You are given:
   N → size of array
   K → hitting threshold
 A[] → integer array

Rule (One Round):
     For every element strictly greater than K, reduce it by K.
     After performing this one round, count how many elements are still greater than K.
 */
/*
Example
Input
N = 5
K = 5
A = [12, 9, 10, 15, 5]

Step 1: Apply one round

Only elements > K are reduced.

| Original | Operation | New Value |
| -------- | --------- | --------- |
| 12       | 12 - 5    | 7         |
| 9        | 9 - 5     | 4         |
| 10       | 10 - 5    | 5         |
| 15       | 15 - 5    | 10        |
| 5        | unchanged | 5         |

New array: [7, 4, 5, 10, 5]

Step 2: Count elements still > K
K = 5
Elements greater than 5:

7, 10

Count = 2

Output: 2

 */
public class HitArray {

    public static int countHitAble(int N, int K, int[] A) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] > K) {
                A[i] = A[i] - K;
            }
            if (A[i] > K) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 5;
        int K = 5;
        int[] A = {12, 9, 10, 15, 5};

        System.out.println(countHitAble(N, K, A));
    }
}