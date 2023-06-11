package ArraysIII;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1=0;
        int cnt2=0;
        Integer candidate1=null;
        Integer candidate2=null;
        for(int num: nums) {
            if(candidate1!=null && candidate1==num) {
                cnt1++;
            } else if(candidate2!=null && candidate2==num) {
                cnt2++;
            } else if(cnt1==0) {
                cnt1=1;
                candidate1=num;
            } else if(cnt2==0) {
                cnt2=1;
                candidate2=num;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        int cnt3=0;
        int cnt4=0;
        for(int num: nums) {
            if(num==candidate1) cnt3++;
            else if(num==candidate2) cnt4++;
        }
        List<Integer> result = new ArrayList<>();
        if(cnt3>n/3) result.add(candidate1);
        if(cnt4>n/3) result.add(candidate2);
        return result;
    }
}
