package LinkedListAndArrays;

public class MaxConsecutiveOnes {
    public static void main(String args[]) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0) return 0;
        int maxOnes = 0, currOnes=0;
        int right =0;
        int n = nums.length;
        while(right<n) {
            if(nums[right]==1) {
                currOnes++;
            } else {
                currOnes = 0;
            }
            maxOnes = Math.max(maxOnes,currOnes);
            right++;
        }
        return maxOnes;
    }
}
