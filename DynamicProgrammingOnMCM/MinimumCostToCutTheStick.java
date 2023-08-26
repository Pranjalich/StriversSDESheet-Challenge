package DynamicProgrammingOnMCM;

import java.util.Arrays;

//https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/
//https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/
public class MinimumCostToCutTheStick {
    public static void main(String[] args) {
        int[] cuts = {3,5,1,4};
        int c = cuts.length;
        int n = 7;
        System.out.println("The minimum cost to cut the sticks is : "+cutStick(cuts,c,n));
    }
    private static int cutStick(int[] cuts, int c, int n) {
        int[] newCuts = new int[c+2];
        newCuts[0]=0;
        System.arraycopy(cuts,0,newCuts,1,c);
        newCuts[c+1]=n;
        Arrays.sort(newCuts);
        int[][] dp = new int[c+2][c+2];
        for(int i=c;i>=1;i--) {
            for(int j=1;j<=c;j++) {
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++) {
                    int cost = newCuts[j+1]-newCuts[i-1]+dp[i][k-1]+dp[k+1][j];
                    mini = Math.min(cost,mini);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][newCuts.length-2];
    }
    private static int cutStickTopDown(int[] cuts, int c, int n) {
        int[] newCuts = new int[c+2];
        newCuts[0]=0;
        System.arraycopy(cuts,0,newCuts,1,c);
        newCuts[c+1]=n;
        Arrays.sort(newCuts);
        int[][] dp = new int[c+2][c+2];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        return cutStickUtil(newCuts,1,newCuts.length-2,dp);
    }

    private static int cutStickUtil(int[] cuts, int i, int j, int[][] dp) {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++) {
            int cost = cuts[j+1]-cuts[i-1]+cutStickUtil(cuts,i,k-1,dp)+cutStickUtil(cuts,k+1,j,dp);
            mini = Math.min(cost,mini);
        }
        return mini;
    }
}
