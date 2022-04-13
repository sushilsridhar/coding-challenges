package sorting.adv;

import java.util.Arrays;

/*
    Given an array of positive integers A, check and return whether the array elements are consecutive or not.
    NOTE: Try this with O(1) extra space.

    tc: O(nlogn)
 */
public class ArrayWithConsecutiveElements {

    public static void main(String[] args) {

        int a[] = {3, 2, 1, 4, 5};

        System.out.println(bruteForce(a));
        System.out.println(sortingSolution(a));
    }

    // tc: O(nlogn)
    private static int sortingSolution(int[] A) {

        Arrays.sort(A);

        for(int i=0; i<A.length-1; i++) {
            if(!(A[i+1] - A[i] == 1)) {
                return 0;
            }
        }

        return 1;
    }

    // tc: O(n^2)
    private static int bruteForce(int[] A) {

        int min = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            if(A[i] < min) {
                min = A[i];
            }
        }

        int count = 0;
        while(count < A.length) {
            boolean minFound = false;
            for(int i=0; i<A.length; i++) {

                if(min == A[i]) {
                    minFound = true;
                    break;
                }
            }

            if(!minFound) {
                return 0;
            }

            count++;
            min++;
        }

        return 1;
    }
}
