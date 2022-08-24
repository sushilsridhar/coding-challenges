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
 */
public class PairWithGivenDifferenceCount {

    public static void main(String[] args) {

        int[] a = {8, 12, 16, 4, 0, 20};
        int b = 4;

        System.out.println(bruteForce(a, b));
        System.out.println(twoPointers(a, b));

    }

    private static int twoPointers(int[] A, int B) {

        Arrays.sort(A);
        int n = A.length;
        int i=0;
        int j=0;
        int count = 0;

        while(j<n) {
            int diff = A[j] - A[i];

            if(diff == B) {
                count++;
                i++;
                j++;
            } else if(diff < B) {
                j++;
            } else if(diff > B) {
                i++;
            }
        }

        return count;
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
