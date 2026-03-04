/*
In the assembly line, the factory assembles three parts 'a', 'b', 'c' of a triangle toy.
A valid toy is one where the two shorter sides added together are greater in length than the longest side.

There are two forms of valid triangles to identify.

If 2 parts are of equal length, the form is "Isosceles".
If all 3 parts are of equal length, the form is "Equilateral".
If a toy is not valid or is not one of those 2 forms, it is "None of these".

Example ::
triangleToy = ['2 2 1', '3 3 3', '3 4 5', '1 1 3']

The first triangle is valid and has 2 equal parts, so the form is "Isosceles".
The second is valid and has 3 equal parts, so the form is "Equilateral".
The third is valid but not one of the two specific forms.
The fourth is not valid. The two sides of 1 unit length cannot meet if the third side is 3 units.

["Isosceles", "Equilateral", "None of these", "None of these"]
 */

/*
In below soln::
Shortcut Used in the Code
----------------------------
Instead of checking 3 conditions, we can simplify it.

Step 1 — Find largest side :
int max = Math.max(a, Math.max(b, c));
ex:  a=3 b=4 c=5
     then max = 5

Step 2 — Sum of other two sides :
     sum = a + b + c - max
 ex: sum = 3+4+5 - 5   then sum = 7

Now check:  sum > max
            7 > 5 ✅
 Which means:
 smallerSide1 + smallerSide2 > largestSide

 That automatically guarantees all 3 triangle conditions.
 */
import java.util.*;

public class TriangleToyAnalyzer {

    public static List<String> classifyTriangles(List<String> triangleToy) {

        List<String> result = new ArrayList<>();

        for (String triangle : triangleToy) {

            String[] parts = triangle.split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);

            int max = Math.max(a, Math.max(b, c));
            int sum = a + b + c - max;

            // Check triangle validity
            if (sum <= max) {
                result.add("None of these");
            }
            // Check Equilateral
            else if (a == b && b == c) {
                result.add("Equilateral");
            }
            // Check Isosceles
            else if (a == b || b == c || a == c) {
                result.add("Isosceles");
            }
            else {
                result.add("None of these");
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> triangleToy = Arrays.asList(
                "2 2 1",
                "3 3 3",
                "3 4 5",
                "1 1 3"
        );

        System.out.println(classifyTriangles(triangleToy));
    }
}
/*
import java.util.*;
public class TriangleToyAnalyzer {

        public static List<String> triangleToy(List<String> triangles) {
            List<String> results = new ArrayList<>();

            for (String triangle : triangles) {
                String[] parts = triangle.trim().split("\\s+");

                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);

                results.add(classifyTriangle(a, b, c));
            }
            return results;
        }

        private static String classifyTriangle(int a, int b, int c) {
            // Check for invalid sides
            if (a <= 0 || b <= 0 || c <= 0) {
                return "None of these";
            }
            // Triangle validity rule
            if (a + b <= c || b + c <= a || a + c <= b) {
                return "None of these";
            }
            // Classification
            if (a == b && b == c) {
                return "Equilateral";
            }
            if (a == b || b == c || a == c) {
                return "Isosceles";
            }
            return "None of these";
        }
        public static void main(String[] args) {

            List<String> input = Arrays.asList(
                    "2 2 1",
                    "3 3 3",
                    "3 4 5",
                    "1 1 3"
            );
            List<String> output = triangleToy(input);
            for (String result : output) {
                System.out.println(result);
            }
        }
    }

 */