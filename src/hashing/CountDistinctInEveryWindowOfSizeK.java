package hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
    Given N array elements and a number k, count the number of distinct elements in every window of size k

    6, 3, 7, 3, 8, 6, 9 - array, k = 3
    3 2 3 3 3 - output

    5, 3, 2, 5, 1, 5, 2 - array, k = 3
    3 3 3 2 3

    approach:
    1. push k elements in the frequency map, along with frequency count
    2. for next window, remove the first element/decrement frequency count and add the next element/increment frequency count
    3. return map size
 */
public class CountDistinctInEveryWindowOfSizeK {

    public static void main(String[] args) {

        int[] a = {6, 3, 7, 3, 8, 6, 9};

        int k = 3;

        int[] r = bruteForce(a, k);
        for(int ele: r) {
            System.out.print(ele+" ");
        }
        System.out.println("");

        int[] r1 = bugWithSet(a, k);
        for(int ele: r1) {
            System.out.print(ele+" ");
        }
        System.out.println("");

        int[] r3 = optimized(a, k);
        for(int ele: r3) {
            System.out.print(ele+" ");
        }
    }

    // tc: O(k) + O(n-k)
    // sc: O(k), only k elements will be present in the freq map
    private static int[] optimized(int[] a, int k) {
        if (k == 1) {
            return a;
        }

        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int n = a.length;
        int[] r = new int[n - k + 1];

        for(int i=0; i<k; i++) {   // k iterations
            if(freqMap.containsKey(a[i])) {
                freqMap.put(a[i], freqMap.get(a[i]) + 1);
            } else {
                freqMap.put(a[i], 1);
            }
        }

        r[0] = freqMap.size();

        for (int i = 1; i <= n - k; i++) { //(n-k+1) iterations
            int j = k - 1 + i;

            if(freqMap.containsKey(a[i-1]) && freqMap.get(a[i-1]) == 1) {
                freqMap.remove(a[i-1]);
            } else {
                freqMap.put(a[i-1], freqMap.get(a[i-1]) - 1);
            }

            if(freqMap.containsKey(a[j])) {
                freqMap.put(a[j], freqMap.get(a[j]) + 1);
            } else {
                freqMap.put(a[j], 1);
            }

            r[i] = freqMap.size();
        }
        return r;
    }

    private static int[] bugWithSet(int[] a, int k) {

        if (k == 1) {
            return a;
        }

        HashSet<Integer> set = new HashSet<>();
        int n = a.length;
        int[] r = new int[n - k + 1];

        for (int i = 0; i < k; i++) { // k iterations
            set.add(a[i]);
        }
        r[0] = set.size();

        for (int i = 1; i <= n - k; i++) { //(n-k+1) iterations
            int j = k - 1 + i;

            set.remove(a[i-1]);
            set.add(a[j]);

            r[i] = set.size();
        }
        return r;
    }
    // tc: for every subarray, add all elements to set
    // tc: (n-k+1)*k --> worst case k can be N, ~ O(n2)
    // sc: O(n)
    private static int[] bruteForce(int[] a, int k) {

        if(k == 1) {
            return a;
        }

        HashSet<Integer> set = new HashSet<>();
        int n = a.length;
        int[] r = new int[n-k+1];

        for(int i=0; i<=n-k; i++) { //(n-k+1) iterations
            int j= k-1+i;
            set.clear(); // clears the elements in the set
            for(int x=i; x<=j; x++) { // k iterations
                set.add(a[x]);
            }
            r[i] = set.size();
        }
        return r;
    }
}
