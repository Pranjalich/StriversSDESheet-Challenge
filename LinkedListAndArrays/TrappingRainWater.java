package LinkedListAndArrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The duplicate element is " + trap(arr));
    }

    private static int trap(int[] arr) {
        int n = arr.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = arr[0];
        for(int i=1;i<n;i++) {
            prefixMax[i] = Math.max(prefixMax[i-1],arr[i]);
        }
        suffixMax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) {
            suffixMax[i] = Math.max(suffixMax[i+1],arr[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            ans+=Math.min(prefixMax[i],suffixMax[i])-arr[i];
        }
        return ans;
    }
}
