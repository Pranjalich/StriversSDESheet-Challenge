package ArraysIV;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println("The length of the longest substring without repeating characters is " + solve(str));
    }

    private static int solve(String str) {
        if(str.length()==0)
            return 0;
        int maxAns = Integer.MIN_VALUE;
        Set<Character> visited = new HashSet<>();
        int l=0, r=0;
        int n = str.length();
        while(r<n) {
            if(visited.contains(str.charAt(r))) {
                while(l<r && visited.contains(str.charAt(r))) {
                    visited.remove(str.charAt(l));
                    l++;
                }
            }
            visited.add(str.charAt(r));
            maxAns = Math.max(maxAns,r-l+1);
            r++;
        }
        return maxAns;
    }

}
