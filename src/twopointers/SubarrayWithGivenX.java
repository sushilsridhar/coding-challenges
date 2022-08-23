package twopointers;

/*
    Given an array of +ve elements, find a subarray a[i to j]
    such that,  sum of elements from i to j = x

    0  1   2   3   4   5  6
    1, 3, 15, 10, 20, 23, 3

    i = 1, j = 4 -> 3 + 15 + 10 + 20 -> ans 48

    increase i, sum decrease -
                                      increase j, sum increase

    approach:
    two pointers at the start

    only works with array of positive elements,

    tc: O(n)
    sc: O(1)
 */
public class SubarrayWithGivenX {

    public static void main(String[] args) {
                // 0  1   2   3   4   5  6
        int a[] = {1, 3, 15, 10, 20, 23, 3};

        int x = 48;

        int[] r = optimized(a, x);

        for(int i: r) {
            System.out.print(i+" ");
        }

        System.out.println();

        int[] r1 = prefixSum(a, x);

        for(int i: r1) {
            System.out.print(i+" ");
        }

        System.out.println();

        int[] r2 = bruteForce(a, x);

        for(int i: r2) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n)
    private static int[] optimized(int[] A, int B) {
        int n = A.length;
        int i = 0;
        int j = 0;
        int sum = A[0];

        while(i<n && j<n) {

            if(sum == B) {
                break;
            } else if(sum > B) {
                sum = sum - A[i];
                i++;
            } else if(sum < B) {
                j++;

                if(j<n) { // overflow issue
                    sum = sum + A[j];
                }
            }
        }

        if(i==n || j==n) {
            return new int[]{-1};
        }

        int[] r = new int[j-i+1];
        int index = 0;
        for(int k=i; k<=j; k++) { // return the subarray itself
            r[index] = A[k];
            index++;
        }

        return r;
    }

    private static int[] prefixSum(int[] a, int x) {
        int n = a.length;
        int[] r = new int[2];

        int[] pf = new int[n+1];
        pf[0] = 0;

        for(int i=1; i<=n; i++) {
            pf[i] = pf[i-1] + a[i];
        }

        for(int i=0; i<n; i++) {
            // TODO
        }
        return new int[]{1};
    }

    // tc: O(n^2)
    private static int[] bruteForce(int[] a, int x) {
        int n = a.length;
        int[] r = new int[2];

        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {

                sum = sum + a[j]; // carry forward technique

                if(sum == x) {
                    r[0] = i;
                    r[1] = j;
                    return r;
                }
            }
        }
        return r;
    }
}
