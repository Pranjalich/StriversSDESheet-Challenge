package DynamicProgrammingOnLIS;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class PrintLongestIncreasingSubsequence {
    public static void main(String args[]) {

        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;

        System.out.println("The longest increasing subsequence is "+longestIncreasingSubsequence(arr,n));

    }

    private static String longestIncreasingSubsequence(int[] arr, int n) {
        int[] dp = new int[n];
        int[] hashIndx = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i] && dp[j]+1>dp[i]) {
                    dp[i] = 1+dp[j];
                    hashIndx[i] = j;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        int lastIndx = -1;
        for(int i=0;i<n;i++) {
            if(dp[i]>ans) {
                ans = dp[i];
                lastIndx = i;
            }
        }
        StringBuilder result = new StringBuilder();
        while(hashIndx[lastIndx]!=lastIndx) {
            result.append(arr[lastIndx]+" ");
            lastIndx = hashIndx[lastIndx];
        }
        return result.reverse().toString();
    }

}
