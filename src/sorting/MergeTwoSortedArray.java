package sorting;

/*
   Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

   A = [4, 7, 9 ]
   B = [2, 11, 19 ]

   [2, 4, 7, 9, 11, 19]

   each element of two arrays are reached only once

   tc: O(n+m)
   sc: O(n+m)
 */
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] A = {4, 7, 9 };
        int[] B = {2, 11, 19};

        int[] r = solve(A,B);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    private static int[] solve(final int[] A, final int[] B) {

        int aLen = A.length;
        int bLen = B.length;

        int[] r = new int[aLen+bLen];
        int aIndex = 0;
        int bIndex = 0;
        int rIndex = 0;

        while(aIndex < aLen && bIndex < bLen) {

            if(A[aIndex] <= B[bIndex]) {
                r[rIndex] = A[aIndex];
                aIndex++;
            } else {
                r[rIndex] = B[bIndex];
                bIndex++;
            }

            rIndex++;
        }

        while(aIndex < aLen) {
            r[rIndex] = A[aIndex];
            aIndex++;
            rIndex++;
        }

        while(bIndex < bLen) {
            r[rIndex] = B[bIndex];
            bIndex++;
            rIndex++;
        }

        return r;
    }
}
