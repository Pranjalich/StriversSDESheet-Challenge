package ArraysI;

import java.util.ArrayList;
import java.util.Arrays;

public class SortColors {
    public static void main(String args[]) {
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        sortArray(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

    }

    private static void sortArray(ArrayList<Integer> arr, int n) {
        int low=0,mid=0;
        int high = n-1;
        while(mid<=high) {
            if(arr.get(mid)==0) {
                //swap nums[low] and nums[mid]
                int temp = arr.get(low);
                arr.set(low,arr.get(mid));
                arr.set(mid,temp);
                low++;
                mid++;
            } else if(arr.get(mid)==1) {
                mid++;
            } else {
                //swap nums[mid] and nums[high]
                int temp = arr.get(mid);
                arr.set(mid,arr.get(high));
                arr.set(high,temp);
                high--;
            }
        }
    }
}
