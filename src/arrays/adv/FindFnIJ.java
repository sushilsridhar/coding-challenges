package arrays.adv;

import java.util.HashMap;

/*
    Given an array, find i,j such that A[j]-A[i] = j-i

    approach:
    group the same index on same side,
    A[j]-j = A[i]-i
    rewrite, X[j] = A[j]-j,
    X[j] = X[i]
 */
public class FindFnIJ {

    public static void main(String[] args) {
                 // 0  1  2  3  4  5
        int[] a = { 0, 5, 4, 9, 5, 7}; // ans 2,5

        int[] r1 = bruteForce(a);
        for(int ele: r1) {
            System.out.print(ele+" ");
        }
        System.out.println();

        int[] r = efficient(a);
        for(int ele: r) {
            System.out.print(ele+" ");
        }
    }

    // tc: O(n), sc: O(n)
    private static int[] efficient(int[] a) {

        int[] r = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            int key = a[i]-i;
            if(map.containsKey(key)) {
                r[0] = map.get(key);
                r[1] = i;
                return r;
            } else {
                map.put(key, i);
            }
        }

        return new int[0];
    }

    // tc: O(n2), sc: O(1)
    private static int[] bruteForce(int[] a) {

        int[] r = new int[2];

        for(int i=0; i<a.length; i++) {
           for(int j=i+1; j<a.length; j++) {
               if(a[j]-a[i] == j-i) {
                   r[0] = i;
                   r[1] = j;
                   return r;
               }
           }
        }

        return new int[0];
    }
}
