package hashing;

import java.util.HashSet;

/*
    Given an 1D integer array A containing N distinct integers.
    Find the number of unique pairs of integers in the array whose XOR is equal to B.

    NOTE: Pair (a, b) and (b, a) is considered to be same and should be counted once.

    approach:

    (3 ^ 6) = 5 and (10 ^ 15) = 5

    can be written as 3 = 5 ^ 6,

    add all elements in set, find k ^ A[j] is present in set,
    in order to avoid repetition, a = k ^ b; remove both a and b from set
    (3 ^ 6) = 5 -> 3 = 5 ^ 6, remove 3 and 6 from set

 */
public class PairWithGivenXor {
    public static void main(String[] args) {

        int[] a = {3, 6, 8, 10, 15, 50};

        System.out.println(bruteForce(a, 5));
    }

    // tc: O(n2) , sc: O(1)
    public int solve(int[] A, int B) {
        int count = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i: A) {
            set.add(i);
        }

        for(int j=0; j<A.length; j++) {
            int r = B ^ A[j];
            if(set.contains(r)) {
                set.remove(r);
                set.remove(A[j]);
                count++;
            }
        }
        return count;
    }

    // tc: O(n2) , sc: O(1)
    private static int bruteForce(int[] A, int B) {
        int count = 0;

        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                if((A[i] ^ A[j]) == B) {
                    count++;
                }
            }
        }
        return count;
    }
}
