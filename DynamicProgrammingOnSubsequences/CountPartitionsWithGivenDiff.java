package DynamicProgrammingOnSubsequences;
import java.util.*;
//https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/
public class CountPartitionsWithGivenDiff {
    static int mod =(int)(Math.pow(10,9)+7);
    static int countPartitions(int d,int[] arr){
        int n = arr.length;
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;

        int s2 = (totSum-d)/2;

        int dp[][] = new int[n][s2+1];
        if(arr[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if(arr[0]!=0 && arr[0]<=s2) dp[0][arr[0]] = 1;  // 1 case -pick

        for(int i=1;i<n;i++) {
            for(int target=0;target<=s2;target++) {
                int notTaken = dp[i-1][target];
                int take = 0;
                if(arr[i]<=target) {
                    take = dp[i-1][target-arr[i]];
                }
                dp[i][target] = (take + notTaken)%mod;
            }
        }
        return dp[n-1][s2];
    }

    static int countPartitionsTopBottom(int d,int[] arr){
        int n = arr.length;
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;

        int s2 = (totSum-d)/2;

        int dp[][] = new int[n][s2+1];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        return countPartitionsUtil(n-1,s2,arr,dp);
    }
    private static int countPartitionsUtil(int i, int target, int[] arr, int[][] dp) {
        if(i==0) {
            if(target==0 && arr[0]==0) {
                return 2;
            }
            if(target==0 || arr[0]==target) {
                return 1;
            }
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int notTaken = countPartitionsUtil(i-1,target,arr,dp);
        int take = 0;
        if(target>=arr[i]) {
            take = countPartitionsUtil(i-1,target-arr[i],arr,dp);
        }
        dp[i][target] = (take + notTaken)%mod;
        return dp[i][target];
    }

    public static void main(String args[]) {

        int arr[] = {5,2,6,4};
        int d=3;

        System.out.println("The number of subsets found are "+countPartitions(d,arr));
    }

}
