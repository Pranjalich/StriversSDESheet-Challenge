package ArraysIV;

import java.util.HashMap;

public class SubArraysWithXorK {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysWithXorK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }

    private static int subarraysWithXorK(int[] a, int k) {
        int n = a.length;
        int xor = 0;
        HashMap<Integer,Integer> xorMap = new HashMap<>();
        xorMap.put(xor,1);
        int total = 0;
        for(int i=0;i<n;i++) {
            xor^=a[i];
            int x = xor^k;
            if(xorMap.containsKey(x)) {
                total+=xorMap.get(x);
            }
            if(xorMap.containsKey(xor)) {
                xorMap.put(xor, xorMap.get(xor)+1);
            } else {
                xorMap.put(xor,1);
            }
        }
        return total;
    }
}
