/*
A man given a task to get the height of vertical trees in a garden.
We have to see how we can help him programmatically if we have few of the parameters.

The man is able to measure the angle of elevation of the top of the tree from his measuring instrument.
The measuring instrument is 1.8m above ground level. When the man is standing 19m from the base of the tree,
the angle he measures is 56°.

With the help of given parameters we can find the height of the tree is 29.97m (taking the nearest ceil value it will be 30m).

photo/HeightOfTree.png

Function Description
-------------------
Complete the function getHeightOfTree in the editor below. The function must state what must be returned or printed.
functionName has the following parameter(s):
  angle: this is an integer
  dist: this is a float
Consider showing the result in ceil value.
Height or Distance are given in meters.
*/

public class HeightOfTree {

    public static int getHeightOfTree(int angle, float dist) {
        // Height from instrument to top of tree
        // tan(angle) = opposite / adjacent
        // opposite = dist * tan(angle)

        double angleInRadians = Math.toRadians(angle);
        double heightAboveInstrument = dist * Math.tan(angleInRadians);

        // Total tree height = height of instrument + height above instrument
        double totalHeight = 1.8 + heightAboveInstrument;

        // Return ceiling value
        return (int) Math.ceil(totalHeight);
    }

    public static void main(String[] args) {
        // Test with given example: angle=56, dist=19m
        int result = getHeightOfTree(56, 19.0f);
        System.out.println("Height of tree: " + result + "m"); // Expected: 30m
    }
}

/*
Logic Breakdown:
----------------
_____________________________________________________
Step                         Calculation
-----------------------------------------------------
Convert angle                56° → radians
Height above instrument      19 × tan(56°) = 28.17m
Add instrument height        28.17 + 1.8 = 29.97m
Ceiling value                [29.97] = 30m ✅
_____________________________________________________

Key points:
-----------
Math.toRadians() converts degrees to radians for Math.tan()
The instrument is 1.8m above ground, so we add that to the calculated height
Math.ceil() gives the nearest ceiling value as required

 */