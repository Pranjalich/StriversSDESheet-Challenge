package ArraysIII;

public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2,10));
    }

    private static int myPow(int x, int n) {
        long N = n;
        if(N<0) {
            x = 1/x;
            N=-N;
        }
        return fastPow(x,N);
    }

    private static int fastPow(int x, long n) {
        if(n==0) return 1;
        int ans = 1;
        while(n>0) {
            if((n&1)==1) {
                ans = ans*x;
            }
            x=x*x;
            n=n>>1;
        }
        return ans;
    }
}
