package DynamicProgrammingOnSubsequences;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int arr[] ={1,2,3};
        int target=4;

        int n =arr.length;

        System.out.println("The total number of ways is "+countWaysToMakeChange(arr,n,
                target));
    }

    private static int countWaysToMakeChange(int[] arr, int n, int target) {
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        for(int t=0;t<=target;t++) {
            if(t%arr[0]==0)
                prev[t] = t/arr[0];
        }
        for(int i=1;i<n;i++) {
            for(int t=0;t<=target;t++) {
                int notTake = prev[target];
                int take = 0;
                if(arr[i]<=target) {
                    take = curr[target-arr[i]];
                }
                curr[target] = take + notTake;
            }
            prev=curr;
        }
        return prev[target];
    }
}
