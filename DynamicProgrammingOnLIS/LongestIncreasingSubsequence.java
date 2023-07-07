package DynamicProgrammingOnLIS;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public static void main(String args[]) {

        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is "+longestIncreasingSubsequence(arr,n));

    }

    private static int longestIncreasingSubsequence(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i] && dp[j]+1>dp[i]) {
                    dp[i] = 1+dp[j];
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

}
