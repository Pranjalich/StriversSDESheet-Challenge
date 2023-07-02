package DynamicProgrammingGrids;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    static int countWays(int m, int n){
        int dp[][]=new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 && j==0) {
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;
                if(i>0) up = dp[i-1][j];
                int left = 0;
                if(j>0) left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
    static int countWaysTopDown(int m, int n){
        int dp[][]=new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtil(m-1,n-1,dp);

    }

    private static int countWaysUtil(int i, int j, int[][] dp) {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = countWaysUtil(i-1,j,dp);
        int left = countWaysUtil(i,j-1,dp);
        dp[i][j] = up+left;
        return dp[i][j];
    }

    public static void main(String args[]) {

        int m=3;
        int n=2;

        System.out.println(countWays(m,n));
    }
}
