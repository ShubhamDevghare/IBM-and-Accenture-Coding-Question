package AccentureCoddingQue.Aug_14_2024;
/*

The function accepts an integer array 'arr' of size 'n' as its argument.
The function needs to return the index of an equilibrium point in the array,
where the sum of elements on the left of the index is equal to the sum of elements on the right of the index.
If no equilibrium point exists return -1

 */
public class EquilibriumPoint {

    public static int findEquilibriumPoint(int[] arr) {
        int n = arr.length;

        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        // Traverse the array to find the equilibrium point
        for (int i = 0; i < n; i++) {
            // The right sum for index i is totalSum - leftSum - arr[i]
            int rightSum = totalSum - leftSum - arr[i];

            // Check if the left sum equals the right sum
            if (leftSum == rightSum) {
                return i;  // Return the index of the equilibrium point
            }

            // Update the left sum for the next index
            leftSum += arr[i];
        }

        // If no equilibrium point is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        System.out.println(findEquilibriumPoint(arr));  // Output: 2
    }
}
