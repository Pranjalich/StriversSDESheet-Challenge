package LinkedListAndArrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3};
        int k = removeDuplicates(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static int removeDuplicates(int[] arr) {
        if(arr.length==0) return 0;
        int n = arr.length;
        int insertIndex = 1;
        for(int i=1;i<n;i++) {
            if(arr[i]!=arr[i-1]) {
                arr[insertIndex]=arr[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
}
