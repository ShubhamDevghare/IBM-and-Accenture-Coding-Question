/*
Given a number n, for each integer i in the range from 1 to n inclusive, print one value per line as follows:
If i is a multiple of both 3 and 5, print FizzBuzz.
If i is a multiple of 3 (but not 5), print Fizz.
If i is a multiple of 5 (but not 3), print Buzz.
If i is not a multiple of 3 or 5, print the value of i.

Function Description

Complete the function fizzBuzz in the editor below.

fizzBuzz has the following parameter(s):
int n: upper limit of values to test (inclusive)
Returns:  NONE
Prints:
     The function must print the appropriate response for each value i in the set {1, 2, ... n} in ascending order,
     each on a separate line.
Constraints
0 < n < 2 × 10⁵
 */

/*
Tip for Interviews ::
Always check 3 && 5 first because numbers like 15, 30, 45 satisfy both conditions.
 */
public class FizzBuzz {

    public static void fizzBuzzFunction(int n) {

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }

        }
    }
    public static void main(String[] args) {
        fizzBuzzFunction(15);
    }
}