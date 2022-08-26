package twopointers;

/*
    TODO
 */
public class MultipleSortedArraysMinDiffThreePointers {

    private static int threePointers(int[] A, int[] B, int[] C) {
        int ans = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = 0;
        int iN = A.length;
        int jN = B.length;
        int kN = C.length;

        while(i<iN && j<jN && k<kN) {
            int max = Math.max(A[i],Math.max(B[j],C[k]));
            int min = Math.min(A[i],Math.min(B[j],C[k]));

            int absDiff = Math.abs(max - min);

            if(absDiff < ans) {
                ans = absDiff;
            }

            if(min == A[i]) {
                i++;
            } else if(min == B[j]) {
                j++;
            } else if(min == C[k]) {
                k++;
            }
        }

        return ans;
    }

    private static int bruteForce(int[] A, int[] B, int[] C) {
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                for(int k=0; k<C.length; k++) {
                    int max = Math.max(A[i],Math.max(B[j],C[k]));
                    int min = Math.min(A[i],Math.min(B[j],C[k]));

                    int absDiff = Math.abs(max - min);

                    if(absDiff < ans) {
                        ans = absDiff;
                    }
                }
            }
        }

        return ans;
    }
}
