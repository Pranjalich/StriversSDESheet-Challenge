package DynamicProgrammingOnStocks;
import java.util.*;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class BuySellStockTransactionFee {
    static int maximumProfit(int n, int fee, int[] arr)
    {
        //Write your code here

        int prev[] = new int[2];
        int curr[] = new int[2];
        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                if(buy==0) {
                    curr[buy] = Math.max(-arr[i]+prev[1], prev[0]);
                } else {
                    curr[buy] = Math.max(arr[i]-fee+prev[0], prev[1]);
                }
            }
            prev = curr;
        }

        return prev[0];
    }
    static int maximumProfitBottomUp(int n, int fee, int[] arr)
    {
        //Write your code here

        int dp[][]= new int[n+1][2];
        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                if(buy==0) {
                    dp[i][buy] = Math.max(-arr[i]+dp[i+1][1], dp[i+1][0]);
                } else {
                    dp[i][buy] = Math.max(arr[i]-fee+dp[i+1][0], dp[i+1][1]);
                }
            }
        }

        return dp[0][0];
    }
    static int maximumProfitTopDown(int n, int fee, int[] Arr)
    {
        //Write your code here

        int dp[][]= new int[n][2];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        if(n==0) return 0;
        int ans = getAns(Arr,0,0,n,fee,dp);
        return ans;
    }

    private static int getAns(int[] arr, int i, int buy, int n, int fee, int[][] dp) {
        if(i>=n) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==0) {
            dp[i][buy] = Math.max(-arr[i]+getAns(arr,i+1,1,n,fee,dp),
                    getAns(arr,i+1,0,n,fee,dp));
        } else {
            dp[i][buy] = Math.max(arr[i]-fee+getAns(arr,i+1,0,n,fee,dp),
                    getAns(arr,i+1,1,n,fee,dp));
        }
        return dp[i][buy];
    }

    public static void main(String args[]) {

        int prices[] = {1,3,2,8,4,9};
        int n = prices.length;
        int fee = 2;

        System.out.println("The maximum profit that can be generated is "+
                maximumProfit(n,fee,prices));
    }
}
