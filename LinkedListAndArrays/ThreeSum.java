package LinkedListAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = triplet(n, arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    private static List<List<Integer>> triplet(int n, int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int target = arr[i]+arr[j]+arr[k];
                if(target==0) {
                    List<Integer> output = new ArrayList<>();
                    output.add(arr[i]);
                    output.add(arr[j]);
                    output.add(arr[k]);
                    result.add(output);
                    j++;
                    k--;
                    while(j<n && arr[j]==arr[j-1]) {
                        j++;
                    }
                    while(j<k && arr[k]==arr[k+1]) {
                        k--;
                    }
                } else if(target>0) {
                    k--;
                } else if(target<0) {
                    j++;
                }
            }
        }
        return result;
    }
}
