package search;

/*
    Given a sorted array of integers A of size N and an integer B.
    array A is rotated at some pivot unknown to you beforehand.
    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
    You are given a target value B to search. If found in the array, return its index otherwise, return -1.
    You may assume no duplicate exists in the array.

    NOTE: Users are expected to solve this in O(log(N)) time.
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
            //      0  1  2  3  4  5  6  7
        int a[] = { 4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(search(a, 3));

        System.out.println(efficient(a, 3));

    }

    // tc: O(logn)
    private static int efficient(final int[] A, int B) {
        int ans = -1;
        int k = findRotatedIndexVal(A);
        int n = A.length-1;

        if(k != 0) {
            if(B >= A[0]) {
                ans = binarySearch(A, 0, k, B);
            } else {
                ans = binarySearch(A, k+1, n, B);
            }
        } else {
            ans = binarySearch(A, 0, n, B);
        }

        return ans;
    }

    private static int findRotatedIndexVal(int[] a) {
        int k = 0;
        int l = 0;
        int n = a.length-1;
        int r = n;

        while(l<=r) {
            int mid = (l+r)/2;

            if(a[mid] > a[0]) {
                k = mid;
                l = mid + 1;
            } else if(a[mid] < a[0]) {
                r = mid - 1;
            }
        }

        if(k == n) {
            return 0;
        }

        return k;
    }

    // tc: O(nlogn)
    private static int search(final int[] A, int B) {

        int k = 0;
        for(int i=0; i<A.length-1; i++) {
            if(A[i] > A[i+1]) {
                k = i;
                break;
            }
        }

        int ans = -1;

        if(k != 0) {
            if(B >= A[0]) {
                int l = 0;
                int r = k;
                ans = binarySearch(A, l, r, B);
            } else {
                int l = k+1;
                int r = A.length-1;
                ans = binarySearch(A, l, r, B);
            }
        } else {
            int l = 0;
            int r = A.length-1;
            ans = binarySearch(A, l, r, B);
        }

        return ans;
    }

    private static int binarySearch(int[] a, int l, int r, int val) {

        while(l<=r) {
            int mid = (l+r)/2;

            if(a[mid] == val) {
                return mid;
            } else if(a[mid] > val) {
                r = mid - 1;
            } else if(a[mid] < val) {
                l = mid + 1;
            }
        }

        return -1;
    }
}
