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

public class BatonPass {
    public static int[] batonPass(int friends, long time) {
        // Use long for cycle calculations to prevent overflow
        long n = (long) friends;
        long cycleLength = 2 * (n - 1);

        // Find the position within the current cycle
        long step = time % cycleLength;

        int passer, receiver;

        // If step is less than the distance to reach the end (n-1)
        if (step < n - 1) {
            // Moving Forward: 1 -> 2 -> 3...
            passer = (int) (step + 1);
            receiver = (int) (step + 2);
        } else {
            // Moving Backward: n -> n-1 -> n-2...
            long stepsBackFromEnd = step - (n - 1);
            passer = (int) (n - stepsBackFromEnd);
            receiver = (int) (n - stepsBackFromEnd - 1);
        }

        return new int[]{passer, receiver};
    }

    public static void main(String[] args) {
        // Test Example
        int[] result = batonPass(4, 5L);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // Output: [3, 2]
    }
}
/*
A full cycle is the number of passes it takes to get from the start, to the end,
and back to the position just before the start.
*  Total Cycle Length = Forward movement + Backward movement = (n − 1) + (n − 1) = 2(n − 1)

The step variable tells us exactly how many passes have occurred in the unfinished round trip.
*  step = time % cycleLength

Case 1: Forward Phase
If:
      step < n - 1
We are still moving forward.
Examples:
step = 0 → Friend 1
step = 1 → Friend 2
step = 2 → Friend 3
Formula:
        passer = step + 1

Case 2: Backward Phase
If:
   step ≥ n - 1

The baton reached the end and is now coming back.
*  stepsBackFromEnd = step - (n - 1)                //ie  totalStep - forward Steps

Then move back from n.
Formula:
      passer = n - stepsBackFromEnd


Example
======
friends = 4
time = 5

1. Cycle Length = 2 × (4 − 1) = 6
2. Step in current cycle = step = time % cycleLength = 5 % 6 = 5
3. Determine phase:
                step ≥ (n - 1)
                   5 ≥ (4 − 1)
                   5 ≥ 3
So it is the backward phase.
4. stepsBackFromEnd = step - (n - 1)
                    = 5 − 3 = 2
5. passer = n - stepsBackFromEnd
          = 4 − 2 = 3


moving back" starts from the moment the baton hits friend n
___________________________________________________________________________
| Time | Action            | Position (Friend) | Phase                    |
| ---: | ----------------- | ------------------| ------------------------ |
|    0 | Friend 1 holds it |          1        | Start                    |
|    1 | Pass 1: 1 → 2     |          2        | Forward                  |
|    2 | Pass 2: 2 → 3     |          3        | Forward                  |
|    3 | Pass 3: 3 → 4     |          4        | Hit the end!             |
|    4 | Pass 4: 4 → 3     |          3        | Backward (1st step back) |
|    5 | Pass 5: 3 → 2     |          2        | Backward (2nd step back) |


 */