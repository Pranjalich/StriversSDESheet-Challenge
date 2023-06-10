package ArraysII;

public class FindDuplicate {
    public static void main(String[] args) {
        int arr[] = {1,3,4,2,3};
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }

    private static int findDuplicate(int[] arr) {
        while(arr[0]!=arr[arr[0]]) {
            int tmp = arr[arr[0]];
            arr[arr[0]] = arr[0];
            arr[0] = tmp;
        }
        return arr[0];
    }
}
