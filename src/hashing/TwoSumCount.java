package hashing;

import java.util.HashMap;

/*
     Given an array of size n,

     1. count the number of pairs such that, a[i] + a[j] = k & i!=j
     2. count the number of pairs such that, a[i] - a[j] = k & i!=j

     2, 6, 8, 7, 6, 7, 8 -> k = 14
     8,6 6,8 7,7 8,6 8,6 --> total pairs 5

     1. iterate over the array, check for map if k - a[i] is present in the map
     2. if present, get its freq and add to count
     3. if not present, add a[i] to map, with its freq
 */
public class TwoSumCount {
    public static void main(String[] args) {
        int[] a = { 2, 6, 8, 7, 6, 7, 8};
        int k = 14;

        System.out.println(returnCount(a, k));
    }

    // tc: O(n), sc: O(n)
    private static int returnCount(int[] a, int k) {

        int c = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            int ele = k - a[i];

            if(map.containsKey(ele)) {
                c = c + map.get(ele);
            }

            if(map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i])+1);
            } else {
                map.put(a[i], 1);
            }
        }

        return c;
    }
}
