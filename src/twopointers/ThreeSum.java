package twopointers;

import java.util.Arrays;

/*
    Given a sorted array and element x, find a triplet such that
    a[i] + a[j] + a[k] = x

    x = 38
    5+10+23

    bruteforce -> iterate 3 loops
    binary search ->   a[k] = x - a[i] - a[j], fix i and j

    two pointers ->   a[i] + a[j]  = x - a[k] , fix k,
    a[i] + a[j]  = updatedSum, using two pointer find given sum approach

    approach:
    fix one element and using two pointers for finding the other two,
    one pointer at the start and another pointer at end

    tc: O(n^2), for each element do two pointers (n * n)
    sc: O(1)
 */
public class ThreeSum {

    public static void main(String[] args) {
                // 0  1  2   3   4   5
        int a[] = {1, 3, 5, 10, 20, 23};

        int x = 38;

        int[] r = bruteForce(a, x);

        for(int i: r) {
            System.out.print(i+" ");
        }

        System.out.println();

        int[] r1 = binarySearch(a, x);

        for(int i: r1) {
            System.out.print(i+" ");
        }

        System.out.println();

        int[] r2 = optimized(a, x);

        for(int i: r2) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n^2)
    private static int[] optimized(int[] a, int x) {
        int n = a.length;
        int[] r = new int[3];

        for(int k=0; k<n; k++) {
            int updatedSum = x - a[k];

            int i = 0;
            int j = a.length-1;

            while(i<j) {
                int sum = a[i] + a[j];

                if(sum == updatedSum) {
                    r[0] = i;
                    r[1] = j;
                    r[2] = k;
                    return r;
                } else if(sum > updatedSum) {
                    j--;
                } else if(sum < updatedSum) {
                    i++;
                }
            }
        }
        return r;
    }

    // tc: O(n^2 logn)
    private static int[] binarySearch(int[] a, int x) {
        int n = a.length;
        int[] r = new int[3];

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int k = x - a[i] - a[j];
                // search for k using binary search
                int kIndex = Arrays.binarySearch(a, k);
                if(kIndex >= 0) {
                    r[0] = i;
                    r[1] = j;
                    r[2] = kIndex;
                    return r;
                }
            }
        }

        return r;
    }

    // tc: O(n^3)
    private static int[] bruteForce(int[] a, int x) {

        int n = a.length;
        int[] r = new int[3];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(a[i] + a[j]+ a[k] == x) {
                        r[0] = i;
                        r[1] = j;
                        r[2] = k;
                        return r;
                    }
                }
            }
        }
        return r;
    }
}
