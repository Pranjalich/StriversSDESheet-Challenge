package DynamicProgrammingOnSubsequences;
import java.util.*;
//https://takeuforward.org/data-structure/unbounded-knapsack-dp-23/
public class UnboundedKnapsack {
    static int unboundedKnapsack(int n, int W, int[] val,int[] wt) {

        int[] curr=new int[W+1];
        for(int w=wt[0];w<=W;w++) {
            curr[w] = ((int)(w/wt[0])*val[0]);
        }
        for(int i=1;i<n;i++) {
            for(int w=0;w<=W;w++) {
                int notTake = curr[w];
                int take = Integer.MIN_VALUE;
                if(wt[i]<=w) {
                    take = val[i]+curr[w-wt[i]];
                }
                curr[w]=Math.max(take,notTake);
            }
        }
        return curr[W];
    }

    static int unboundedKnapsackBottomUp(int n, int W, int[] val,int[] wt) {

        int[][] dp=new int[n][W+1];
        for(int w=wt[0];w<=W;w++) {
            dp[0][w] = ((int)(w/wt[0])*val[0]);
        }
        for(int i=1;i<n;i++) {
            for(int w=0;w<=W;w++) {
                int notTake = dp[i-1][w];
                int take = Integer.MIN_VALUE;
                if(wt[i]<=w) {
                    take = val[i]+dp[i][w-wt[i]];
                }
                dp[i][w]=Math.max(take,notTake);
            }
        }
        return dp[n-1][W];
    }
    static int unboundedKnapsackTopDown(int n, int W, int[] val,int[] wt) {

        int[][] dp=new int[n][W+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return knapsackUtil(wt, val, n-1, W, dp);
    }

    private static int knapsackUtil(int[] wt, int[] val, int i, int w, int[][] dp) {
        if(i==0) return ((int)(w/wt[0])*val[0]);
        if(dp[i][w]!=-1) return dp[i][w];
        int notTake = knapsackUtil(wt,val,i-1,w,dp);
        int take = Integer.MIN_VALUE;
        if(wt[i]<=w) {
            take = val[i]+knapsackUtil(wt,val,i,w-wt[i],dp);
        }
        dp[i][w]=Math.max(take,notTake);
        return dp[i][w];
    }

    public static void main(String args[]) {

        int wt[] = {2,4,6};
        int val[] = {5,11,13};
        int W=10;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "+unboundedKnapsack(n,W,val,wt));
    }

}
