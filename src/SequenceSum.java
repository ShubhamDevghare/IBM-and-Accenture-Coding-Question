/*
Given three integers, i, j, and k, a sequence sum is defined as:
  i+(i+1)+(i+2)+(i+3)+...+j+(j−1)+(j−2)+(j−3)+...+k

 That is:
        - Increment from i until it equals j
        - Then decrement from j until it equals k
Given values i, j, and k, calculate the sequence sum as described

Example

i = 5
j = 9
k = 6

Sum all the values from i to j and back to k:
5 + 6 + 7 + 8 + 9 + 8 + 7 + 6 = 56

Function Description
--------------------
Complete the function getSequenceSum in the editor below.

getSequenceSum has the following parameter(s):
      int i: an integer
      int j: an integer
      int k: an integer
Return
      long: the value of the sequence sum

Input Format for Custom Testing
-------------------------------
The first line contains an integer, i.
The next line contains an integer, j.
The last line contains an integer, k.

▼ Sample Case 0

STDIN      Function
-----      --------
  0    →    i = 0
  5    →    j = 5
 -1    →    k = -1

Sample Output 0
24

Explanation 0

i = 0
j = 5
k = -1

0 + 1 + 2 + 3 + 4 + 5 + 4 + 3 + 2 + 1 + 0 + -1 = 24

 */

/* SLF:
The question gives you three numbers: i, j, and k.

You have to:
1️⃣ Start from i
2️⃣ Keep adding numbers by increasing 1 each time until you reach j
3️⃣ After reaching j, start decreasing by 1
4️⃣ Keep going down until you reach k
5️⃣ Add all those numbers together
6️⃣ Return the total sum

Example:
If:
     i = 5
     j = 9
     k = 6
First go up from 5 to 9:
5 + 6 + 7 + 8 + 9

First go up from 5 to 9:
5 + 6 + 7 + 8 + 9

Then go down from 8 to 6:
8 + 7 + 6

Full sequence:
5 + 6 + 7 + 8 + 9 + 8 + 7 + 6

Add everything → 56

In one line:

👉 Go up from i to j, then go down from j to k, and return the total sum.
 */

import java.io.*;
import java.util.*;

class SequenceSum {
    public static long getSequenceSum(int i, int j, int k) {

        long sum = 0;

        // Increment from i to j
        for (int x = i; x <= j; x++) {
            sum += x;
        }

        // Decrement from j-1 to k
        for (int x = j - 1; x >= k; x--) {
            sum += x;
        }
        return sum;
    }
}