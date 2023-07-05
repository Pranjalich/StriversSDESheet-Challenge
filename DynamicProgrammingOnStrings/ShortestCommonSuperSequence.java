package DynamicProgrammingOnStrings;
//https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/
//https://leetcode.com/problems/shortest-common-supersequence/
public class ShortestCommonSuperSequence {
    public static String shortestSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = 0;
        }
        for(int j=0;j<=m;j++) {
            dp[0][j] = 0;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=n,j=m;
        StringBuilder ans = new StringBuilder();
        while(i>0 && j>0) {
            if(str1.charAt(i-1)==str2.charAt(j-1)) {
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j]>dp[i][j-1]) {
                ans.append(str1.charAt(i-1));
                i--;
            } else {
                ans.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0) {
            ans.append(str1.charAt(i-1));
            i--;
        }
        while(j>0) {
            ans.append(str2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }
    public static void main(String args[]) {

        String s1 = "brute";
        String s2 = "groot";

        System.out.println("The Longest Common Supersequence is "+shortestSupersequence(s1,s2));
    }

}
