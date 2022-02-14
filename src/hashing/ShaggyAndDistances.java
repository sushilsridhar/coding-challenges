package hashing;

import java.util.HashMap;

/*
    Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array as a special pair
    if elements at that index in the array are equal.
    Shaggy wants you to find a special pair such that distance between that pair is minimum.
    Distance between two indices is defined as |i-j|. If there is no special pair in the array then return -1.

    save the previous occurrence in hashmap, use it to calculate the distance
 */
public class ShaggyAndDistances {
    public static void main(String[] args) {

        int[] a = {7, 1, 3, 4, 1, 7};

        System.out.println(bruteForce(a));
        System.out.println(optimized(a));

    }

    // tc: O(n), sc: O(n)
    private static int optimized(int[] A) {
        int minDistance = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<A.length; i++) {
            if(map.containsKey(A[i])) {
                int previousOccurrance = map.get(A[i]);
                int distance = i-previousOccurrance;
                minDistance = Math.min(minDistance, distance);
            }
            map.put(A[i], i);
        }
        return minDistance == Integer.MAX_VALUE? -1 : minDistance;
    }

    // tc: O(n2), sc: O(1)
    private static int bruteForce(int[] A) {
        int minDistance = Integer.MAX_VALUE;
        int distance = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                if(A[i] == A[j]) {
                    distance = j-i;
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE? -1 : minDistance;
    }
}
