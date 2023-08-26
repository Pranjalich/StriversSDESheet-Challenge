package DynamicProgrammingOnMCM;
//https://leetcode.com/problems/burst-balloons/
public class BurstBalloons {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        int ans = maxCoins(arr);
        System.out.println("ans: "+ans);
    }
    private static int maxCoins(int[] arr) {
        int n = arr.length+2;
        int[] newArr = new int[n];
        System.arraycopy(arr,0,newArr,1,n-2);
        newArr[0]=1;
        newArr[n-1]=1;
        int[][] dp = new int[n][n];
        for(int i=n-2;i>=1;i--) {
            for(int j=i;j<=n-2;j++) {
                int mini=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++) {
                    int cost = newArr[i-1]*newArr[k]*newArr[j+1]+dp[i][k-1]+dp[k+1][j];
                    mini=Math.max(mini,cost);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][n-2];
    }
    private static int maxCoinsTopDown(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n+2];
        System.arraycopy(arr,0,newArr,1,n);
        newArr[0]=1;
        newArr[n+1]=1;
        return maxCoinsUtil(newArr,1,n);
    }

    private static int maxCoinsUtil(int[] arr, int i, int j) {
        if(i>j) return 0;
        int mini=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++) {
            int cost = arr[i-1]*arr[k]*arr[j+1]+maxCoinsUtil(arr,i,k-1)+maxCoinsUtil(arr,k+1,j);
            mini=Math.max(mini,cost);
        }
        return mini;
    }
}
