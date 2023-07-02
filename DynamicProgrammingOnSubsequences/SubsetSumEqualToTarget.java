package DynamicProgrammingOnSubsequences;
import java.util.*;
//https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/
public class SubsetSumEqualToTarget {
    static boolean subsetSumToK(int n, int k,int[] arr){

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
    static boolean subsetSumToKBottomUp(int n, int k,int[] arr){

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
    static boolean subsetSumToKTopDown(int n, int k,int[] arr){

        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return subsetSumUtil(n-1,k,arr,dp);
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

        int arr[] = {1,2,3,4};
        int k=4;
        int n = arr.length;

        if(subsetSumToK(n,k,arr))
            System.out.println("Subset with given target found");
        else
            System.out.println("Subset with given target not found");
    }
}
