package hashing;

import java.util.HashSet;

/*
    Given an array check if there exists a subarray with sum 0

    output: 2 1 -3  returns true

    0  1  2   3  4  5   6   7   8  - index
    2, 2, 1, -3, 4, 3,  1, -2, -3  - array

    2, 4, 5,  2, 6, 9, 10,  8,  5 - prefix array

    sum of element upto j - sum of elements upto i + array[i]
    i=1, j=3
    2 - (4) + 2 --> -2 + 2 = 0

    OR

    sum of element upto j - sum of elements upto i-1
    i=1, j=3
    2-2 = 0, but i value can't be zero


    sum(i,j) = pf[j] - pf[i-1], if sum is zero then,
    pf[j] - pf[i-1] = 0, --> pf[j] = pf[i-1]

    sum of all elements upto i-1 and sum of all elements upto j,
    if both are equal, in between elements from (i to j)  does not contribute anything

    sum of element upto j - sum of elements upto i-1
    i=1, j=3
    sum of all elements upto i-1  --> 2
    sum of all elements upto j    --> 2
    element inbetween i-1 and j --> 2 + 1 -3 = 0


    2, 4, 5,  2, 6, 9, 10,  8,  5 - prefix array
    if prefix array has duplicate value, that means, some subarray has contributed to sum 0

    eg:
    [ 1, 2, 0, 8] - array
    [ 1, 3, 3, 11] - pf sum , contains duplicate, check if original array contains zero, and return true, because
    one element is also subarray

    eg: edge case
    [ 3, -1, -2, 4] - array
    [ 3,  2,  0, 4] - prefix array, no duplicates, so check if prefix array contains zero and return true

    eg: edge case
    [ 0, 3, 2, 8] - array ,check if a[i] == 0
    [ 0, 3, 5, 13] - pf sum

    approach:
    1. build the prefix sum array
    2. check for duplicates in the prefix sum array

    use long for overflow, while adding numbers for prefix array calculation
 */
public class SubarrayWithSumZero {

    public static void main(String[] args) {

        int[] a = {2, 2, 1, -3, 4, 3,  1, -2, -3};

        System.out.println(bruteForce(a));
        System.out.println(usingPrefixSum(a));
        System.out.println("optimized: "+optimized(a));

        System.out.println("best solution of all: "+ bestSolution(a));
    }

    // tc: O(n), sc: O(n)
    public static int bestSolution(int[] A) {
        HashSet<Long> set = new HashSet<>();

        long prefixSumOfIminusOne = A[0]; // use long, overflow issue
        if(prefixSumOfIminusOne == 0) {
            return 1;
        }
        set.add(prefixSumOfIminusOne);

        for(int i=1; i<A.length; i++) {
            long prefixSumOfI = prefixSumOfIminusOne + A[i];

            if(prefixSumOfI == 0 || A[i] == 0) {
                return 1;
            }

            if(set.contains(prefixSumOfI)) {
                return 1;
            } else {
                set.add(prefixSumOfI);
            }
            prefixSumOfIminusOne = prefixSumOfI;
        }

        return 0;
    }

    // tc: O(n), sc: O(n+n)
    private static boolean optimized(int[] a) {

        int[] pf = new int[a.length];
        pf[0] = a[0];
        if(a[0] == 0) {
            return true;
        }
        for(int i=1; i<a.length; i++) {
            pf[i] = pf[i-1] + a[i];

            if(pf[i] == 0) { // edge case, check above comments
                return true;
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<a.length; i++) {
            if(set.contains(pf[i])) {
                return true;
            } else {
                set.add(pf[i]);
            }
        }

        return false;
    }

    // tc: O(n2), sc: O(n)
    private static boolean usingPrefixSum(int[] a) {

        int[] pf = new int[a.length];
        pf[0] = a[0];
        for(int i=1; i<a.length; i++) {
            pf[i] = pf[i-1] + a[i];
        }

        for(int i=0; i<a.length; i++) {
            int sum = 0;
            for(int j=i; j<a.length; j++) {
               sum = pf[j] - pf[i] + a[i];

                if(sum == 0) {
                    System.out.println(i+" "+j);
                    return true;
                }
            }
        }
        return false;
    }

    // tc: O(n2), sc: O(1)
    private static boolean bruteForce(int[] a) {

        for(int i=0; i<a.length; i++) {
            int sum = 0;
            for(int j=i; j<a.length; j++) {
                sum = sum + a[j];

                if(sum == 0) {
                    System.out.println(i+" "+j);
                    return true;
                }
            }
        }
        return false;
    }
}
