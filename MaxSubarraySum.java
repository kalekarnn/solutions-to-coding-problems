/**************************************************************************************
 *
 * Kadane's Algorithm
 *
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 *
 * Input:
 * N = 5
 * arr[] = {1,2,3,-2,5}
 * Output:
 * 9
 * Explanation:
 * Max subarray sum is 9
 * of elements (1, 2, 3, -2, 5) which
 * is a contiguous subarray.
 *
 *
 *************************************************************************************/


public class MaxSubarraySum {

    public static void main(String[] args) {
        MaxSubarraySum maxSubarraySum = new MaxSubarraySum();
        int[] input = {7, 8, -2, 1};
        System.out.println(maxSubarraySum.maxSubarraySum(input, 4));
    }

    int maxSubarraySum(int arr[], int n) {
        //O(n^2)
        //return maxSubarraySumBF(arr, n);

        //O(n)
        return maxSubarraySumOptimised(arr, n);
    }

    int maxSubarraySumBF(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    int maxSubarraySumOptimised(int arr[], int n) {

        int sum = 0, currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum = Math.max(arr[i], arr[i] + currSum);
            sum = Math.max(currSum, sum);
        }

        return sum;
    }
}
