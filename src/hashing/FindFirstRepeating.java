package hashing;

import java.util.HashMap;

/*
    Given an integer array A of size N, find the first repeating element in it.
    We need to find the element that occurs more than once and whose index of first occurrence is smallest.
    If there is no repeating element, return -1.

    tc: O(n)
    sc: O(n)
 */
public class FindFirstRepeating {

    public static void main(String[] args) {

        int a[] = {10, 5, 3, 4, 3, 5, 6};

        System.out.println(solve(a));
    }

    public static int solve(int[] A) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele: A) {
            if(map.containsKey(ele)) {
                map.put(ele, map.get(ele)+1);
            } else {
                map.put(ele, 1);
            }
        }

        for(int ele: A) {
            if(map.get(ele) > 1) {
                return ele;
            }
        }

        return -1;
    }
}
