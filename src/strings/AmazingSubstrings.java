package strings;

import java.util.Collections;
import java.util.HashSet;

/*
    You are given a string S, and you have to find all the amazing substrings of S.

    An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

    Input
    ABEC

    Output
    6

    Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.

    tc: O(n)
 */
public class AmazingSubstrings {

    public static void main(String[] args) {

        String a = "ABEC";
        System.out.println(solve(a));
    }

    private static int solve(String A) {

        HashSet<Character> set = new HashSet<>();
        Collections.addAll(set, 'a','e','i','o','u','A','E','I','O','U');

        int indexOfLastEle = A.length()-1;
        int count = 0;

        for(int i=0; i<A.length(); i++) {

            if(set.contains(A.charAt(i))) {
                int noOfSubstrings = indexOfLastEle - i + 1;
                count = count + noOfSubstrings;
            }
        }

        return count%10003;
    }
}
