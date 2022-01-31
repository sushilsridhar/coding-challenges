package hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
    Given an array of size n, check if there exists a pair, a[i] + a[j] = k & i!=j

    a[j] = k - a[i]

    approach:
    1. put all elements in map
    2. we have one element a[i], search for the another element inside the map

    int[] a = {2, 3, 5};  k = 4; --> map.get(key) != i , because same index should be used (i!=j)

    approach:
    1. put all elements in set
    2. we have one element a[i], search for the another element inside the set, if found return true
 */
public class TwoSumProblem {

    public static void main(String[] args) {

        int[] a = {2, 6, 8, 7};
        //int[] a = {2, 3, 5};

        int k = 14;

        System.out.println(bruteForce(a, k));
        System.out.println(betterBruteForce(a, k));

        System.out.println(optimized(a, k));
        System.out.println(optimizedUsingSet(a, k));

    }

    private static boolean optimizedUsingSet(int[] a, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<a.length; i++) {
            int key = k - a[i];      // key should not be a[i] so that this condition is satisfied (i!=j)
            if(set.contains(key)) {
                return true;
            } else {
                set.add(a[i]);
            }
        }
        return false;
    }

    private static boolean optimized(int[] a, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            map.put(a[i], i);
        }

        for(int i=0; i<a.length; i++) {
            int key = k - a[i];
            if(map.containsKey(key) && map.get(key) != i) {
                return true;
            }
        }
        return false;
    }

    // tc: O(n2)
    private static boolean betterBruteForce(int[] a, int k) {

        for(int i=0; i<a.length; i++) {
            for(int j=i+1; j<a.length; j++) {
                if(a[i] + a[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // tc: O(n2)
    private static boolean bruteForce(int[] a, int k) {

        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a.length; j++) {
                if(i!=j && a[i] + a[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
