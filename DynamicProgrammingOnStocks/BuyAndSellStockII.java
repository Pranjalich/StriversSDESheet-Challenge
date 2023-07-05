package DynamicProgrammingOnStocks;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BuyAndSellStockII {
    public static void main(String args[]) {
        int n = 6;
        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maximumProfit(Arr,n));
    }
    private static long maximumProfit(int[] arr, int n) {
        if(n==0) return 0;
        long[] ahead = new long[2];
        long[] curr = new long[2];
        ahead[0]=0;
        ahead[1]=0;
        for(int i=n-2;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                long profit=0;
                if(buy==0) {
                    profit = Math.max(-arr[i]+ahead[1],ahead[0]);
                } else {
                    profit = Math.max(arr[i]+ahead[0],ahead[1]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[0];
    }
    private static long maximumProfitBottomUp(int[] arr, int n) {
        if(n==0) return 0;
        long[][] dp = new long[n][2];
        dp[n-1][0]=0;
        dp[n-1][1]=0;
        for(int i=n-2;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                long profit=0;
                if(buy==0) {
                    profit = Math.max(-arr[i]+dp[i+1][1],dp[i+1][0]);
                } else {
                    profit = Math.max(arr[i]+dp[i+1][0],dp[i+1][1]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
    }
    private static long maximumProfitTopDown(int[] arr, int n) {
        if(n==0) return 0;
        long[][] dp = new long[n][2];
        for(long[] row: dp) {
            Arrays.fill(row,-1);
        }
        return maximumProfitUtil(arr,0,0,n,dp);
    }

    private static long maximumProfitUtil(int[] arr, int i, int buy, int n, long[][] dp) {
        if(i==n) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        long profit=0;
        if(buy==0) {
            profit = Math.max(-arr[i]+maximumProfitUtil(arr,i+1,1,n,dp),maximumProfitUtil(arr,i+1,0,n,dp));
        } else {
            profit = Math.max(arr[i]+maximumProfitUtil(arr,i+1,0,n,dp),maximumProfitUtil(arr,i+1,1,n,dp));
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }
}
