package hashing;

import java.util.HashMap;

/*
    Given an array, find the first non repeating element in the array

    a = 8, 2, 8, 3, 1, 2, 6, 5

    1. build freq map
    2. iterate over the array and find the first element with freq one

    TC: O(n)
    SC: O(n)
 */
public class FindFirstNonRepeating {

    public static void main(String[] args) {

        int a[] = {8, 2, 8, 3, 1, 2, 6, 5};

        System.out.println(solve(a));
    }

    private static int solve(int[] a) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            if(map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i])+1);
            } else {
                map.put(a[i], 1);
            }
        }

        for(int i=0; i<a.length; i++) {
            if(map.get(a[i]) == 1) {
                return a[i];
            }
        }

        return 0;
    }
}
