package LinkedListII;

import java.util.HashSet;

public class ReverseListOfSizeK {
    public static void main(String[] args) {
        String[] words = {"cd","ac","dc","ca","zz"};
        System.out.println(maximumNumberOfStringPairs(words));
    }
    public static int maximumNumberOfStringPairs(String[] words) {
        int cnt = 0;
        HashSet<String> reverseSet = new HashSet<String>();
        for(String word: words) {
            if(reverseSet.contains(word)) cnt++;
            else {
                StringBuilder r = new StringBuilder(word);
                reverseSet.add(r.reverse().toString());
            }
        }
        return cnt;
    }
}
