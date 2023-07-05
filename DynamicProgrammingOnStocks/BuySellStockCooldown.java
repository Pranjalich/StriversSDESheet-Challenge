package DynamicProgrammingOnStocks;
import java.util.*;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BuySellStockCooldown {
    static int stockProfit(int[] arr)
    {
        int n = arr.length;
        int curr[]=new int[2];
        int ahead[]=new int[2];
        int ahead2[]=new int[2];
        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                if(buy==0) {
                    curr[0] = Math.max(-arr[i] + ahead[1], ahead[0]);
                } else {
                    curr[1] = Math.max(arr[i] + ahead2[0], ahead[1]);
                }
            }
            ahead2=(int[])(ahead.clone());
            ahead=(int[])(curr.clone());;
        }
        return ahead[0];
    }
    static int stockProfitBottomUp(int[] arr)
    {
        int n = arr.length;
        int dp[][]=new int[n+2][2];
        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                if(buy==0) {
                    dp[i][0] = Math.max(-arr[i] + dp[i + 1][1], dp[i + 1][0]);
                } else {
                    dp[i][1] = Math.max(arr[i] + dp[i + 2][0], dp[i + 1][1]);
                }
            }
        }
        return dp[0][0];
    }
    static int stockProfitTopDown(int[] Arr)
    {
        int n = Arr.length;
        int dp[][]=new int[n][2];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        int ans = getAns(Arr,0,0,n,dp);
        return ans;
    }

    private static int getAns(int[] arr, int i, int buy, int n, int[][] dp) {
        if(i>=n) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==0) {
            dp[i][buy] = Math.max(-arr[i]+getAns(arr,i+1,1,n,dp),
                    getAns(arr,i+1,0,n,dp));
        } else {
            dp[i][buy] = Math.max(arr[i]+getAns(arr,i+2,0,n,dp),
                    getAns(arr,i+1,1,n,dp));
        }
        return dp[i][buy];
    }

    public static void main(String args[]) {

        int prices[]= {4,9,0,4,10};

        System.out.println("The maximum profit that can be generated is "+
                stockProfit(prices));
    }
}
