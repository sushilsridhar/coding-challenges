package arrays.numbers;

import java.util.Arrays;

/*
    Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
 */
public class NobleInteger {
    public static void main(String[] args) {

        int[] A = {3, 2, 1, 3};

        int[] B = {-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8,
                0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3,
                -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4,
                -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8,
                -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3,
                -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5,
                -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 };

        System.out.println(solve(B));

        System.out.println(efficient(B));

        System.out.println(simpleSolution(B));
    }

    // Time complexity  - nlogn + n
    private static int simpleSolution(int[] A) {
        int n = A.length;
        int count = 0;

        Arrays.sort(A);

        if(A[n-1] == 0) {
            return 1;
        }

        for(int i=n-2; i>=0; i--) {

            if(A[i] != A[i+1]) {
                count = n-1-i;
            }
            if(count == A[i]) {
                return 1;
            }
        }
        return -1;
    }

    // Time complexity  - nlogn + n
    public static int efficient(int[] A) {

        Arrays.sort(A);

        for(int i=0; i<A.length; i++) {
            while(i+1 < A.length && A[i] == A[i+1]) { // this is important otherwise, code will fail for B array. eg, [9,9,9,9,9,9,9,9,9,9], after 9, 9 9s are there
                i++;
            }
            if(A[i] == A.length-1 -i) {
                return 1;
            }
        }
        return -1;
    }

    // O(n^2)
    public static int solve(int[] A) {

        for(int i=0; i<A.length; i++) {
            int count=0;
            for(int j=0; j<A.length; j++) {
                if(A[j] > A[i]) {
                    count++;
                }
            }
            if(count == A[i]){
                return 1;
            }
        }
        return -1;
    }
}