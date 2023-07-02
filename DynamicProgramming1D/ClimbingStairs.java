package DynamicProgramming1D;
//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("climbing stairs: "+climbStairs(6));
    }

    private static int climbStairsWithSpace(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int climbStairs(int n) {
        if(n==1) return 1;
        int first = 1;
        int second = 2;
        for(int i=3;i<=n;i++) {
            int third = first+second;
            first = second;
            second = third;
        }
        return second;
    }
}
