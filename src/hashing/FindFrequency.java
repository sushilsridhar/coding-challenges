package hashing;

import java.util.HashMap;

/*
    Given an array of size N and q queries, for every query, an integer x is given, return the frequency of x in the array

    Time complexity: O(n)
    Space complexity: O(n)
 */
public class FindFrequency {

    public static void main(String[] args) {

        int[] a = {2, 6, 3, 8, 2, 8, 2, 3, 8};

        int query = 8;
        System.out.println(findFreq(a, query));
    }

    private static int findFreq(int[] a, int q) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            if(map.containsKey(a[i])) {           // O(1)
                map.put(a[i], map.get(a[i])+1);   // O(1)
            } else {
                map.put(a[i], 1);                 // O(1)
            }
        }

        return map.get(q);
    }
}
