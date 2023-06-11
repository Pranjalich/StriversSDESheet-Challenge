package ArraysIII;

import java.util.ArrayList;

public class ReversePairs {
    public static void main(String[] args) {
        int arr[]={1,3,2,3,1};
        System.out.println("The Total Reverse Pairs are "+reversePairs(arr));
    }

    private static int reversePairs(int[] arr) {
        return mergeSort(arr,0,arr.length-1);
    }

    private static int mergeSort(int[] arr, int low, int high) {
        if(low>=high) return 0;
        int mid = (low+high)/2;
        int inv = mergeSort(arr,low,mid);
        inv+=mergeSort(arr,mid+1,high);
        inv+=merge(arr,low,mid,high);
        return inv;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int cnt=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++) {
            while(j<=high && arr[i]>(2*arr[j])) {
                j++;
            }
            cnt+=(j-(mid+1));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left<=mid && right<=high) {
            if(arr[left]<=arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }
        while(left<=mid) {
            temp.add(arr[left++]);
        }
        while(right<=high) {
            temp.add(arr[right++]);
        }
        for(int i=low;i<=high;i++) {
            arr[i] = temp.get(i-low);
        }
        return cnt;
    }
}
