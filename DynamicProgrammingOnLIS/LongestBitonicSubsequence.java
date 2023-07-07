package DynamicProgrammingOnLIS;

import java.util.Arrays;

//https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/
public class LongestBitonicSubsequence {
    public static void main(String args[]) {

        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;

        System.out.println("The length of the longest bitonic subsequence is "+longestBitonicSequence(arr,n));

    }

    private static int longestBitonicSequence(int[] arr, int n) {
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        Arrays.fill(dpLeft,1);
        Arrays.fill(dpRight,1);
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i]) {
                    dpLeft[i] = Math.max(dpLeft[i],dpLeft[j]+1);
                }
            }
        }
        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>i;j--) {
                if(arr[j]<arr[i]) {
                    dpRight[i] = Math.max(dpRight[i],dpRight[j]+1);
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            result = Math.max(result,dpLeft[i]+dpRight[i]-1);
        }
        return result;
    }

}
