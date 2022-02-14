package hashing;

import java.util.HashSet;

/*
    For Given Number A find if its COLORFUL number or not.

    If number A is a COLORFUL number return 1 else return 0.

    What is a COLORFUL Number:

    A number can be broken into different contiguous sub-subsequence parts.
    Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
    And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.

    Explanation 1: input 23
     Possible Sub-sequences: [2, 3, 23] where
     2 -> 2
     3 -> 3
     23 -> 6  (product of digits)
     This number is a COLORFUL number since product of every digit of a sub-sequence are different.

    Explanation 2: input 236
     Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
     2 -> 2
     3 -> 3
     6 -> 6
     23 -> 6  (product of digits)
     36 -> 18  (product of digits)
     236 -> 36  (product of digits)
     This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.

     tc: O(n2), where n is number of digits
     sc: O(n2), worst case set will hold values of all sub arrays, which is n(n+1)/2 -> (n^2)/2 + n/2
 */
public class ColourfulNumber {
    public static void main(String[] args) {

        int a = 236;

        System.out.print(colorful(a));
    }

    // tc: O(n2), where n is number of digits
    // sc: O(n2), worst case set will hold values of all subarrays, which is n(n+1)/2
    public static int colorful(int A) {
        HashSet<Integer> set = new HashSet<>();

        while(A > 0) {
            int a = A;
            int p = 1;
            while(a > 0) {
                int n = a%10;
                p = p * n;

                if(set.contains(p)) {
                    return 0;
                } else {
                    set.add(p);
                }
                a = a/10;
            }
            A = A/10;
        }

        return 1;
    }
}
