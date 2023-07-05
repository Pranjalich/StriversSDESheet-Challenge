package DynamicProgrammingOnSubsequences;
import java.util.*;
//https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/
public class RodCutting {
    static int cutRod(int[] price,int N) {
        int prev[]=new int[N+1];
        for(int i=0;i<N;i++) {
            prev[i] = i*price[0];
        }
        for(int i=1;i<N;i++) {
            for(int length=0;length<=N;length++) {
                int notTake = prev[length];
                int take = Integer.MIN_VALUE;
                int rodLength = i+1;
                if(rodLength<=length) {
                    take = price[i]+prev[length-rodLength];
                }
                prev[length] = Math.max(take,notTake);
            }
        }
        return prev[N];
    }
    static int cutRodBottomUp(int[] price,int N) {
        int dp[][]=new int[N][N+1];
        for(int i=0;i<N;i++) {
            dp[0][i] = i*price[0];
        }
        for(int i=1;i<N;i++) {
            for(int length=0;length<=N;length++) {
                int notTake = dp[i-1][length];
                int take = Integer.MIN_VALUE;
                int rodLength = i+1;
                if(rodLength<=length) {
                    take = price[i]+dp[i][length-rodLength];
                }
                dp[i][length] = Math.max(take,notTake);
            }
        }
        return dp[N-1][N];
    }

    static int cutRodTopDown(int[] price,int N) {
        int dp[][]=new int[N][N+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return cutRodUtil(price,N-1,N,dp);
    }

    private static int cutRodUtil(int[] price, int i, int n, int[][] dp) {
        if(i==0) return n*price[0];
        if(dp[i][n]!=-1) return dp[i][n];
        int notTake = cutRodUtil(price,i-1,n,dp);
        int take = Integer.MIN_VALUE;
        int rodLength = i+1;
        if(rodLength<=n) {
            take = price[i]+cutRodUtil(price,i,n-rodLength,dp);
        }
        dp[i][n] = Math.max(take,notTake);
        return dp[i][n];
    }

    public static void main(String args[]) {

        int price[] = {2,5,7,8,10};

        int n = price.length;

        System.out.println("The Maximum price generated is "+cutRod(price,n));
    }

}
