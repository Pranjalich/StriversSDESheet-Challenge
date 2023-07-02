package DynamicProgrammingOnSubsequences;
import java.util.*;
//https://leetcode.com/problems/coin-change/
public class MinimumCoins {
    static int minimumElements(int[] arr, int T){
        int n= arr.length;
        int[] prev=new int[T+1];
        int[] curr=new int[T+1];

        for(int t=0;t<=T;t++) {
            if(t%arr[0]==0) {
                prev[t] = t/arr[0];
            } else {
                prev[t] = (int)Math.pow(10,9);
            }
        }
        for(int i=1;i<n;i++) {
            for(int t=0;t<=T;t++) {
                int notTake = prev[t];
                int take = (int)Math.pow(10,9);
                if(arr[i]<=t) {
                    take = 1 + curr[t-arr[i]];
                }
                curr[t] = Math.min(take,notTake);
            }
            prev = curr;
        }
        int ans =  prev[T];
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }
    static int minimumElementsBottomUp(int[] arr, int T){
        int n= arr.length;
        int[][] dp=new int[n][T+1];

        for(int t=0;t<=T;t++) {
            if(t%arr[0]==0) {
                dp[0][t] = t/arr[0];
            } else {
                dp[0][t] = (int)Math.pow(10,9);
            }
        }
        for(int i=1;i<n;i++) {
            for(int t=0;t<=T;t++) {
                int notTake = dp[i-1][t];
                int take = (int)Math.pow(10,9);
                if(arr[i]<=t) {
                    take = 1 + dp[i][t-arr[i]];
                }
                dp[i][t] = Math.min(take,notTake);
            }
        }
        int ans =  dp[n-1][T];
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }
    static int minimumElementsTopBottom(int[] arr, int T){

        int n= arr.length;

        int[][] dp=new int[n][T+1];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        int ans =  minimumElementsUtil(arr, n-1, T, dp);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }
    private static int minimumElementsUtil(int[] arr, int i, int t, int[][] dp) {
        if(i==0) {
            if(t%arr[0]==0) return t/arr[0];
            else return (int)Math.pow(10,9);
        }
        if(dp[i][t]!=-1) return dp[i][t];
        int notTake = minimumElementsUtil(arr,i-1,t,dp);
        int take = (int)Math.pow(10,9);
        if(arr[i]<=t) {
            take = 1 + minimumElementsUtil(arr,i,t-arr[i],dp);
        }
        dp[i][t] = Math.min(take,notTake);
        return dp[i][t];
    }

    public static void main(String args[]) {

        int arr[] ={1,2,3};
        int T=7;

        System.out.println("The minimum number of coins required to form the target sum is: "+minimumElements(arr,T));
    }

}
