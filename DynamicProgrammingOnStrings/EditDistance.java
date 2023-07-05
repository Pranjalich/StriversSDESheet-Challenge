package DynamicProgrammingOnStrings;
import java.util.*;
//https://leetcode.com/problems/edit-distance/
public class EditDistance {
    static int editDistance(String S1, String S2){

        int n = S1.length();
        int m = S2.length();

        int[] prev=new int[m+1];
        for(int j=0;j<=m;j++) {
            prev[j] = j;
        }
        for(int i=1;i<=n;i++) {
            int[] curr=new int[m+1];
            curr[0]=i;
            for(int j=1;j<=m;j++) {
                if(S1.charAt(i-1)==S2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                } else {
                    curr[j] = 1+Math.min(prev[j], Math.min(curr[j-1],prev[j-1]));
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    static int editDistanceBottomUp(String S1, String S2){

        int n = S1.length();
        int m = S2.length();

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++) {
            dp[0][j] = j;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(S1.charAt(i-1)==S2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }
    static int editDistanceTopDown(String S1, String S2){

        int n = S1.length();
        int m = S2.length();

        int[][] dp=new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return editDistanceUtil(S1,S2,n-1,m-1,dp);
    }

    private static int editDistanceUtil(String s1, String s2, int i, int j, int[][] dp) {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) {
            dp[i][j] = editDistanceUtil(s1,s2,i-1,j-1,dp);
        } else {
            dp[i][j] = 1+Math.min(editDistanceUtil(s1,s2,i-1,j,dp),
                    Math.min(editDistanceUtil(s1,s2,i,j-1,dp),editDistanceUtil(s1,s2,i-1,j-1,dp)));
        }
        return dp[i][j];
    }
    public static void main(String args[]) {

        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: "+
                editDistance(s1,s2));
    }

}
