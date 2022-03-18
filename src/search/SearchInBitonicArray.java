package search;

/*
    Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

    NOTE:
    A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

    approach:

    find the peak element,
    search the left side and right side separately
 */
public class SearchInBitonicArray {

    public static void main(String[] args) {
               //  0  1  2  3  4   5  6  7  8
        int[] a = {5, 6, 7, 8, 9, 10, 3, 2, 1};

        System.out.println(solve(a,3));
        System.out.println(solve(a,9));
        System.out.println(solve(a,5));
        System.out.println(solve(a,1));
        System.out.println(solve(a,30));

    }

    // tc: O(logn)
    private static int solve(int[] A, int B) {

        int n = A.length;
        int l = 0;
        int r = n-1;
        int peak = -1;

        while(l<=r) {
            int mid = (l+r)/2;

            if(A[mid] == B) {
                return mid;
            } else if(A[mid] > A[mid+1]) {
                peak = mid;
                r = mid - 1;
            } else if(A[mid] < A[mid+1]) {
                l = mid + 1;
            }
        }

        l = 0;
        r = peak;

        while(l<=r) {
            int mid = (l+r)/2;

            if(A[mid] == B) {
                return mid;
            } else if(A[mid] > B) {
                r = mid - 1;
            } else if(A[mid] < B) {
                l = mid + 1;
            }
        }

        l = peak;
        r = n-1;
        while(l<=r) {
            int mid = (l+r)/2;

            if(A[mid] == B) {
                return mid;
            } else if(A[mid] > B) {
                l = mid + 1;
            } else if(A[mid] < B) {
                r = mid - 1;
            }
        }

        return -1;
    }
}
