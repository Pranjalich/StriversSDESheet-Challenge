package DynamicProgrammingOnStrings;

public class LongestCommonSubstring {
    public static void main(String args[]) {

        String s1= "abcjklp";
        String s2= "acjkp";

        System.out.println("The Length of Longest Common Substring is "+lcs(s1,s2));
    }

    private static int lcsBottomUp(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n;i++) {
            dp[i][0] = 0;
        }
        for(int j=0;j<m;j++) {
            dp[0][j] = 0;
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(s1.charAt(i-1)==s2.charAt(j)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
    private static int lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m+1];
        prev[0] = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<n;i++) {
            int[] curr = new int[m+1];
            for(int j=1;j<m;j++) {
                if(s1.charAt(i-1)==s2.charAt(j)) {
                    curr[j] = 1+prev[j-1];
                    ans = Math.max(ans,curr[j]);
                }
            }
            prev = curr;
        }
        return ans;
    }
}
