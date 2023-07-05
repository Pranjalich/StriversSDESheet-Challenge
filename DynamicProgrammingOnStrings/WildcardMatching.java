package DynamicProgrammingOnStrings;

import java.util.Arrays;

//https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {
    public static void main(String args[]) {

        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (wildcardMatching(S1, S2))
            System.out.println("String S1 and S2 do match");
        else System.out.println("String S1 and S2 do not match");
    }
    static boolean isAllStars(String S1, int i) {

        // S1 is taken in 1-based indexing
        for (int j = 1; j <= i; j++) {
            if (S1.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    static boolean wildcardMatching(String S1, String S2) {

        int n = S1.length();
        int m = S2.length();

        boolean prev[] = new boolean[m + 1];
        boolean cur[] = new boolean[m + 1];

        prev[0] = true;

        for (int i = 1; i <= n; i++) {
            cur[0] = isAllStars(S1, i);
            for (int j = 1; j <= m; j++) {

                if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
                    cur[j] = prev[j - 1];

                else {
                    if (S1.charAt(i - 1) == '*')
                        cur[j] = prev[j] || cur[j - 1];

                    else cur[j] = false;
                }
            }
            prev = (boolean[]) cur.clone();
        }

        return prev[m];

    }
    private static boolean wildcardMatchingBottomUp(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int j=1;j<=m;j++) {
            dp[0][j]=false;
        }
        for(int i=1;i<=n;i++) {
            boolean flag = true;
            for(int i1=1;i1<=i;i1++) {
                if(s1.charAt(i1-1)!='*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0]=flag;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)||s1.charAt(i-1)=='?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    if(s1.charAt(i-1)=='*') {
                        dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
                    } else {
                        dp[i][j]=false;
                    }
                }
            }
        }
        return dp[n][m];
    }
    private static int wildcardMatchingTopDown(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        return wildcardMatchingUtil(n-1,m-1,s1,s2,dp);
    }

    private static int wildcardMatchingUtil(int i, int j, String s1, String s2, int[][] dp) {
        if(i<0 && j<0) return 1;
        if(i<0 && j>=0) return 0;
        if(j<0 && i>=0) {
            for(int i1=0;i1<=i;i1++) {
                if(s1.charAt(i1)!='*') return 0;
            }
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)||s1.charAt(i)=='?') {
            return wildcardMatchingUtil(i-1,j-1,s1,s2,dp);
        } else {
            if(s1.charAt(i)=='*') {
                return (wildcardMatchingUtil(i-1,j,s1,s2,dp)==1 || wildcardMatchingUtil(i,j-1,s1,s2,dp)==1)?1:0;
            } else {
                return 0;
            }
        }
    }

}
