package MostFrequent.Arrays;

import java.util.*;

/**
 * ================================================================
 *   TOP 50 MOST IMPORTANT & REPEATING DSA ARRAY QUESTIONS
 * ================================================================
 *
 * Q01  - Find Max and Min in Array
 * Q02  - Reverse an Array
 * Q03  - Find Second Largest Element
 * Q04  - Remove Duplicates from Sorted Array
 * Q05  - Move Zeros to End
 * Q06  - Left Rotate Array by K positions
 * Q07  - Two Sum (return indices)
 * Q08  - Best Time to Buy and Sell Stock (1 transaction)
 * Q09  - Maximum Subarray Sum (Kadane's Algorithm)
 * Q10  - Find Missing Number (1 to n)
 * Q11  - Find Duplicate Number (Floyd's Cycle)
 * Q12  - Merge Two Sorted Arrays
 * Q13  - Sort 0s, 1s and 2s (Dutch National Flag)
 * Q14  - Subarray with Given Sum (Positive numbers)
 * Q15  - Majority Element (Boyer-Moore Voting)
 * Q16  - Maximum Product Subarray
 * Q17  - Find All Pairs with Given Sum
 * Q18  - Rotate Matrix 90 Degrees
 * Q19  - Spiral Order Traversal of Matrix
 * Q20  - Search in Rotated Sorted Array
 * Q21  - Find Peak Element
 * Q22  - Container With Most Water
 * Q23  - 3Sum (find all unique triplets)
 * Q24  - Trapping Rain Water
 * Q25  - Merge Intervals
 * Q26  - Jump Game I (can reach end?)
 * Q27  - Jump Game II (minimum jumps)
 * Q28  - Product of Array Except Self
 * Q29  - Find Minimum in Rotated Sorted Array
 * Q30  - Longest Consecutive Sequence
 * Q31  - Set Matrix Zeroes
 * Q32  - Pascal's Triangle
 * Q33  - Count Inversions in Array (Merge Sort)
 * Q34  - Median of Two Sorted Arrays
 * Q35  - Subarray Sum Equals K (prefix sum)
 * Q36  - Longest Subarray with Sum 0
 * Q37  - 4Sum (find all unique quadruplets)
 * Q38  - Next Permutation
 * Q39  - Find Celebrity Problem
 * Q40  - Maximum Sum of Non-Adjacent Elements
 * Q41  - Minimum Platforms Required
 * Q42  - Chocolate Distribution Problem
 * Q43  - Smallest Subarray with Sum > X
 * Q44  - Maximum Circular Subarray Sum
 * Q45  - Stock Buy Sell Multiple Transactions
 * Q46  - Rearrange Array Alternately (max, min)
 * Q47  - Find Kth Largest Element (QuickSelect)
 * Q48  - First Missing Positive
 * Q49  - Sliding Window Maximum (Deque)
 * Q50  - Maximum Sum Rectangle in 2D Matrix (Kadane's on columns)
 */
public class ArrayDSA50Questions {


    // ============================================================
    // Q01: Find Maximum and Minimum in Array
    // Approach: Single pass comparison
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int[] findMaxMin(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
            if (x < min) min = x;
        }
        return new int[]{max, min};
    }


    // ============================================================
    // Q02: Reverse an Array
    // Approach: Two-pointer swap from both ends
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int[] reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left]; arr[left++] = arr[right]; arr[right--] = tmp;
        }
        return arr;
    }


    // ============================================================
    // Q03: Find Second Largest Element
    // Approach: Single pass tracking two maximums
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > first)        { second = first; first = x; }
            else if (x > second && x != first) second = x;
        }
        return second;
    }


    // ============================================================
    // Q04: Remove Duplicates from Sorted Array (in-place)
    // Approach: Two-pointer — slow/fast
    // Time: O(n), Space: O(1)
    // Returns count of unique elements
    // ============================================================
    public static int removeDuplicatesSorted(int[] arr) {
        if (arr.length == 0) return 0;
        int slow = 0;
        for (int fast = 1; fast < arr.length; fast++)
            if (arr[fast] != arr[slow]) arr[++slow] = arr[fast];
        return slow + 1;
    }


    // ============================================================
    // Q05: Move All Zeros to End (maintain relative order)
    // Approach: Two-pointer — fill non-zero forward, then pad zeros
    // Time: O(n), Space: O(1)
    // ============================================================
    public static void moveZerosToEnd(int[] arr) {
        int idx = 0;
        for (int x : arr) if (x != 0) arr[idx++] = x;
        while (idx < arr.length) arr[idx++] = 0;
    }


    // ============================================================
    // Q06: Left Rotate Array by K Positions
    // Approach: Reverse entire → reverse first n-k → reverse last k
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int[] leftRotate(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        return arr;
    }
    private static void reverse(int[] arr, int l, int r) {
        while (l < r) { int t = arr[l]; arr[l++] = arr[r]; arr[r--] = t; }
    }


    // ============================================================
    // Q07: Two Sum — Return Indices
    // Approach: HashMap stores value → index
    // Time: O(n), Space: O(n)
    // ============================================================
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    // ============================================================
    // Q08: Best Time to Buy and Sell Stock (1 transaction)
    // Approach: Track running minimum, compute max profit
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice   = Math.min(minPrice, price);
            maxProfit  = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }


    // ============================================================
    // Q09: Maximum Subarray Sum — Kadane's Algorithm
    // Approach: Extend subarray or start fresh at each index
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int maxSubarraySum(int[] nums) {
        int maxSum = nums[0], curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }


    // ============================================================
    // Q10: Find Missing Number in Array [1..n]
    // Approach: Expected sum − actual sum
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int findMissingNumber(int[] arr, int n) {
        int expected = n * (n + 1) / 2;
        int actual   = 0;
        for (int x : arr) actual += x;
        return expected - actual;
    }


    // ============================================================
    // Q11: Find the Duplicate Number (nums in [1..n], one duplicate)
    // Approach: Floyd's Cycle Detection (Tortoise and Hare)
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    // ============================================================
    // Q12: Merge Two Sorted Arrays into One Sorted Array
    // Approach: Two-pointer merge (like merge sort step)
    // Time: O(m+n), Space: O(m+n)
    // ============================================================
    public static int[] mergeSorted(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            res[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return res;
    }


    // ============================================================
    // Q13: Sort Array of 0s, 1s, 2s — Dutch National Flag
    // Approach: Three-pointer: low, mid, high
    // Time: O(n), Space: O(1)
    // ============================================================
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if      (nums[mid] == 0) { swap(nums, low++, mid++); }
            else if (nums[mid] == 1) { mid++; }
            else                     { swap(nums, mid, high--);  }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }


    // ============================================================
    // Q14: Subarray with Given Sum (positive numbers)
    // Approach: Sliding window — expand right, shrink left
    // Time: O(n), Space: O(1)
    // Returns [start, end] indices (0-based), or [-1,-1]
    // ============================================================
    public static int[] subarrayWithSum(int[] arr, int target) {
        int left = 0, curSum = 0;
        for (int right = 0; right < arr.length; right++) {
            curSum += arr[right];
            while (curSum > target && left < right) curSum -= arr[left++];
            if (curSum == target) return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }


    // ============================================================
    // Q15: Majority Element (appears > n/2 times)
    // Approach: Boyer-Moore Voting Algorithm
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) { candidate = nums[i]; count = 1; }
            else count += (nums[i] == candidate) ? 1 : -1;
        }
        return candidate;
    }


    // ============================================================
    // Q16: Maximum Product Subarray
    // Approach: Track max and min (negative*negative = positive)
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) { int tmp = maxProd; maxProd = minProd; minProd = tmp; }
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);
            result  = Math.max(result, maxProd);
        }
        return result;
    }


    // ============================================================
    // Q17: Find All Pairs with Given Sum
    // Approach: HashSet — for each element check if complement exists
    // Time: O(n), Space: O(n)
    // ============================================================
    public static void findPairsWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> printed = new HashSet<>();
        for (int x : arr) {
            int complement = target - x;
            if (seen.contains(complement) && !printed.contains(x)) {
                System.out.println("(" + complement + ", " + x + ")");
                printed.add(x);
                printed.add(complement);
            }
            seen.add(x);
        }
    }


    // ============================================================
    // Q18: Rotate Matrix 90 Degrees Clockwise (in-place)
    // Approach: Transpose + Reverse each row
    // Time: O(n²), Space: O(1)
    // ============================================================
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        // Step 1: Transpose
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j]; matrix[i][j] = matrix[j][i]; matrix[j][i] = t;
            }
        // Step 2: Reverse each row
        for (int[] row : matrix) {
            int l = 0, r = row.length - 1;
            while (l < r) { int t = row[l]; row[l++] = row[r]; row[r--] = t; }
        }
    }


    // ============================================================
    // Q19: Spiral Order Matrix Traversal
    // Approach: Shrink boundaries layer by layer
    // Time: O(m*n), Space: O(1) extra
    // ============================================================
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left;  i <= right;  i++) res.add(matrix[top][i]);   top++;
            for (int i = top;   i <= bottom; i++) res.add(matrix[i][right]); right--;
            if (top <= bottom)
                for (int i = right; i >= left;   i--) res.add(matrix[bottom][i]); bottom--;
            if (left <= right)
                for (int i = bottom; i >= top;   i--) res.add(matrix[i][left]);   left++;
        }
        return res;
    }


    // ============================================================
    // Q20: Search in Rotated Sorted Array
    // Approach: Modified Binary Search
    // Time: O(log n), Space: O(1)
    // ============================================================
    public static int searchRotated(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lo] <= nums[mid]) {         // left half sorted
                if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {                             // right half sorted
                if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }


    // ============================================================
    // Q21: Find Peak Element (element > both neighbors)
    // Approach: Binary Search — move toward higher neighbor
    // Time: O(log n), Space: O(1)
    // ============================================================
    public static int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }


    // ============================================================
    // Q22: Container With Most Water
    // Approach: Two-pointer — always move the shorter side inward
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int maxWater(int[] height) {
        int left = 0, right = height.length - 1, maxVol = 0;
        while (left < right) {
            maxVol = Math.max(maxVol, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxVol;
    }


    // ============================================================
    // Q23: 3Sum — All Unique Triplets Summing to Zero
    // Approach: Sort + Two-pointer for each fixed element
    // Time: O(n²), Space: O(1) extra
    // ============================================================
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left]  == nums[left  + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return res;
    }


    // ============================================================
    // Q24: Trapping Rain Water
    // Approach: Two-pointer with running max from both sides
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }


    // ============================================================
    // Q25: Merge Overlapping Intervals
    // Approach: Sort by start, merge if overlapping
    // Time: O(n log n), Space: O(n)
    // ============================================================
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) cur[1] = Math.max(cur[1], intervals[i][1]);
            else { res.add(cur); cur = intervals[i]; }
        }
        res.add(cur);
        return res.toArray(new int[0][]);
    }


    // ============================================================
    // Q26: Jump Game I — Can you reach the last index?
    // Approach: Greedy — track max reachable index
    // Time: O(n), Space: O(1)
    // ============================================================
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }


    // ============================================================
    // Q27: Jump Game II — Minimum Number of Jumps
    // Approach: Greedy BFS — jump when current range exhausted
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int minJumps(int[] nums) {
        int jumps = 0, curEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) { jumps++; curEnd = farthest; }
        }
        return jumps;
    }


    // ============================================================
    // Q28: Product of Array Except Self (no division)
    // Approach: Left prefix products × right suffix products
    // Time: O(n), Space: O(1) extra (output array doesn't count)
    // ============================================================
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        out[0] = 1;
        for (int i = 1; i < n; i++) out[i] = out[i - 1] * nums[i - 1]; // left products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) { out[i] *= right; right *= nums[i]; } // multiply right
        return out;
    }


    // ============================================================
    // Q29: Find Minimum in Rotated Sorted Array
    // Approach: Binary Search — minimum is at the rotation point
    // Time: O(log n), Space: O(1)
    // ============================================================
    public static int findMinRotated(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1; // min is in right half
            else hi = mid;                           // min is in left half (including mid)
        }
        return nums[lo];
    }


    // ============================================================
    // Q30: Longest Consecutive Sequence
    // Approach: HashSet — start counting only from sequence starts
    // Time: O(n), Space: O(n)
    // ============================================================
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int longest = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) { // start of sequence
                int len = 1;
                while (set.contains(x + len)) len++;
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }


    // ============================================================
    // Q31: Set Matrix Zeroes (in-place)
    // Approach: Use first row/col as markers to avoid extra space
    // Time: O(m*n), Space: O(1)
    // ============================================================
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRow = true;
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstCol = true;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0) { matrix[i][0] = 0; matrix[0][j] = 0; }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
        if (firstRow) for (int j = 0; j < n; j++) matrix[0][j] = 0;
        if (firstCol) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }


    // ============================================================
    // Q32: Pascal's Triangle (return first n rows)
    // Approach: Each row derived from previous; edges always 1
    // Time: O(n²), Space: O(n²)
    // ============================================================
    public static List<List<Integer>> pascalsTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prev = i > 0 ? res.get(i - 1) : null;
            for (int j = 1; j < i; j++) row.add(prev.get(j - 1) + prev.get(j));
            if (i > 0) row.add(1);
            res.add(row);
        }
        return res;
    }


    // ============================================================
    // Q33: Count Inversions in Array (using Merge Sort)
    // Approach: During merge, count how many right-half elements are placed before left
    // Time: O(n log n), Space: O(n)
    // ============================================================
    public static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    private static long mergeSort(int[] arr, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        long count = mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r);
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else { count += (mid - i + 1); temp[k++] = arr[j++]; } // all remaining left are > arr[j]
        }
        while (i <= mid)  temp[k++] = arr[i++];
        while (j <= r)    temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, l, temp.length);
        return count;
    }


    // ============================================================
    // Q34: Median of Two Sorted Arrays
    // Approach: Binary search on the smaller array
    // Time: O(log(min(m,n))), Space: O(1)
    // ============================================================
    public static double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays(B, A);
        int m = A.length, n = B.length;
        int lo = 0, hi = m;
        while (lo <= hi) {
            int i = (lo + hi) / 2, j = (m + n + 1) / 2 - i;
            int maxLeftA  = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : A[i];
            int maxLeftB  = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : B[j];
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 1) return Math.max(maxLeftA, maxLeftB);
                return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
            } else if (maxLeftA > minRightB) hi = i - 1;
            else lo = i + 1;
        }
        return 0.0;
    }


    // ============================================================
    // Q35: Subarray Sum Equals K (count subarrays)
    // Approach: Prefix sum + HashMap
    // Time: O(n), Space: O(n)
    // ============================================================
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, prefixSum = 0;
        for (int x : nums) {
            prefixSum += x;
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }


    // ============================================================
    // Q36: Longest Subarray with Sum 0
    // Approach: Prefix sum + HashMap (store first occurrence index)
    // Time: O(n), Space: O(n)
    // ============================================================
    public static int longestSubarraySumZero(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) maxLen = Math.max(maxLen, i - map.get(sum));
            else map.put(sum, i);
        }
        return maxLen;
    }


    // ============================================================
    // Q37: 4Sum — All Unique Quadruplets Summing to Target
    // Approach: Sort + Two-pointer (extension of 3Sum)
    // Time: O(n³), Space: O(1) extra
    // ============================================================
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left]  == nums[left  + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++; right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }


    // ============================================================
    // Q38: Next Permutation
    // Approach: Find rightmost ascent, swap with next greater, reverse suffix
    // Time: O(n), Space: O(1)
    // ============================================================
    public static void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--; // find pivot
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;             // find next greater
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);                    // reverse suffix
    }


    // ============================================================
    // Q39: Find Celebrity
    // A celebrity knows nobody but everybody knows the celebrity
    // Approach: Elimination — two-pointer candidate narrowing
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int findCelebrity(int[][] knows, int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++)
            if (knows[candidate][i] == 1) candidate = i; // candidate knows i → not celebrity
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows[candidate][i] == 1 || knows[i][candidate] == 0) return -1;
        }
        return candidate;
    }


    // ============================================================
    // Q40: Maximum Sum of Non-Adjacent Elements (House Robber)
    // Approach: DP — at each step choose include or skip
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int maxSumNonAdjacent(int[] nums) {
        if (nums.length == 0) return 0;
        int prev2 = 0, prev1 = 0;
        for (int x : nums) {
            int cur = Math.max(prev1, prev2 + x);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }


    // ============================================================
    // Q41: Minimum Number of Platforms Required at Railway Station
    // Approach: Sort arrivals & departures; use two-pointer sweep
    // Time: O(n log n), Space: O(1)
    // ============================================================
    public static int minPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms = 1, maxPlatforms = 1;
        int i = 1, j = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) { platforms++; i++; }
            else                   { platforms--; j++; }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }
        return maxPlatforms;
    }


    // ============================================================
    // Q42: Chocolate Distribution Problem
    // Given array of chocolate packets, pick m packets to minimize
    // difference between max and min in selection
    // Approach: Sort + sliding window of size m
    // Time: O(n log n), Space: O(1)
    // ============================================================
    public static int chocolateDistribution(int[] arr, int m) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < arr.length; i++)
            minDiff = Math.min(minDiff, arr[i + m - 1] - arr[i]);
        return minDiff;
    }


    // ============================================================
    // Q43: Smallest Subarray with Sum Greater than X
    // Approach: Sliding window — expand then shrink
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int smallestSubarrayGtX(int[] arr, int x) {
        int n = arr.length, left = 0, curSum = 0, minLen = n + 1;
        for (int right = 0; right < n; right++) {
            curSum += arr[right];
            while (curSum > x) {
                minLen = Math.min(minLen, right - left + 1);
                curSum -= arr[left++];
            }
        }
        return (minLen == n + 1) ? 0 : minLen;
    }


    // ============================================================
    // Q44: Maximum Circular Subarray Sum
    // Approach: max(Kadane's normal, total_sum - Kadane's on negated array)
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int maxCircularSum(int[] nums) {
        int totalSum   = 0;
        int maxSum     = nums[0], curMax = 0;
        int minSum     = nums[0], curMin = 0;
        for (int x : nums) {
            curMax  = Math.max(curMax + x, x); maxSum  = Math.max(maxSum, curMax);
            curMin  = Math.min(curMin + x, x); minSum  = Math.min(minSum, curMin);
            totalSum += x;
        }
        return (maxSum < 0) ? maxSum : Math.max(maxSum, totalSum - minSum);
    }


    // ============================================================
    // Q45: Best Time to Buy & Sell Stock — Multiple Transactions
    // Approach: Greedy — accumulate every upward slope
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int maxProfitMulti(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }


    // ============================================================
    // Q46: Rearrange Array Alternately (max, min, max, min…)
    // Approach: Sort then interleave from both ends
    // Time: O(n log n), Space: O(n)
    // ============================================================
    public static int[] rearrangeAlternately(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] res = new int[n];
        int lo = 0, hi = n - 1, idx = 0;
        while (lo <= hi) {
            if (idx % 2 == 0) res[idx++] = arr[hi--];
            else               res[idx++] = arr[lo++];
        }
        return res;
    }


    // ============================================================
    // Q47: Find Kth Largest Element (QuickSelect)
    // Approach: Partition like QuickSort; only recurse on one side
    // Time: O(n) average, O(n²) worst, Space: O(1)
    // ============================================================
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    private static int quickSelect(int[] arr, int lo, int hi, int kSmallest) {
        if (lo == hi) return arr[lo];
        int pivot = arr[hi], storeIdx = lo;
        for (int i = lo; i < hi; i++)
            if (arr[i] <= pivot) swap(arr, i, storeIdx++);
        swap(arr, storeIdx, hi);
        if (storeIdx == kSmallest)      return arr[storeIdx];
        else if (storeIdx < kSmallest)  return quickSelect(arr, storeIdx + 1, hi, kSmallest);
        else                            return quickSelect(arr, lo, storeIdx - 1, kSmallest);
    }


    // ============================================================
    // Q48: First Missing Positive Integer
    // Approach: Index as hash — place each x at index x-1 if valid
    // Time: O(n), Space: O(1)
    // ============================================================
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1) return i + 1;
        return n + 1;
    }


    // ============================================================
    // Q49: Sliding Window Maximum
    // Approach: Monotonic Deque — front always holds index of max in window
    // Time: O(n), Space: O(k)
    // ============================================================
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst(); // out of window
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast(); // remove smaller
            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }


    // ============================================================
    // Q50: Maximum Sum Rectangle in 2D Matrix
    // Approach: Fix left & right column bounds, apply Kadane's on row sums
    // Time: O(n² * m), Space: O(m)
    // ============================================================
    public static int maxSumRectangle(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int r = 0; r < rows; r++) rowSum[r] += matrix[r][right];
                // Kadane's on rowSum
                int cur = rowSum[0], best = rowSum[0];
                for (int r = 1; r < rows; r++) {
                    cur  = Math.max(rowSum[r], cur + rowSum[r]);
                    best = Math.max(best, cur);
                }
                maxSum = Math.max(maxSum, best);
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {

        System.out.println("=== Q01: Find Max and Min ===");
        int[] arr1 = {3, 1, 7, 2, 9, 4};
        int[] mm = findMaxMin(arr1);
        System.out.println("Max=" + mm[0] + ", Min=" + mm[1]); // 9, 1

        System.out.println("\n=== Q02: Reverse Array ===");
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverseArray(arr2))); // [5,4,3,2,1]

        System.out.println("\n=== Q03: Second Largest ===");
        System.out.println(secondLargest(new int[]{5, 2, 9, 1, 7})); // 7

        System.out.println("\n=== Q04: Remove Duplicates from Sorted Array ===");
        System.out.println(removeDuplicatesSorted(new int[]{1,1,2,2,3,4,4,5})); // 5

        System.out.println("\n=== Q05: Move Zeros to End ===");
        int[] arr5 = {0, 1, 0, 3, 12};
        moveZerosToEnd(arr5);
        System.out.println(Arrays.toString(arr5)); // [1,3,12,0,0]

        System.out.println("\n=== Q06: Left Rotate by K ===");
        int[] arr6 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(leftRotate(arr6, 2))); // [3,4,5,1,2]

        System.out.println("\n=== Q07: Two Sum ===");
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9))); // [0,1]

        System.out.println("\n=== Q08: Best Time to Buy & Sell Stock ===");
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 5

        System.out.println("\n=== Q09: Maximum Subarray (Kadane's) ===");
        System.out.println(maxSubarraySum(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6

        System.out.println("\n=== Q10: Find Missing Number ===");
        System.out.println(findMissingNumber(new int[]{1,2,4,5,6}, 6)); // 3

        System.out.println("\n=== Q11: Find Duplicate (Floyd's Cycle) ===");
        System.out.println(findDuplicate(new int[]{1,3,4,2,2})); // 2

        System.out.println("\n=== Q12: Merge Two Sorted Arrays ===");
        System.out.println(Arrays.toString(mergeSorted(new int[]{1,3,5}, new int[]{2,4,6}))); // [1,2,3,4,5,6]

        System.out.println("\n=== Q13: Sort 0s 1s 2s (DNF) ===");
        int[] arr13 = {2,0,2,1,1,0};
        sortColors(arr13);
        System.out.println(Arrays.toString(arr13)); // [0,0,1,1,2,2]

        System.out.println("\n=== Q14: Subarray with Given Sum ===");
        System.out.println(Arrays.toString(subarrayWithSum(new int[]{1,4,20,3,10,5}, 33))); // [2,4]

        System.out.println("\n=== Q15: Majority Element ===");
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2})); // 2

        System.out.println("\n=== Q16: Maximum Product Subarray ===");
        System.out.println(maxProduct(new int[]{2,3,-2,4})); // 6

        System.out.println("\n=== Q17: All Pairs with Given Sum ===");
        findPairsWithSum(new int[]{1,5,3,2,4}, 6); // (1,5),(2,4)

        System.out.println("\n=== Q18: Rotate Matrix 90 Degrees ===");
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix(mat);
        for (int[] row : mat) System.out.println(Arrays.toString(row));

        System.out.println("\n=== Q19: Spiral Order Traversal ===");
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));

        System.out.println("\n=== Q20: Search in Rotated Sorted Array ===");
        System.out.println(searchRotated(new int[]{4,5,6,7,0,1,2}, 0)); // 4

        System.out.println("\n=== Q21: Find Peak Element ===");
        System.out.println(findPeakElement(new int[]{1,2,3,1})); // 2

        System.out.println("\n=== Q22: Container With Most Water ===");
        System.out.println(maxWater(new int[]{1,8,6,2,5,4,8,3,7})); // 49

        System.out.println("\n=== Q23: 3Sum ===");
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]

        System.out.println("\n=== Q24: Trapping Rain Water ===");
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6

        System.out.println("\n=== Q25: Merge Intervals ===");
        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1,3},{2,6},{8,10},{15,18}}))); // [[1,6],[8,10],[15,18]]

        System.out.println("\n=== Q26: Jump Game I ===");
        System.out.println(canJump(new int[]{2,3,1,1,4})); // true
        System.out.println(canJump(new int[]{3,2,1,0,4})); // false

        System.out.println("\n=== Q27: Jump Game II (Min Jumps) ===");
        System.out.println(minJumps(new int[]{2,3,1,1,4})); // 2

        System.out.println("\n=== Q28: Product Except Self ===");
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4}))); // [24,12,8,6]

        System.out.println("\n=== Q29: Min in Rotated Sorted Array ===");
        System.out.println(findMinRotated(new int[]{3,4,5,1,2})); // 1

        System.out.println("\n=== Q30: Longest Consecutive Sequence ===");
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2})); // 4

        System.out.println("\n=== Q31: Set Matrix Zeroes ===");
        int[][] mat31 = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(mat31);
        for (int[] row : mat31) System.out.println(Arrays.toString(row));

        System.out.println("\n=== Q32: Pascal's Triangle ===");
        System.out.println(pascalsTriangle(5));

        System.out.println("\n=== Q33: Count Inversions ===");
        System.out.println(countInversions(new int[]{5,4,3,2,1})); // 10

        System.out.println("\n=== Q34: Median of Two Sorted Arrays ===");
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2})); // 2.0

        System.out.println("\n=== Q35: Subarray Sum Equals K ===");
        System.out.println(subarraySum(new int[]{1,1,1}, 2)); // 2

        System.out.println("\n=== Q36: Longest Subarray with Sum 0 ===");
        System.out.println(longestSubarraySumZero(new int[]{15,-2,2,-8,1,7,10,23})); // 5

        System.out.println("\n=== Q37: 4Sum ===");
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));

        System.out.println("\n=== Q38: Next Permutation ===");
        int[] arr38 = {1,2,3};
        nextPermutation(arr38);
        System.out.println(Arrays.toString(arr38)); // [1,3,2]

        System.out.println("\n=== Q39: Find Celebrity ===");
        System.out.println(findCelebrity(new int[][]{{0,1,1},{0,0,1},{0,0,0}}, 3)); // 2

        System.out.println("\n=== Q40: Max Sum Non-Adjacent ===");
        System.out.println(maxSumNonAdjacent(new int[]{3,2,5,10,7})); // 15

        System.out.println("\n=== Q41: Minimum Platforms ===");
        System.out.println(minPlatforms(
                new int[]{900,940,950,1100,1500,1800},
                new int[]{910,1200,1120,1130,1900,2000})); // 3

        System.out.println("\n=== Q42: Chocolate Distribution ===");
        System.out.println(chocolateDistribution(new int[]{3,4,1,9,56,7,9,12}, 5)); // 6

        System.out.println("\n=== Q43: Smallest Subarray Sum > X ===");
        System.out.println(smallestSubarrayGtX(new int[]{1,4,45,6,0,19}, 51)); // 3

        System.out.println("\n=== Q44: Maximum Circular Subarray Sum ===");
        System.out.println(maxCircularSum(new int[]{8,-8,9,-9,10,-11,12})); // 22

        System.out.println("\n=== Q45: Stock Buy Sell Multiple Transactions ===");
        System.out.println(maxProfitMulti(new int[]{7,1,5,3,6,4})); // 7

        System.out.println("\n=== Q46: Rearrange Alternately (Max, Min) ===");
        System.out.println(Arrays.toString(rearrangeAlternately(new int[]{1,2,3,4,5,6}))); // [6,1,5,2,4,3]

        System.out.println("\n=== Q47: Kth Largest Element (QuickSelect) ===");
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5

        System.out.println("\n=== Q48: First Missing Positive ===");
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1})); // 2

        System.out.println("\n=== Q49: Sliding Window Maximum ===");
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3))); // [3,3,5,5,6,7]

        System.out.println("\n=== Q50: Max Sum Rectangle in 2D Matrix ===");
        System.out.println(maxSumRectangle(new int[][]{{1,2,-1,-4,-20},{-8,-3,4,2,1},{3,8,10,1,3},{-4,-1,1,7,-6}})); // 29
    }


}
