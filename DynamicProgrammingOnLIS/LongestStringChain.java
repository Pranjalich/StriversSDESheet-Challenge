package DynamicProgrammingOnLIS;

import java.util.Arrays;

//https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {
    public static int longestStrChain(String[] words) {
        Arrays.sort(words,(a, b)->a.length()-b.length());
        int n = words.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(checkPossible(words[i],words[j]) && 1+dp[j]>dp[i]) {
                    dp[i]=1+dp[j];
                }
            }
            if(dp[i]>maxi) {
                maxi=dp[i];
            }
        }
        return maxi;
    }
    private static boolean checkPossible(String s1, String s2) {
        if(s1.length()!=s2.length()+1) {
            return false;
        }
        int first=0, second=0;
        while(first<s1.length()) {
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        if(first==s1.length() && second==s2.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println("The longest possible word chain is: "+longestStrChain(words));
    }
}
