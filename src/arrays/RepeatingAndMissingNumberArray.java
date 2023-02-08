package arrays.numbers;

import java.util.Arrays;

/*
    You are given a read only array of n integers from 1 to n. Each integer appears exactly once except A which appears twice and B which is missing.
    Return A and B.

    Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    Note that in your output A should precede B.
 */
public class RepeatingAndMissingNumberArray {

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 3}; // Output:[3, 4]

        int[] b = repeatedNumber(a);

        for(int i=0;i<b.length; i++) {
            System.out.println(b[i]);
        }
    }

    // time complexity: O(nlogn)
    public static int[] repeatedNumber(final int[] A) {

        int[] r = new int[2];
        int n = A.length;
        Arrays.sort(A); // log n

        long sumOfArrayElements = A[0];

        for(int i=0; i<n-1; i++) {
            if(A[i] == A[i+1]) {
                r[0] = A[i];
            }
            sumOfArrayElements = sumOfArrayElements + A[i+1];
        }

        long sumOfNaturalNumbers = (long) n * (n + 1) /2;
        long sumOfArrayElementsWithoutDuplicate = sumOfArrayElements - r[0];
        r[1] = (int) (sumOfNaturalNumbers - sumOfArrayElementsWithoutDuplicate);

        return r;
    }
}
