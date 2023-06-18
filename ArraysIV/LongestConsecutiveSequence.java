package ArraysIV;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int arr[]={100,200,1,2,3,4};
        int lon = longestConsecutive(arr);
        System.out.println("The longest consecutive sequence is " + lon);
    }

    private static int longestConsecutive(int[] arr) {
        HashSet<Integer> visited = new HashSet<>();
        for(int ele: arr) {
            visited.add(ele);
        }
        int result = 0;
        for(int ele: arr) {
            if(!visited.contains(ele-1)) {
                int currNum = ele;
                int currStreak = 1;
                while(visited.contains(currNum+1)) {
                    currNum++;
                    currStreak++;
                    result = Math.max(currStreak,result);
                }
            }
        }
        return result;
    }
}
