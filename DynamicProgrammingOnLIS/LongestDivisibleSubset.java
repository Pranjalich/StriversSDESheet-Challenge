package DynamicProgrammingOnLIS;

import java.util.Arrays;

//https://leetcode.com/problems/largest-divisible-subset/
public class LongestDivisibleSubset {
    public static void main(String args[]) {

        int arr[] = {1,16,7,8,4};

        int n = arr.length;

        System.out.println("The longest divisible subset is "+longestDivisibleSubset(arr,n));

    }

    private static String longestDivisibleSubset(int[] arr, int n) {
        int[] dp = new int[n];
        int[] hashIndx = new int[n];
        Arrays.sort(arr);
        Arrays.fill(dp,1);
        Arrays.fill(hashIndx,1);
        for(int i=0;i<n;i++) {
            hashIndx[i]=i;
            for(int j=0;j<i;j++) {
                if(arr[i]%arr[j]==0 && dp[j]+1>dp[i]) {
                    dp[i] = 1+dp[j];
                    hashIndx[i] = j;
                }
            }
        }
        int ans = -1;
        int lastIndx = -1;
        for(int i=0;i<n;i++) {
            if(dp[i]>ans) {
                ans = dp[i];
                lastIndx = i;
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(arr[lastIndx]);
        while(hashIndx[lastIndx]!=lastIndx) {
            lastIndx = hashIndx[lastIndx];
            result.append(arr[lastIndx]+" ");
        }
        return result.reverse().toString();
    }

}
