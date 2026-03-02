package AccentureCoddingQue.Sep14_2024;
/*
You are given an integer array nums. You want to maximize the number of points you get by performing
the following operation any number of times:
• Pick any nums [i] and delete it to earn nums [i] points.
Afterwards, you must delete every element equal to nums [i] -1 and every element equal to nums [i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times

*/

import java.util.HashMap;
import java.util.Map;

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int N = nums.length;
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // Use a HashMap to store the sum of values for each number
        Map<Integer, Integer> val = new HashMap<>();
        for (int num : nums) {
                val.put(num, val.getOrDefault(num, 0) + num); // val.getOrDefault(num, 0) -- return OR to get " value " associated with key if key is not present in HashMap defalt "value" 0 is return
        }

        // Initialize pick and not pick
        int pick = val.getOrDefault(1, 0);
        int notPick = 0;

        // Iterate from 2 to the "maximum number" found in the array
        for (int i = 2; i <= maxNum; i++) {
            int newPick = notPick + val.getOrDefault(i, 0);
            int newNotPick = Math.max(pick, notPick);
            notPick = newNotPick;
            pick = newPick;
        }

        return Math.max(pick, notPick);
    }

    // Main method to test the deleteAndEarn function
    public static void main(String[] args) {
        DeleteAndEarn solution = new DeleteAndEarn();

        // Test case 1
        int[] nums1 = {3, 4, 2};
        System.out.println("Result: " + solution.deleteAndEarn(nums1));  // Output: 6

        // Test case 2
        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println("Result: " + solution.deleteAndEarn(nums2));  // Output: 9
    }
}
