package DynamicProgrammingGrids;
import java.util.*;
//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    static int minSumPath(int n, int m, int[][] matrix){
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0 && j==0) {
                    dp[i][j] = matrix[0][0];
                } else {
                    int up = matrix[i][j];
                    if(i>0) up+=dp[i-1][j];
                    else up+=(int)Math.pow(10,9);
                    int left = matrix[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left+=(int)Math.pow(10,9);
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];

    }
    static int minSumPathTopDown(int n, int m, int[][] matrix){
        int dp[][]=new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return minSumPathUtil(n-1,m-1,matrix,dp);

    }

    private static int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp) {
        if(i==0 && j==0) return matrix[0][0];
        if(i<0 || j<0) return (int)Math.pow(10,9);
        if(dp[i][j]!=-1) return dp[i][j];
        int up = matrix[i][j] + minSumPathUtil(i-1,j,matrix,dp);
        int left = matrix[i][j] + minSumPathUtil(i,j-1,matrix,dp);
        dp[i][j] = Math.min(up,left);
        return dp[i][j];
    }

    public static void main(String args[]) {

        int matrix[][] = {{5,9,6},{11,5,2}};

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(minSumPath(n,m,matrix));
    }
}
