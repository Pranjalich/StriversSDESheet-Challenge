package DynamicProgramming1D;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/house-robber-ii/
public class HouseRobberII {
    public static void main(String args[]) {

        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(6);
        int n=arr.size();
        System.out.println(robStreet(n,arr));

    }
    static long robStreet(int n, ArrayList<Integer> arr) {
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        if(n==1)
            return arr.get(0);

        for(int i=0; i<n; i++){

            if(i!=0) arr1.add(arr.get(i));
            if(i!=n-1) arr2.add(arr.get(i));
        }

        long ans1 = solve(arr1);
        long ans2 = solve(arr2);

        return Math.max(ans1,ans2);

    }

    private static long solve(ArrayList<Integer> arr) {
        int n = arr.size();
        int prev = arr.get(0);
        int prev2 = 0;
        for(int i=1;i<n;i++) {
            int take = 0;
            if(i>1) {
                take = arr.get(i) + prev2;
            }
            int notTake = prev;
            int curr = Math.max(take,notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    private static long solveBottomUp(ArrayList<Integer> arr) {
        int n = arr.size();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = arr.get(0);
        for(int i=1;i<n;i++) {
            int take = 0;
            if(i>1) {
                take = arr.get(i) + dp[i-2];
            }
            int notTake = dp[i-1];
            dp[i] = Math.max(take,notTake);
        }
        return dp[n-1];
    }
}
