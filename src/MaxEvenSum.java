/*
One of the shops in HackerMall is offering discount coupons based on a puzzling problem.
There are n tags where each tag has a value denoted by val[i].
A customer needs to choose the tags in such a way that the sum of values is even.
The goal is to find the maximum possible even sum of values of tags that can be chosen.
Note::
It is guaranteed that there is at least one tag with an even value.
The tags can have positive or negative values.
 */
/*
📘 What the Question Is Saying

You are given:
n tags
Each tag has a number written on it → val[i]
The numbers can be positive or negative
You must choose some of the tags
The sum of chosen tags must be EVEN
Among all possible choices, you must return the maximum even sum
It is guaranteed that at least one tag has an even number.
 */
public class MaxEvenSum {

    public static int maxEvenSum(int[] arr) {
        int totalSum = 0;
        int smallestOdd = Integer.MAX_VALUE;

        for (int num : arr) {
            totalSum += num;
            if (num % 2 != 0) {
                smallestOdd = Math.min(smallestOdd, num);
            }
        }

        if (totalSum % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - smallestOdd;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 8, 2, 3};
        System.out.println(maxEvenSum(arr));
    }
}