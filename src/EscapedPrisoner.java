/*
src :: /photos/EscapedPrisoner

Prisoners are standing on a Cartesian coordinate system present inside a jail.
Each prisoner stands at a unique point with both the coordinates (x, y) being integers. Each prisoner should be at a position that forms a rectangle or square with 3 other prisoners.

More formally, every prisoner at a coordinate pair (x, y) should have:
at least one prisoner standing at integer coordinates (x, ay) where ay ≠ y
at least one prisoner standing at integer coordinates (bx, y) where bx ≠ x

Unfortunately, one prisoner has escaped. Find the coordinates of that prisoner.
Example
-----
locations = [[1,1], [1,2], [2,1], [4,4], [4,6], [9,4], [9,6]]
 */

/*
This problem is a coordinate grouping problem.
Key Idea
---------
Each prisoner at (x, y) must have:
  - another prisoner with the same x but different y
  - another prisoner with the same y but different x
So every valid point must belong to:
  - a vertical pair (same x)
  - a horizontal pair (same y)
If a point does not satisfy both conditions, that point is the escaped prisoner.

Given Example
------------
Locations:
 [[1,1], [1,2], [2,1], [4,4], [4,6], [9,4], [9,6]]

Let's check counts.

Count X coordinates
1 → 2
2 → 1
4 → 2
9 → 2

Count Y coordinates
1 → 2
2 → 1
4 → 2
6 → 2

Check each point
_______________________________________
| Point | X count | Y count | Valid?  |
| ----- | ------- | ------- | --------|
| (1,1) | 2       | 2       | ✅      |
| (1,2) | 2       | 1       | ❌      |
| (2,1) | 1       | 2       | ❌      |
| (4,4) | 2       | 2       | ✅      |
| (4,6) | 2       | 2       | ✅      |
| (9,4) | 2       | 2       | ✅      |
| (9,6) | 2       | 2       | ✅      |
---------------------------------------

The escaped prisoner must be the one breaking the rectangle rule.

Between the two invalid points, the one that breaks both pairing conditions for rectangle formation is:
✅ (1, 2)

Final Answer
Missing / Escaped prisoner coordinates:
[1, 2]
 */

import java.util.*;

public class EscapedPrisoner {

    public static int[] findEscapedPrisoner(int[][] locations) {

        Map<Integer, Integer> xCount = new HashMap<>();
        Map<Integer, Integer> yCount = new HashMap<>();

        // Count frequencies
        for (int[] loc : locations) {
            xCount.put(loc[0], xCount.getOrDefault(loc[0], 0) + 1);
            yCount.put(loc[1], yCount.getOrDefault(loc[1], 0) + 1);
        }

        // Find the prisoner that breaks rule
        for (int[] loc : locations) {
            if (xCount.get(loc[0]) == 1 || yCount.get(loc[1]) == 1) {
                return loc;
            }
        }

        return new int[]{-1, -1}; // fallback
    }

    public static void main(String[] args) {

        int[][] locations = {
                {1,1}, {1,2}, {2,1},
                {4,4}, {4,6}, {9,4}, {9,6}
        };

        int[] result = findEscapedPrisoner(locations);

        System.out.println("Escaped Prisoner: [" + result[0] + ", " + result[1] + "]");
    }
}