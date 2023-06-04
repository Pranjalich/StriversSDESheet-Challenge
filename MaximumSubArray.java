public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }

    private static long maxSubarraySum(int[] arr, int n) {
        int maxSum = arr[0];
        int currMax = arr[0];
        for(int i=1;i<n;i++) {
            currMax = Math.max(arr[i],currMax+arr[i]);
            maxSum = Math.max(maxSum,currMax);
        }
        return maxSum;
    }
}
