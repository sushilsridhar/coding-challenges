package twopointers;

/*
    You are given 3 sorted arrays A, B and C.
    Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
    Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

     A = [1, 4, 10]
     B = [2, 15, 20]
     C = [10, 12]

    ans = 5, With 10 from A, 15 from B and 10 from C.

    brute force, try all combinations of three arrays

    tc: O(n^3)
    sc: O(1)

    two pointer,
    come up with ideas on analyzing the  max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

    max(a,b,c) - min(a,b,c) is same as max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

    max(1,2,10) - min(1,2,10) = 10-1 = 9 = max(1, 8, 9) = 9

    decrease max , increase min will decrease the overall difference
    max - min = ans,

    max(1,2,10) - min(1,2,10), we can only increase min in this problem, so increase the index of array which contains 1

    to decrease the diff, find and increase the min value,

    increase the array counter by 1 which contributed to min value

    tc: O(n), length of all three arrays
    sc: O(1)

 */
public class MultipleSortedArraysThreePointers {

    public static void main(String[] args) {
        int a[] = {1, 4, 10};
        int b[] = {2, 15, 20};
        int c[] = {10, 12};

        System.out.println(bruteForce(a,b,c));
        System.out.println(threePointers(a,b,c));

    }

    private static int threePointers(final int[] A, final int[] B, final int[] C) {
        int ans = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int k=0;
        int iN = A.length;
        int jN = B.length;
        int kN = C.length;

        while(i<iN && j<jN && k<kN) {
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            int min = Math.min(A[i], Math.min(B[j], C[k]));

            int diff = max-min;

            if(diff < ans) {
                ans = diff;
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

    private static int bruteForce(final int[] A, final int[] B, final int[] C) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                for(int k=0; k<C.length; k++) {
                    int x = Math.abs(A[i]-B[j]);
                    int y = Math.abs(B[j]-C[k]);
                    int z = Math.abs(C[k]-A[i]);

                    int max = Math.max(x, Math.max(y,z));

                    if(max < ans) {
                        ans = max;
                    }
                }
            }
        }

        return ans;
    }
}
