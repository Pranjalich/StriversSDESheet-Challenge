package DynamicProgrammingOnStrings;
//https://takeuforward.org/data-structure/minimum-insertions-to-make-string-palindrome-dp-29/
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinInsertionsToMakeStringPalindrome {
    static int longestPalindromeSubsequence(String s){
        String t = s;
        String ss=new StringBuilder(s).reverse().toString();
        return lcs(ss,t);
    }

    private static int lcs(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];
        prev[0]=0;
        for(int i=1;i<=n;i++) {
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    curr[j] = 1+prev[j-1];
                } else {
                    curr[j] = Math.max(curr[j-1],prev[j]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    static int minInsertion(String s){
        int n = s.length();
        int k = longestPalindromeSubsequence(s);
        return n-k;
    }

    public static void main(String args[]) {

        String s= "abcaa";
        System.out.println("The Minimum insertions required to make string palindrome: "+
                minInsertion(s));
    }
}
