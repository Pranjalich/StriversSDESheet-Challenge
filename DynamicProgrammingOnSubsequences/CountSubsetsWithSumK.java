package DynamicProgrammingOnSubsequences;
import java.util.*;
//https://takeuforward.org/data-structure/count-subsets-with-sum-k-dp-17/
public class CountSubsetsWithSumK {
    static int findWays(int[] num, int k){
        int n = num.length;
        int prev[]=new int[k+1];
        prev[0] = 1;

        if(num[0]<=k) {
            prev[num[0]] = 1;
        }
        for(int i=1;i<n;i++) {
            int curr[]=new int[k+1];
            curr[0] = 1;
            for(int target=1;target<=k;target++) {
                int notTake = prev[target];
                int take = 0;
                if(target>=num[i]) {
                    take = prev[target-num[i]];
                }
                curr[target] = take + notTake;
            }
            prev = curr;
        }
        return prev[k];
    }
    static int findWaysBottomUp(int[] num, int k){
        int n = num.length;
        int dp[][]=new int[n][k+1];
        for(int i=0;i<=k;i++) {
            dp[i][0] = 1;
        }
        if(num[0]<=k) {
            dp[0][num[0]] = 1;
        }
        for(int i=1;i<n;i++) {
            for(int target=1;target<=k;target++) {
                int notTake = dp[i-1][k];
                int take = 0;
                if(k>=num[i]) {
                    take = dp[i-1][k-num[i]];
                }
                dp[i][k] = take + notTake;
            }
        }
        return dp[n-1][k];
    }
    static int findWaysTopDown(int[] num, int k){
        int n = num.length;
        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return findWaysUtil(n-1,k,num,dp);
    }
    private static int findWaysUtil(int i, int k, int[] num, int[][] dp) {
        if(k==0) return 1;
        if(i==0) {
            return num[0]==k?1:0;
        }
        if(dp[i][k]!=-1) return dp[i][k];
        int notTake = findWaysUtil(i-1,k,num,dp);
        int take = 0;
        if(k>=num[i]) {
            take = findWaysUtil(i-1,k-num[i],num,dp);
        }
        dp[i][k] = take + notTake;
        return dp[i][k];
    }

    public static void main(String args[]) {

        int arr[] = {1,2,2,3};
        int k=3;

        System.out.println("The number of subsets found are "+findWays(arr,k));
    }
}
