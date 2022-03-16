package hashing;

import java.util.HashMap;

/*
    Given an array A of integers and another non negative integer k,
    find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

    A : [1 5 3]
    k : 2

    output: 1

    A[i] - A[j] = k
    A[i] = k + A[j]

    store elements in hashmap, iterate to find if k+A[j] is present in hashmap

    tc: O(n), sc: O(n)
 */
public class DiffkII {

    public static void main(String[] args) {

        int[] a = {1, 5, 3};

        System.out.println(diffPossible(a, 2));
    }

    private static int diffPossible(final int[] A, int B) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<A.length; i++) {
            map.put(A[i], i);
        }

        for(int j=0; j<A.length; j++) {
            int k = B + A[j];

            if((map.containsKey(k)) && (map.get(k) != j)) {
                return 1;
            }
        }

        return 0;
    }
}
