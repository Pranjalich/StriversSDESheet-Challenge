package DynamicProgrammingOnStrings;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    static String lcs(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = 0;
        }
        for(int j=0;j<=m;j++) {
            dp[0][j] = 0;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i=n,j=m;
        while(i>0 && j>0) {
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j]>dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return ans.reverse().toString();
    }
    static int lcsTopBottom(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n][m];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);
        return lcsUtil(s1,s2,n-1,m-1,dp);
    }

    private static int lcsUtil(String s1, String s2, int i, int j, int[][] dp) {
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) dp[i][j] = 1+lcsUtil(s1,s2,i-1,j-1,dp);
        else {
            dp[i][j] = Math.max(lcsUtil(s1,s2,i-1,j,dp),lcsUtil(s1,s2,i,j-1,dp));
        }
        return dp[i][j];
    }

    public static void main(String args[]) {

        String s1= "abcde";
        String s2= "bdgek";

        System.out.println("The Longest Common Subsequence is "+lcs(s1,s2));
    }
}
