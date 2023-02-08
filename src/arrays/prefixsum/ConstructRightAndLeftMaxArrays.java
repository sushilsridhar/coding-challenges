package arrays.prefixsum;

import java.util.Arrays;

/*
    construct left max and right max array

    left max  [2, 6, 6, 6, 8, 8, 8, 8, 8]
    right max [8, 8, 8, 8, 8, 3, 3, 2, 0]

    tc: O(n)
    sc: O(1)
 */
public class ConstructRightAndLeftMaxArrays {
    public static void main(String[] args) {

        int[] arr = {2, 6, 4, 3, 8, -1, 3, 2, 0};

        System.out.println(Arrays.toString(constructLeft(arr)));
        System.out.println(Arrays.toString(constructRight(arr)));
    }

    private static int[] constructLeft(int[] arr) {
        int[] left = new int[arr.length];

        left[0] = arr[0];

        for(int i=1; i<arr.length; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }

        return left;
    }

    private static int[] constructRight(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];

        right[n-1] = arr[n-1];

        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        return right;
    }
}
