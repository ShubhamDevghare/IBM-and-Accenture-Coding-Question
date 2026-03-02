package AccentureCoddingQue.July_26_2024;
/*
Que: Alex Gives You a positive Number N and wants you to rearrange the bits of the number in its binary
representation such that all "set bits" are in consecutive order. Your task is to find and return an integer
value representing the minimum possible number that can be formed after re-arranging the bits of the number
N.

Ans :
logic used :
1. count no of set bits
2. find lest no by putting set bits in right most side [least significant positions]

--------------------------------------------------------------------------------------------

logic used :
1. count no of set bits
--------------------------
Approach 1.[ by Shauryaa]
============================
            count = 0;
            while (n != 0) {
                count += n & 1;
                n >>= 1;
            }

Exp:
----
count : to store the number of set bits (1s) present in n.

count += n & 1; ==>
 This checks the least significant bit (LSB) of n using a bitwise AND (n & 1).
 If the LSB is 1, count is incremented by 1.
 If it is 0, count remains unchanged.

1 AND 1 = 1 , else 0  ==> count is incremented iff 1 AND 1 = 1

n >>= 1;         // right Shift
--------------------------------------------------------------------------------------------------------------------
2^count −1 ===> which gives a number with the same number of 1s, but placed in the rightmost (least significant) positions.
These are the b least significant bit (LSB) : it  represent the smallest values in the binary system.
-------------------------------------------------------------------------------------------------------------------
Input: 13 (Binary: 1101)
Count of set bits: 3
Now, rearrange 3 set bits to the least significant positions:

The binary number with 3 set bits in the least significant positions is 111 (decimal 7).
Calculation:
2^3 − 1 = 8 − 1 = 7

Approach 2. [optimised]
==========================
// Brian Kernighan’s Algorithm
            count = 0;
            while (n != 0) {
                n &= (n - 1); // Clear the lowest set bit
                count++;      // Increment count for each set bit cleared
            }

2. find lest no by putting set bits in right most side [least significant positions]
------------------------------------------------------------------------------------
1+2+4+6+8+10.....
where a = 1 ; r = 2 ; n= no f times [count]

Sn = a(r^n  -  1) / (r-1)
   = 1(2^n - 1 )  / (2-1)
   = (2^n -1) where n is no of set bits [count]

 */

import java.util.Scanner;

    public class RearrangeBits {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();  // Input number

            // COUNTING SET BITS
            int count = 0;
         // Brian Kernighan’s Algorithm
          /*  while (n != 0) {
                n &= (n - 1); // Clear the lowest set bit
                count++;      // Increment count for each set bit cleared
            }
*/
            while (n != 0) {
                count += n & 1;
                n >>= 1;
            }
            int ans = (int)Math.pow(2, count) - 1;

            System.out.println(ans);
        }
    }


/*
Exp :
==
counting no of set bits
=======================

the Brian Kernighan’s Algorithm using the example n = 15 (1111 in binary).

Initial state:
n = 15 → binary: 1111
Set bits: 4 (since 1111 has four 1s)
Steps:
=====
First iteration:

n = 15 → binary: 1111
n - 1 = 14 → binary: 1110
n &= (n - 1) → 1111 & 1110 = 1110 (clears the rightmost 1)
Now, n = 14 → binary: 1110
count = 1
-------------------------------------------------
Second iteration:

n = 14 → binary: 1110
n - 1 = 13 → binary: 1101
n &= (n - 1) → 1110 & 1101 = 1100 (clears the next rightmost 1)
Now, n = 12 → binary: 1100
count = 2
-------------------------------------------------------
Third iteration:

n = 12 → binary: 1100
n - 1 = 11 → binary: 1011
n &= (n - 1) → 1100 & 1011 = 1000 (clears the next rightmost 1)
Now, n = 8 → binary: 1000
count = 3
--------------------------------------------------------
Fourth iteration:

n = 8 → binary: 1000
n - 1 = 7 → binary: 0111
n &= (n - 1) → 1000 & 0111 = 0000 (clears the last set bit)
Now, n = 0 → binary: 0000
count = 4
-------------------------------------------------------------
Final Result:
n is now 0, and the count of set bits is 4.


 */