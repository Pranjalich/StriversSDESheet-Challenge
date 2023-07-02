package DynamicProgrammingOnSubsequences;
import java.util.*;

//https://leetcode.com/problems/target-sum/
public class TargetSum {
    static int mod = (int)Math.pow(10,9);
    static int targetSum(int n,int target,int[] arr){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-target<0) return 0;
        if((totSum-target)%2==1) return 0;

        int s2 = (totSum-target)/2;

        int[] prev=new int[s2+1];
        if(arr[0]==0) prev[0] = 2;
        else prev[0] = 1;
        if(arr[0]!=0 && arr[0]<=s2) prev[arr[0]] = 1;
        for(int i=1;i<n;i++) {
            int[] curr=new int[s2+1];
            for(int t=0;t<=s2;t++) {
                int notTake = prev[t];
                int take = 0;
                if(arr[i]<=t)
                    take = prev[t-arr[i]];
                curr[t] = (notTake+take)%mod;
            }
            prev = curr;
        }
        return prev[s2];
    }

    static int targetSumBottomUp(int n,int target,int[] arr){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-target<0) return 0;
        if((totSum-target)%2==1) return 0;

        int s2 = (totSum-target)/2;

        int dp[][]=new int[n][s2+1];
        if(arr[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(arr[0]!=0 && arr[0]<=s2) dp[0][arr[0]] = 1;
        for(int i=1;i<n;i++) {
            for(int t=0;t<=s2;t++) {
                int notTake = dp[i-1][t];
                int take = 0;
                if(arr[i]<=t)
                    take = dp[i-1][t-arr[i]];
                dp[i][t] = (notTake+take)%mod;
            }
        }
        return dp[n-1][s2];
    }

    static int targetSumTopDown(int n,int target,int[] arr){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-target<0) return 0;
        if((totSum-target)%2==1) return 0;

        int s2 = (totSum-target)/2;

        int dp[][]=new int[n][s2+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return countPartitionsUtil(n-1,s2,arr,dp);
    }

    private static int countPartitionsUtil(int i, int target, int[] arr, int[][] dp) {
        if(i==0) {
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target==arr[0])
                return 1;
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int notTake = countPartitionsUtil(i-1,target,arr,dp);
        int take = 0;
        if(arr[i]<=target)
            take = countPartitionsUtil(i-1,target-arr[i],arr,dp);
        dp[i][target] = notTake+take;
        return dp[i][target];
    }

    public static void main(String args[]) {

        int arr[] = {1,2,3,1};
        int target=3;

        int n = arr.length;
        System.out.println("The number of ways found is "+targetSum(n,target,arr));
    }
}
