package twopointers;

import java.util.Arrays;
import java.util.HashMap;

/*
    Given an array of distinct elements, count the distinct pairs created,

    {8, 12, 16, 4, 0, 20};
    b = 4;

    ans = 5,

    tc: O(n)
    sc: O(1)

    TODO
 */
public class PairWithGivenDifferenceDuplicate {

    public static void main(String[] args) {

        int[] a = {8, 12, 16, 4, 0, 20};
        int b = 4;

        System.out.println(bruteForce(a, b));
        System.out.println(twoPointers(a, b));

    }

    private static int twoPointers(int[] A, int B) {

        int[] a = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        Arrays.sort(a);
        for(int i: a) {
            System.out.print(i+" ");
        }
        return 0;
    }

    private static int bruteForce(int[] A, int B) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                if(Math.abs(A[i]-A[j]) == B) {
                    set.put(Math.min(A[i], A[j]), Math.max(A[i],A[j]));
                }
            }
        }
        return set.size();
    }
}
