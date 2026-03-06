/*
Property / Formula:
====================

For any numbers:
               (a+b) % d = ( (a%d) + (b%d) ) % d

This means you can take modulo before or after addition — the result stays the same.

Extending it to three numbers:
              (a+b+c) % d = ( (a%d) + (b%d) + (c%d) ) %d
 */
/*
There is Difference in 2 Sum problem and Below problem
3 sum problem :: https://youtu.be/D2LnAYxUFa0?si=JjsUDBjSfUTjNeKj
 */
/*
Question:
==========
The cost of a stock on each day is given in an array, arr.
An investor wants to buy the stocks in triplets such that the sum of the cost for three days is divisible by d.
The goal is to find the number of distinct triplets (i, j, k) such that i < j < k and the sum (arr[i] + arr[j] + arr[k])
is divisible by d.

Example:

Let arr, prices of stock = [3, 3, 4, 7, 8] and d = 5. Following are the triplets whose sum is divisible by d
(1-based indexing):

Triplet with indices (1, 2, 3), sum = 3 + 3 + 4 which is equal to 10
Triplet with indices (1, 3, 5), sum = 3 + 4 + 8 which is equal to 15
Triplet with indices (2, 3, 4), sum = 3 + 4 + 8 which is equal to 15

Hence the answer is 3.
 */
/*
Instead of checking all triplets, we use modulo properties:
If
    (a + b + c) % d = 0
then
    ((a % d) + (b % d) + (c % d)) % d = 0
So we store frequency of remainders.
 */


public class TripletSumDivisible {

    public static int countTriplets(int[] arr, int d) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int[] freq = new int[d];  // freq stores how many numbers we already saw with a certain remainder. i.e in this freq. index no is rem and storing

            for (int j = i + 1; j < n; j++) {
                int mod = arr[j] % d;
                int required = (d - ((arr[i] + arr[j]) % d)) % d;
                count += freq[required];
                freq[mod]++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,4,7,8};
        int d = 5;

        System.out.println(countTriplets(arr, d));
    }
}
/*
Example Walkthrough
===================
arr = [3,3,4,7,8]
d = 5

Assume:
i = 0 → arr[i] = 3

Now we start checking j.

Step 1
j = 1 → arr[j] = 3

Find remainder: mod = 3 % 5 = 3

Calculate required remainder for third number:
3 + 3 = 6
6 % 5 = 1  // ((arr[i] + arr[j]) % d)

required = 5 - 1 = 4  // d - ((arr[i] + arr[j]) % d))

So we need: k % 5 = 4

count += freq[required];

freq[4] = 0

Meaning we haven't seen any number with remainder 4 yet.

So:

count += 0

Triplets found:

0
Line 2
freq[mod]++;
mod = 3

So we store that we saw a number with remainder 3.

Now:

freq = [0,0,0,1,0]

Meaning one number with remainder 3 exists.

Step 2

Now

j = 2 → arr[j] = 4
mod = 4

Find required:

3 + 4 = 7
7 % 5 = 2
required = 5 - 2 = 3

So we need:

k % 5 = 3
Line 1 again
count += freq[required];
freq[3] = 1

That means we already saw one number with remainder 3.

So we found one valid triplet.

count = 1

Triplet is:

3,3,4
Line 2 again
freq[mod]++;
mod = 4

Update freq:

freq = [0,0,0,1,1]

Now we know one number with remainder 4 exists.

Very Simple Meaning of the Two Lines
Line 1
count += freq[required];

👉 "How many numbers already exist that can complete the triplet?"

Line 2
freq[mod]++;
 */