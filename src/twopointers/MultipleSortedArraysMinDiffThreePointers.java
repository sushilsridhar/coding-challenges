package twopointers;

/*
    Given three sorted arrays A, B and Cof not necessarily same sizes.
    Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c
    such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |

    A : [ 1, 4, 5, 8, 10 ]
    B : [ 6, 9, 15 ]
    C : [ 2, 3, 6, 6 ]

    We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1

    brute force, try all combinations

    tc: O(n^3)
    sc: O(1)

    three pointers,
    each pointer at start of a array,

    | max(a,b,c) - min(a,b,c) |

    | max(1,6,2) - min(1,6,2) | , max is 6 and min is 1,

    6-1 = 5, to reduce the absolute difference, decrease the max value which is 6, or increase the min value which is 1,
    decreasing max is not possible, so increase the min value,

    find which array contributes to the min value, increase the index of that array

    tc: O(n+m+l), size of all three arrays
    sc: O(1)

 */
public class MultipleSortedArraysMinDiffThreePointers {

    public static void main(String[] args) {
        int a[] = {1, 4, 5, 8, 10};
        int b[] = {6, 9, 15};
        int c[] = {2, 3, 6, 6};

        System.out.println(bruteForce(a,b,c));
        System.out.println(threePointers(a,b,c));

    }

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
