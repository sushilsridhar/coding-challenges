package hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
    Given an array count the number of distinct elements

    7, 3, 2, 1, 3, 7, 0 --> 5 distinct elements

    TC: O(n)
    SC: O(n)
 */
public class CountDistinct {

    public static void main(String[] args) {

        int[] a = {7, 3, 2, 1, 3, 7, 0};

        System.out.println(countDistinct(a));

        System.out.println(countDistinctOptimized(a));
    }

    // optimized
    private static int countDistinctOptimized(int[] a) {

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<a.length; i++) {
            set.add(a[i]);
        }
        return set.size();
    }

    private static int countDistinct(int[] a) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            if(freqMap.containsKey(a[i])) {
                freqMap.put(a[i], freqMap.get(a[i])+1);
            } else {
                freqMap.put(a[i], 1);
            }
        }

        return freqMap.size();
    }
}
