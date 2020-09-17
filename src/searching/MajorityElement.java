package searching;

import java.util.HashMap;
import java.util.Map;

/*
    A majority element in an array A of size N is an element that appears more than N/2 times in the array.
*/
public class MajorityElement {
    public static void main(String[] args) {

        int a[] = {3,1,3,3,2};

        int result = bruteForce(a, a.length);

        System.out.println(result);

        int resultOne = usingHashMap(a, a.length);

        System.out.println(resultOne);

    }

    /* using Hashmap */
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

    private static int bruteForce(int a[], int size) {

        int majorityCount = size/2;

        for(int n: a) {

            int count = 0;

            for(int m: a) {
                if(n == m) {
                   count++;
                }
            }

            if(count > majorityCount) {
                return n;
            }
        }

        return -1;
    }
}
