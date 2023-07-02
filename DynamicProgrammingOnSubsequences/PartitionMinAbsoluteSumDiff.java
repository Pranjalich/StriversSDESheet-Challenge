package DynamicProgrammingOnSubsequences;

import java.util.Arrays;

//https://takeuforward.org/data-structure/partition-set-into-2-subsets-with-min-absolute-sum-diff-dp-16/
public class PartitionMinAbsoluteSumDiff {
    static int minAbsDiff(int n,int[] arr){
        int totalSum = 0;
        for(int num: arr) totalSum+=num;

        boolean[] prev=new boolean[totalSum+1];
        prev[0] = true;
        if(arr[0]<=totalSum) {
            prev[arr[0]] = true;
        }
        for(int i=1;i<n;i++) {
            boolean[] curr=new boolean[totalSum+1];
            for(int target=1;target<=totalSum;target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if(target>=arr[i]) {
                    take = prev[target-arr[i]];
                }
                curr[target] = (take || notTake);
            }
            prev = curr;
        }
        int minDiff = Integer.MAX_VALUE;
        for(int k=0;k<=totalSum;k++) {
            if(prev[totalSum]) {
                int diff = Math.abs(k-(totalSum-k));
                minDiff = Math.min(diff,minDiff);
            }
        }
        return minDiff;
    }
    static int minAbsDiffBottomUp(int n,int[] arr){
        int totalSum = 0;
        for(int num: arr) totalSum+=num;

        boolean dp[][]=new boolean[n][totalSum+1];
        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }
        if(arr[0]<=totalSum) {
            dp[0][arr[0]] = true;
        }
        for(int i=1;i<n;i++) {
            for(int target=1;target<=totalSum;target++) {
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(target>=arr[i]) {
                    take = dp[i-1][target-arr[i]];
                }
                dp[i][target] = (take || notTake);
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for(int k=0;k<=totalSum;k++) {
            if(dp[n-1][totalSum]) {
                int diff = Math.abs(k-(totalSum-k));
                minDiff = Math.min(diff,minDiff);
            }
        }
        return minDiff;
    }
    static int minAbsDiffTopDown(int n,int[] arr){
        int totalSum = 0;
        for(int num: arr) totalSum+=num;
        int dp[][]=new int[n][totalSum+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        for(int k=0;k<=totalSum;k++) {
            boolean dummy = minAbsDiffUtil(n-1,k,arr,dp);
        }
        int minDiff = Integer.MAX_VALUE;
        for(int k=0;k<=totalSum;k++) {
            if(dp[n-1][k]==1) {
                int diff = Math.abs(k-(totalSum-k));
                minDiff = Math.min(diff,minDiff);
            }
        }
        return minDiff;
    }

    private static boolean minAbsDiffUtil(int i, int target, int[] arr, int[][] dp) {
        if(target==0){
            return true;
        }
        if(i==0) {
            return arr[0]==target;
        }
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean notTake = minAbsDiffUtil(i-1,target,arr,dp);
        boolean take = false;
        if(target>=arr[i]) {
            take = minAbsDiffUtil(i-1,target-arr[i],arr,dp);
        }
        dp[i][target] = (take || notTake)?1:0;
        return dp[i][target]==1;
    }

    public static void main(String args[]) {

        int arr[] = {1,2,3,4};
        int n = arr.length;

        System.out.println("The minimum absolute difference is: "+minAbsDiff(n,arr));

    }
}
