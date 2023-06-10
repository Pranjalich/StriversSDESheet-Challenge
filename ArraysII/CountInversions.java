package ArraysII;

import java.util.ArrayList;

public class CountInversions {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = numberOfInversions(a, n);
        System.out.println("The number of inversions are: " + cnt);
    }

    private static int numberOfInversions(int[] a, int n) {
        return mergeSort(a,0,n-1);
    }

    private static int mergeSort(int[] a, int low, int high) {
        int cnt=0;
        if(low>=high) return cnt;
        int mid = (low+high)/2;
        cnt+=mergeSort(a,low,mid);
        cnt+=mergeSort(a,mid+1,high);
        cnt+=merge(a,low,mid,high);
        return cnt;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tempArr = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int cnt=0;
        while(left<=mid && right<=high) {
            if(arr[left]<=arr[right]) {
                tempArr.add(arr[left]);
                left++;
            } else {
                tempArr.add(arr[right]);
                cnt+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid) {
            tempArr.add(arr[left]);
            left++;
        }
        while(right<=high) {
            tempArr.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++) {
            arr[i] = tempArr.get(i-low);
        }
        return cnt;
    }
}
