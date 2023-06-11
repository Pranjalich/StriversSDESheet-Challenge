package ArraysIII;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);
    }

    private static int majorityElement(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int element = 0;
        for(int i=0;i<n;i++) {
            if(cnt==0) {
                cnt++;
                element = arr[i];
            } else if(element==arr[i]) cnt++;
            else cnt--;
        }
        int cnt1=0;
        for(int i=0;i<n;i++) {
            if(arr[i]==element) cnt1++;
        }
        if(cnt1>(n/2)) return element;
        return -1;
    }
}
