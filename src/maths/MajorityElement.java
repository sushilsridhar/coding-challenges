package maths;

import java.util.HashMap;
import java.util.Map;

/*
    MajorityElement

    Given an arr[N], return if there exists a no with frequency > N/2

    [ 1 6 1 1 2 1] --> freq(1) >=4, 1 is the answer

    observations for best solution:
    1. no of majority elements can be at max = 1
    2. if we say we do have majority element
       freq > n/2
       all other elements combined < n/2
       freq of majority elements > all other elements combined
    3. if we delete two distinct elements in array, the majority element won't change


    Assume there is majority
        n:  freq > n/2  , freq >= n/2 + 1 , remove one element while removing distinct element, freq >=n/2

        2 distinct elements removed

        n-2: freq > n/2-2
             freq > n/2 - 1
             freq >= n/2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] a = {2, 1, 6, 1, 1, 2, 1}; // 1

        int[] b = {3, 4, 3, 6, 1, 3, 2, 5, 3, 3, 3}; // 3

        System.out.println(bruteForce(b));
        System.out.println(bestSolution(b));
    }

    // time complexity O(n) , space complexity: O(1)
    private static int bestSolution(int[] a) {

        int ele = a[0];
        int freq = 1;

        // removing two elements if they are distinct

        for(int i=1; i<a.length; i++) {

            if(freq == 0) {
                ele = a[i];
                freq = 1;
            } else if(ele == a[i]) {
                freq++;
            } else {
                freq--;
            }
        }

        int count = 0;
        for(int i=0; i<a.length; i++) {
            if(ele == a[i]) {
                count++;
            }
        }

        if(count>a.length/2) {
            return ele;
        }

        return -1;
    }

    // time complexity: O(n^2), space complexity: O(1)
    private static int bruteForce(int[] a) {
        int maxCount = a.length/2;
        int majEle = 0;

        for(int i=0; i<a.length;i++) {
            int count = 0;
            for(int j=0; j<a.length; j++) {
                if(a[i] == a[j]) {
                    count++;
                }
            }

            if(count > maxCount) {
                majEle = a[i];
            }
        }
        return majEle;
    }

    // using Hashmap, space complexity: O(n)
    private static int usingHashMap(int a[], int size) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n: a) {

            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        Map.Entry<Integer,Integer> result = null;

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {

            if(result == null || entry.getValue() > result.getValue()) {
                result = entry;
            }
        }

        return result.getKey();
    }
}
