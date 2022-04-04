package strings;

/*
    Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order.
    The order of the alphabet is some permutation of lowercase letters.

    Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26,
    return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.

    A = ["hello", "scaler", "interviewbit"]
    B = "adhbcfegskjlponmirqtxwuvzy"

    h < s < i --> return 1;

    A = ["fine", "none", "no"]
    B = "qwertyuiopasdfghjklzxcvbnm"

    f < no < no

    none > no --> return 0, size of second word must be less than third, to be lexicographically sorted

    String B = "adhbcfegskjlponmirqtxwuvzy";
    a - 1 position
    b
    c
    d - 2 position, assigning position as per String B

    abcd abdc , c<d, break, ignore rest of characters

    tc: O(n * k), where n is array length, and k is length of the word
 */
public class IsValidDictionary {
    public static void main(String[] args) {

        String[] A = {"hello", "scaler", "interviewbit"};
        String B = "adhbcfegskjlponmirqtxwuvzy";

        System.out.println(solve(A,B));
    }

    private static int solve(String[] A, String B) {

        int[] pos = new int[26];
        for(int i=0; i<26; i++) {
            pos[B.charAt(i) - 'a'] = i;
        }

        for(int i=0; i<A.length-1; i++) {
            String s1 = A[i];
            String s2 = A[i+1];

            for(int j=0; (j<s1.length()) && (j<s2.length()); j++) {
                char s1Char = s1.charAt(j);
                char s2Char = s2.charAt(j);

                if(s1Char == s2Char) {
                    continue;
                } else {
                    int s1CharPos = pos[s1Char - 'a'];
                    int s2CharPos = pos[s2Char - 'a'];

                    if(s1CharPos > s2CharPos) {
                        return 0;
                    } else {
                        break;
                    }
                }
            }

            if(s1.length() > s2.length()) {
                return 0;
            }
        }

        return 1;
    }
}
