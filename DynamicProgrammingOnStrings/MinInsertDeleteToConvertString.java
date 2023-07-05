package DynamicProgrammingOnStrings;
//https://takeuforward.org/data-structure/minimum-insertions-deletions-to-convert-string-dp-30/
public class MinInsertDeleteToConvertString {
    static int canYouMake(String str1, String str2){

        int n = str1.length();
        int m = str2.length();

        int k = lcs(str1,str2);

        return (n-k)+(m-k);
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
    public static void main(String args[]) {

        String str1= "abcd";
        String str2= "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                +canYouMake(str1,str2));
    }

}
