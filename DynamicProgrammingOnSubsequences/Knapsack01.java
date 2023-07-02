package DynamicProgrammingOnSubsequences;

public class Knapsack01 {
    public static void main(String[] args) {
        int wt[] = {1,2,4,5};
        int val[] = {5,4,8,6};
        int W=5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "+
        knapsack(wt,val,n,W));
    }
    private static int knapsack(int[] wt, int[] val, int n, int w) {
        int[] dp = new int[w+1];
        for(int i=wt[0];i<=w;i++) {
            dp[i] = val[0];
        }
        for(int i=1;i<n;i++) {
            for(int weight=w;weight>=0;weight--) {
                int notTake = dp[weight];
                int take = Integer.MIN_VALUE;
                if(wt[i]<=weight) {
                    take = val[i]+dp[weight-wt[i]];
                }
                dp[weight] = Math.max(take,notTake);
            }
        }
        return dp[w];
    }
}
