package DynamicProgrammingOnLIS;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String args[]) {

        int[] arr = {1,5,4,3,2,6,7,2};

        System.out.println("The count of LIS is "+findNumberOfLIS(arr));

    }

    private static int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int maxi=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i] && dp[j]+1>dp[i]) {
                    dp[i] = dp[j]+1;
                    cnt[i] = cnt[j];
                } else if(arr[j]<arr[i] && dp[j]+1==dp[i]) {
                    cnt[i]+=cnt[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(dp[i]==maxi) {
                ans+=cnt[i];
            }
        }
        return ans;
    }
}
