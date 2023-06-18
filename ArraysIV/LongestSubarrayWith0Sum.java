package ArraysIV;

import java.util.HashMap;

public class LongestSubarrayWith0Sum {
    public static void main(String[] args) {
        int arr[]={1, 2, -2, 4, -4};
        int ans = maxLen(arr,5);
        System.out.println("ans:  "+ans);
    }
    static int maxLen(int A[], int n)
    {
        HashMap<Integer,Integer> mapOfSumAndIdx = new HashMap<>();
        int maxi = 0;
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum+=A[i];
            if(sum==0) {
                maxi = i+1;
            } else {
                if (mapOfSumAndIdx.containsKey(sum)) {
                    maxi = Math.max(maxi, i - mapOfSumAndIdx.get(sum));
                } else {
                    mapOfSumAndIdx.put(sum,i);
                }
            }
        }
        return maxi;
    }
}
