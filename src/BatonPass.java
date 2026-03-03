/*
Question :
There are n friends standing in a line, each numbered from 1 through n inclusive.
The first one, friend 1, holds a baton. Each second, the baton is passed to the next friend in line.
Once it reaches the end of the line, the direction of passing is reversed and passing continues.
Determine who will pass and who will receive the baton at a given time.

Example
------
friends = 4
time = 5

Friends are numbered 1 through 4. Friend 1 holds the baton at time 0. At time 1, it is passed to friend 2.
Over 5 seconds, the baton is passed as:

1 → 2 → 3 → 4 → 3 → 2

The friend passing the baton at time 5 is friend 3.
The friend receiving the baton is friend 2.

Return:  [3, 2]

Function Description
---------------------
Complete the function batonPass in the editor below. The function must return an integer array.

batonPass has the following parameters:
    int friends: the number of friends
    int time: the time to report who on the baton

Returns
-------
int[2]: the friend who has the baton (index 0)
        and the friend who receives the baton (index 1)

Constraints
-----------
2 ≤ friends ≤ 2 × 10^5
1 ≤ time ≤ 10^12
 */

/* SLF:
There are n friends standing in a straight line, numbered from 1 to n.

  Friend 1 starts with a baton (छड़ी) at time 0.
  Every second, the baton is passed to the next friend in the line.
  When the baton reaches the last friend (n), the direction changes.
  Then it starts moving backwards one by one.
  When it reaches friend 1, the direction changes again.
  This back-and-forth passing continues.

👉 You are given:
   - friends → total number of friends
   - time → the second at which you want to check

Your task is to find:
  - Who is passing the baton at that time
  - Who is receiving the baton at that time

Return both numbers in an array:
[person_passing, person_receiving]

✅ Example
Suppose:
       friends = 4
       time = 5
 Friends are standing like this:
 1   2   3   4

 Friend 1 starts with the baton at time = 0.

⏳ Baton Movement Each Second

Time 0: 1
Time 1: 1 → 2
Time 2: 2 → 3
Time 3: 3 → 4
Time 4: 4 → 3  (direction changes)
Time 5: 3 → 2

So at time = 5:
  Friend 3 is passing the baton
  Friend 2 is receiving the baton

✅ Output
[3, 2]
 */
import java.util.*;

public class BatonPass {

    public static int[] batonPass(int friends, long time) {
        int n = friends;

        // One complete forward and backward cycle
        long cycle = 2L * (n - 1);

        // Determine position in cycle
        long k = (time - 1) % cycle;

        int holder;
        int receiver;

        if (k < n - 1) {
            // Forward direction
            holder = (int) (1 + k);
            receiver = holder + 1;
        } else {
            // Backward direction
            holder = (int) (n - (k - (n - 1)));
            receiver = holder - 1;
        }

        return new int[]{holder, receiver};
    }

    public static void main(String[] args) {
        int friends = 4;
        long time = 5;

        int[] result = batonPass(friends, time);
        System.out.println(result[0] + " " + result[1]); // Output: 3 2
    }
}