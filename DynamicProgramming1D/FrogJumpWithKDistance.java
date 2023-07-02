package DynamicProgramming1D;

import java.util.Arrays;

/*
In the previous question, the frog was allowed to jump either one or two steps at a time.
In this question, the frog is allowed to jump up to ‘K’ steps at a time.
If K=4, the frog can jump 1,2,3, or 4 steps at every index.
 */
public class FrogJumpWithKDistance {
    public static void main(String[] args) {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int k=2;
        System.out.println(solve(n,height,k));
    }

    private static int solve(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=1;i<n;i++) {
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++) {
                if(i-j>=0) {
                    int steps = dp[i-j] + Math.abs(height[j]-height[i]);
                    minSteps = Math.min(minSteps,steps);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n];
    }

    private static int solveRec(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solveUtil(n-1,height,k,dp);
    }

    private static int solveUtil(int ind, int[] height, int k, int[] dp) {
        if(ind==0) {
            return 0;
        }
        if(dp[ind]!=-1) {
            return dp[ind];
        }
        int minSteps = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++) {
            if(ind-j>=0) {
                int steps = solveUtil(ind-j,height,k,dp) + Math.abs(height[j]-height[ind]);
                minSteps = Math.min(minSteps,steps);
            }
        }
        dp[ind] = minSteps;
        return dp[ind];
    }
}
