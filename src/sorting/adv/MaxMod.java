package sorting.adv;

/*
    Given an array A of size N, Groot wants you to pick 2 indices i and j such that

    1 <= i, j <= N
    A[i] % A[j] is maximum among all possible pairs of (i, j).
    Help Groot in finding the maximum value of A[i] % A[j] for some i, j.

    approach:

    anynumber % 10 => result will be in range of 0-9 (0- (mod-1))
    so mod has to be max value in the array, and secondmax is the numerator to have the max mod value

    tc: O(n)
 */
public class MaxMod {
    public static void main(String[] args) {

        int a[] = {1, 2, 44, 3};
        System.out.println(solve(a));

        int b[] = {5, 5, 5, 5};
        System.out.println(solve(b));
    }

    // tc: O(n)
    private static int solve(int[] A) {

        int max = Integer.MIN_VALUE;
        int secondMax = max;

        for(int i=0; i<A.length; i++) {

            if(A[i] > max) {
                secondMax = max;
                max = A[i];
            } else if((A[i] != max) && (A[i] > secondMax)) {
                secondMax = A[i];
            }
        }

        if(secondMax == Integer.MIN_VALUE) {
            return 0;
        }

        return secondMax%max;
    }
}
