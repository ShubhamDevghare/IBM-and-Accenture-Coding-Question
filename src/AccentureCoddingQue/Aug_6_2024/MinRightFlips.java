package AccentureCoddingQue.Aug_6_2024;
/*
Que :
Count minimum right flips to set all values in an array
------------------------------------------------------------
N light bulbs are connected by a wire. Each bulb has a switch associated with it,
however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
Given an initial state of all bulbs, Find the minimum number of switches you have to press to turn on all the bulbs.
You can press the same switch multiple times.

Note: O represents the bulb is off and 1 represents the bulb is on.
 */
public class MinRightFlips {

    public static int countMinFlips(int[] bulbs) {
        int flipCount = 0;  // Keep track of the number of flips

        for (int bulb : bulbs) {
            // Check if the bulb needs to be flipped
            if ((flipCount % 2 == 0 && bulb == 0) || (flipCount % 2 == 1 && bulb == 1)) {
                flipCount++;  // Flip the current bulb and all bulbs to the right
            }
        }
        return flipCount;
    }

    public static void main(String[] args) {
        int[] bulbs = {1,1,0,1,0,1,0,1,0,1,0};

        // Output the minimum number of flips
        System.out.println(countMinFlips(bulbs));

    }
}
