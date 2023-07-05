package DynamicProgrammingOnStrings;
import java.util.*;
//https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
    static int subsequenceCounting(String t, String s, int lt, int ls) {
        int prev[]=new int[ls+1];
        prev[0] = 1;

        for(int i=1;i<=lt;i++) {
            for(int j=ls;j>=1;j--) {
                if(t.charAt(i-1)==s.charAt(j-1)) {
                    prev[j] = prev[j-1]+prev[j];
                }
            }
        }
        return prev[ls];
    }
    static int subsequenceCountingBottomUp(String t, String s, int lt, int ls) {
        int dp[][]=new int[lt+1][ls+1];
        for(int i=0;i<=lt;i++) {
            dp[i][0] = 1;
        }
        for(int j=1;j<=ls;j++) {
            dp[0][j] = 0;
        }
        for(int i=1;i<=lt;i++) {
            for(int j=1;j<=ls;j++) {
                if(t.charAt(i-1)==s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[lt][ls];
    }
    static int subsequenceCountingTopDown(String t, String s, int lt, int ls) {
        // Write your code here.

        int dp[][]=new int[lt][ls];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);
        return countUtil(t,s,lt-1,ls-1,dp);
    }

    private static int countUtil(String t, String s, int i, int j, int[][] dp) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(t.charAt(i)==s.charAt(j)) {
            dp[i][j] = countUtil(t,s,i-1,j-1,dp)+countUtil(t,s,i-1,j,dp);
        } else {
            dp[i][j] = countUtil(t,s,i-1,j,dp);
        }
        return dp[i][j];
    }

    public static void main(String args[]) {

        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("The Count of Distinct Subsequences is "+
                subsequenceCounting(s1,s2,s1.length(),s2.length()));
    }
}
