package DynamicProgrammingOnStrings;
//https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/
public class LongestPalindromicSubsequence {
    static int longestPalindromeSubsequence(String s){
        String t = s;
        String ss=new StringBuilder(s).reverse().toString();
        return lcs(ss,t);
    }
    private static int lcs(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];
        prev[0] = 0;

        for(int i=1;i<=n;i++) {
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    curr[j] = 1+prev[j-1];
                }else {
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
    private static int lcsBottomUp(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n;i++) {
            dp[i][0] = 0;
        }
        for(int j=0;j<m;j++) {
            dp[0][j] = 0;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String args[]) {

        String s= "bbabcbcab";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindromeSubsequence(s));
    }

}
