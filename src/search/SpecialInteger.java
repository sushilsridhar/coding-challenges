package search;

/*
    Given an array of integers A and an integer B, find and return the
    maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.

    means, max sum of subarray of length k should be <= B, find the max possible value of k

    approach:

    run binary search on answer possibility, k can be 1 to n, pick k using binary search,
    find the max subarray sum for that k, if <=B, that can be a possible answer, ignore left
    if greater than B, ignore right

    tc: O(nlogn)
 */
public class SpecialInteger {

    public static void main(String[] args) {

        int a[] = { 1, 2, 3, 4, 5};
        System.out.println(solve(a, 10)); // ans = 2
    }

    private static int solve(int[] A, int B) {

        int l = 1;
        int r = A.length;
        int ans = 0;

        while(l<=r) {
            int mid = (l+r)/2;

            if( maxSubArraySum(A, mid) <= B) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private static long maxSubArraySum(int[] a, int k) {
        int n = a.length;
        long sum = 0;

        for(int i=0; i<k; i++) {
            sum = sum + a[i];
        }

        long maxSum = sum;

        for(int i=1; i<=n-k; i++) {
            int j = k-1 + i;

            sum = sum - a[i-1] + a[j];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
