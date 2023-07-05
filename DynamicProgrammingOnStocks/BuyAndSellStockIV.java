package DynamicProgrammingOnStocks;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class BuyAndSellStockIV {
    public static void main(String args[]) {
        int[] arr ={3,3,5,0,0,3,1,4};
        int n = arr.length;
        int k = 2;
        System.out.println("The maximum profit that can be generated is "+
                maximumProfit(arr,n,k));
    }
    private static long maximumProfit(int[] arr, int n, int k) {
        if(n==0) return 0;
        long[][] ahead = new long[2][k+1];
        long[][] curr = new long[2][k+1];
        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                for(int cap=1;cap<=2;cap++) {
                    long op1=0,op2=0;
                    if(buy==1) {
                        op1 = Math.max(-arr[i]+ahead[0][cap], ahead[1][cap]);
                    } else {
                        op2=Math.max(arr[i]+ahead[1][cap-1], ahead[0][cap]);
                    }
                    long profit = Math.max(op1,op2);
                    curr[buy][cap] = profit;
                }
            }
            ahead=curr;
        }
        return ahead[1][k];
    }
    private static long maximumProfitBottomUp(int[] arr, int n, int k) {
        if(n==0) return 0;
        long[][][] dp = new long[n+1][2][k+1];
        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                for(int cap=1;cap<=2;cap++) {
                    long op1=0,op2=0;
                    if(buy==1) {
                        op1 = Math.max(-arr[i]+dp[i+1][0][cap], dp[i+1][1][cap]);
                    } else {
                        op2=Math.max(arr[i]+dp[i+1][1][cap-1], dp[i+1][0][cap]);
                    }
                    long profit = Math.max(op1,op2);
                    dp[i][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
    private static long maximumProfitTopDown(int[] arr, int n, int k) {
        if(n==0) return 0;
        long[][][] dp = new long[n][2][k+1];
        return maximumProfitUtil(0,1,k,arr,n,dp);
    }

    private static long maximumProfitUtil(int i, int buy, int cap, int[] arr, int n, long[][][] dp) {
        if(i==n) return 0;
        if(cap==0) return 0;
        if(dp[i][buy][cap]!=0) return dp[i][buy][cap];
        long op1=0,op2=0;
        if(buy==1) {
            op1 = Math.max(-arr[i]+maximumProfitUtil(i+1,0,cap,arr,n,dp),
                    maximumProfitUtil(i+1,1,cap,arr,n,dp));
        } else {
            op2=Math.max(arr[i]+maximumProfitUtil(i+1,1,cap-1,arr,n,dp),
                    maximumProfitUtil(i+1,0,cap,arr,n,dp));
        }
        long profit = Math.max(op1,op2);
        dp[i][buy][cap] = profit;
        return dp[i][buy][cap];
    }
}
