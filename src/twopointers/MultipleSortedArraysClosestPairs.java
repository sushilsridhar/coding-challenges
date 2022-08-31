package twopointers;

/*
    Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.
    More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
    If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.
    Return an array with two elements {A[i], B[j]}

     A = [1, 2, 3, 4, 5]
     B = [2, 4, 6, 8]
     C = 9

     There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
     Since we have to return the value with minimum i and then with minimum j. We will return [1, 8]

     brute force,
     find which sum is the closest to the target

     tc: O(n^2)
     sc: O(1)

     two pointers,
     since both arrays are sorted, iterate both array using two pointers,
     one pointer at start of one array, another pointer at end of another array,

     if sum > target , decrease second pointer, else increase first pointer

     tc: O(n+m), size of two arrays
     sc: O(1)
 */
public class MultipleSortedArraysClosestPairs {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {2, 4, 6, 8};
        int c = 9;

        for(int i: bruteForce(a,b,c)) {
            System.out.print(i+" ");
        }

        System.out.println("");

        for(int i: twoPointers(a,b,c)) {
            System.out.print(i+" ");
        }
    }

    private static int[] twoPointers(int[] A, int[] B, int C) {

        int ans = Integer.MAX_VALUE;
        int[] r = new int[2];

        int target = C;
        int i = 0;
        int j = B.length-1;

        int distanceBetweenAnsAndTarget = Math.abs(ans - target);

        while(i<A.length && j>=0) {
            int sum = A[i] + B[j];
            int distanceBetweenSumAndTarget = Math.abs(sum - target);

            if(distanceBetweenSumAndTarget < distanceBetweenAnsAndTarget) {
                distanceBetweenAnsAndTarget = distanceBetweenSumAndTarget;
                r[0] = A[i];
                r[1] = B[j];
            } else if(distanceBetweenSumAndTarget == distanceBetweenAnsAndTarget) {
                if(A[i] <= r[0] && B[j] <= r[1]) {
                    r[0] = A[i];
                    r[1] = B[j];
                }
            }

            if(sum > target) {
                j--;
            } else {
                i++;
            }

        }

        return r;
    }

    private static int[] bruteForce(int[] A, int[] B, int C) {

        int ans = Integer.MAX_VALUE;
        int[] r = new int[2];
        int target = C;

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                int sum = A[i] + B[j];
                int distanceBetweenSumAndTarget = Math.abs(sum - target);
                int distanceBetweenAnsAndTarget = Math.abs(ans - target);

                if(distanceBetweenSumAndTarget < distanceBetweenAnsAndTarget) {
                    ans = sum;
                    r[0] = A[i];
                    r[1] = B[j];

                    if(distanceBetweenSumAndTarget == 0) {
                        return r;
                    }
                }

            }
        }

        return r;
    }
}
