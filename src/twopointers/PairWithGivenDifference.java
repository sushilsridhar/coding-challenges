package twopointers;

/*
    Given a sorted array of size n and element k, find a pair i,j such that
    a[j]-a[i] = k

    k and array elements can be +ve, -ve, zero, no extra space allowed in the problem

    0  1  2   3   4   5   6
    1, 3, 5, 10, 20, 23, 30

    increase i, difference decrease  - decrease i, difference increase
    decrease j, difference decrease  - increase j, difference increase

    increase i, difference decrease -
                                       increase j, difference increase

    approach:
    two pointers are the start

    tc: O(n)
    sc: O(1)
 */
public class PairWithGivenDifference {

    public static void main(String[] args) {
                // 0  1  2   3   4   5   6
        int a[] = {1, 3, 5, 10, 20, 23, 30};

        int k = 15;

        int[] r = twoPointers(a, k);

        for(int i: r) {
            System.out.print(i+" ");
        }

        System.out.println("");

        int[] r1 = twoPointers(a, -15);

        for(int i: r1) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n+n) -> O(n)
    private static int[] twoPointers(int[] a, int k) {

        int n = a.length;
        int i = 0;
        int j = 0;
        int[] r = new int[2];

        while(i<n && j<n) {
            int diff = a[j] - a[i];

            if(diff == k) {
                if(i!=j) { // edge case
                    r[0] = i;
                    r[1] = j;
                    return r;
                }
                i++;
            } else if(diff < k) {
                j++;
            } else if(diff > k) {
                i++;
            }
        }

        return r;
    }
}
