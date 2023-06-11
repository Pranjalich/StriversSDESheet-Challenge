package ArraysI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static void main(String args[]) {
        List<Integer> A = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
        List<Integer> ans = nextGreaterPermutation(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");

    }

    private static List<Integer> nextGreaterPermutation(List<Integer> a) {
        int n = a.size();
        int idx = -1;
        // Step 1: Find the break point:
        for(int i=n-2;i>=0;i--) {
            if(a.get(i)<a.get(i+1)) {
                // index i is the break point
                idx=i;
                break;
            }
        }
        // If break point does not exist:
        if(idx==-1) {
            // reverse the whole array:
            Collections.reverse(a);
            return a;
        }
        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for(int i=n-1;i>idx;i--) {
            if(a.get(i)>a.get(idx)) {
                int tmp = a.get(i);
                a.set(i,a.get(i));
                a.set(idx,tmp);
                break;
            }
        }
        // Step 3: reverse the right half:

        List<Integer> subList = a.subList(idx+1,n);
        Collections.reverse(subList);
        return a;
    }
}
