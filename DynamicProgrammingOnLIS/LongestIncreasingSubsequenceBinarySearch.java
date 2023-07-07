package DynamicProgrammingOnLIS;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequenceBinarySearch {
    public static void main(String args[]) {

        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is "+longestIncreasingSubsequence(arr,n));

    }

    private static int longestIncreasingSubsequence(int[] arr, int n) {
        ArrayList<Integer> subList = new ArrayList<>();
        subList.add(arr[0]);
        for(int i=1;i<n;i++) {
            if(arr[i]>subList.get(subList.size()-1)) {
                subList.add(arr[i]);
            } else {
                int j = binarySearch(subList,arr[i]);
                subList.set(j,arr[i]);
            }
        }
        return subList.size();
    }
    private static int binarySearch(ArrayList<Integer> subList, int target) {
        int start = 0, end = subList.size()-1;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(subList.get(mid)==target) return mid;
            else if(subList.get(mid)<target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}
