package DynamicProgrammingGrids;
import java.util.*;
//https://leetcode.com/problems/triangle/
public class MinimumPathSumTriangularGrid {
    static int minimumPathSum(int[][] triangle, int n){
        int dp[][]=new int[n][n];
        for(int j=0;j<n;j++) {
            dp[n-1][j] = triangle[n-1][j];
        }
        for(int i=n-2;i>=0;i--) {
            for(int j=i;j>=0;j--) {
                dp[i][j] = triangle[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];

    }
    static int minimumPathSumTopDown(int[][] triangle, int n){
        int dp[][]=new int[n][n];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return minimumPathSumUtil(0,0,triangle,n,dp);

    }

    private static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==n-1) return triangle[i][j];
        int down = triangle[i][j] + minimumPathSumUtil(i+1,j,triangle,n,dp);
        int right = triangle[i][j] + minimumPathSumUtil(i+1,j+1,triangle,n,dp);
        dp[i][j] = Math.max(down,right);
        return dp[i][j];
    }

    public static void main(String args[]) {

        int triangle [][] = {{1},
                {2,3},
                {3,6,7},
                {8,9,6,10}};

        int n = triangle.length;

        System.out.println(minimumPathSum(triangle,n));
    }
}
