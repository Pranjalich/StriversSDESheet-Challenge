package ArraysIV;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 2: [" + ans[0] + ", "
                + ans[1] + "]");
    }

    private static int[] twoSum(int n, int[] arr, int target) {
        int left = 0, right = n-1;
        Arrays.sort(arr);
        while(left<right) {
            int sum = arr[left]+arr[right];
            if(sum==target) return new int[]{left,right};
            if(sum<target) left++;
            else right--;
        }
        return null;
    }
}
