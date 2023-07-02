package DynamicProgrammingOnSubsequences;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionEqualSubsetSum {
    static boolean canPartition(int n,int[] arr){
        int total=0;
        for(int num: arr) total+=num;
        if(total%2!=0) return false;
        int k = total/2;
        boolean prev[]=new boolean[k+1];
        prev[0] = true;
        if(arr[0]<=k) {
            prev[arr[0]] = true;
        }
        for(int i=1;i<n;i++) {
            boolean curr[]=new boolean[k+1];
            for(int target=1;target<=k;target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if(target>=arr[i]) {
                    take = prev[target-arr[i]];
                }
                curr[target] = (take || notTake);
            }
            prev = curr;
        }
        return prev[k];
    }
    static boolean canPartitionBottomUp(int n,int[] arr){
        int total=0;
        for(int num: arr) total+=num;
        if(total%2!=0) return false;
        int k = total/2;
        boolean dp[][]=new boolean[n][k+1];
        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }
        if(arr[0]<=k) {
            dp[0][arr[0]] = true;
        }
        for(int i=1;i<n;i++) {
            for(int target=1;target<=k;target++) {
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(target>=arr[i]) {
                    take = dp[i-1][target-arr[i]];
                }
                dp[i][target] = (take || notTake);
            }
        }
        return dp[n-1][k];
    }
    static boolean canPartitionTopDown(int n, int[] arr){
        int total=0;
        for(int num: arr) total+=num;
        if(total%2!=0) return false;
        int target = total/2;
        int dp[][]=new int[n][target+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return subsetSumUtil(n-1,target,arr,dp);
    }

    private static boolean subsetSumUtil(int i, int target, int[] arr, int[][] dp) {
        if(target==0){
            return true;
        }
        if(i==0) {
            return arr[0]==target;
        }
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean notTake = subsetSumUtil(i-1,target,arr,dp);
        boolean take = false;
        if(target>=arr[i]) {
            take = subsetSumUtil(i-1,target-arr[i],arr,dp);
        }
        dp[i][target] = (take || notTake)?1:0;
        return dp[i][target]==1;
    }

    public static void main(String args[]) {

        int arr[] = {2,3,3,3,4,5};
        int n = arr.length;

        if(canPartition(n,arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
