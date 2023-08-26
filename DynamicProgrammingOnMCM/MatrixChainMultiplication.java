package DynamicProgrammingOnMCM;

import java.util.Arrays;

//https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/
//https://takeuforward.org/data-structure/matrix-chain-multiplication-tabulation-method-dp-49/
public class MatrixChainMultiplication {
    static int matrixMultiplication(int[] arr, int N){
        int[][] dp = new int[N][N];
        for(int i=N-1;i>=1;i--) {
            for(int j=i+1;j<N;j++) {
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<j;k++) {
                    int ans = dp[i][k]+dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    mini = Math.min(ans,mini);
                }
                dp[i][j]=mini;
            }
        }

        return dp[1][N-1];
    }
    static int matrixMultiplicationTopDown(int[] arr, int N){
        int i =1;
        int j = N-1;
        int[][] dp = new int[N][N];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        return f(arr,i,j,dp);
    }

    private static int f(int[] arr, int i, int j,int[][] dp) {
        if(i==j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<j;k++) {
            int ans = f(arr,i,k,dp)+f(arr,k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
            mini = Math.min(ans,mini);
        }
        return mini;
    }

    public static void main(String args[]) {
        int arr[] = {10, 20, 30, 40, 50};
        int n = arr.length;
        System.out.println("The minimum number of operations are "+
                matrixMultiplication(arr,n));
    }
}
