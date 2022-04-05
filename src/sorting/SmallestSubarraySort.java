package sorting;

import java.util.Arrays;

/*
    Given an array of size n, find the smallest subarray, such that if we sort the subarray,
    the complete array is sorted

    TODO solve in O(n)
 */
public class SmallestSubarraySort {

    public static void main(String[] args) {

               //  0  1  2  3  4  5
        int[] a = {1, 3, 4, 2, 5, 6};

        int[] r = bruteForce(a);

        for(int i: r) {
            System.out.print(i+" ");
        }


    }

    // tc: O(nlogn + n) , sc: O(n)
    private static int[] bruteForce(int[] a) {

        int[] b = new int[a.length];

        System.arraycopy(a, 0, b, 0, a.length);

        Arrays.sort(b);

        int startIndex = 0;
        int endIndex = 0;
        boolean startIndexFound = false;

        for(int i=0; i<a.length; i++) {
            if(a[i] != b[i]) {
                if(!startIndexFound) {
                    startIndex = i;
                    startIndexFound = true;
                } else {
                    endIndex = i;
                }
            }
        }

        return new int[]{startIndex, endIndex};
    }
}
