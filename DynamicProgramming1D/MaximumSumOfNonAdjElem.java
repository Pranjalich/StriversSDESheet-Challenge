package DynamicProgramming1D;

import java.util.Arrays;

/*
Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no
two elements of the subsequence are adjacent elements in the array.
Example: n=3
[1,2,4]
Output: 5
 */
public class MaximumSumOfNonAdjElem {
    static int solve(int n,int[] arr){
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1;i<n;i++) {
            int take = 0;
            if(i>1) take = arr[i]+prev2;
            int notTake = prev;
            int curr = Math.max(take,notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    static int solveBottomUp(int n,int[] arr){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        dp[0] = arr[0];
        for(int i=1;i<n;i++) {
            int take = 0;
            if(i>1) take = arr[i]+dp[i-2];
            int notTake = dp[i-1];
            int maxSteps = Math.max(take,notTake);
            dp[i] = maxSteps;
        }
        return dp[n-1];
    }
    static int solveTopDown(int n,int[] arr){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solveUtil(n-1, arr, dp);
    }

    private static int solveUtil(int i, int[] arr, int[] dp) {
        if(i==0) return arr[0];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = arr[i]+solveUtil(i-2,arr,dp);
        int notTake = solveUtil(i-1,arr,dp);
        int maxSteps = Math.max(take,notTake);
        dp[i] = maxSteps;
        return dp[i];
    }


    public static void main(String args[]) {

        int arr[]={2,1,4,9};
        int n=arr.length;
        System.out.println(solve(n,arr));
    }
}
