package search;

/*
    Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
    For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
    NOTE: Users are expected to solve this in O(log(N)) time.

    approach:


          100
       17     11
     5          10
                 9
                  8

    if ele is greater than the element to its right, that can be a peak element, track it,
    and ignore all elements to its right since it is smaller elements

    if ele is less than the element to its right, then peak element is on the right side,
    ignore all the elements on the left side, since they are smaller elements

    edge case, a[] = { 1,2,3,4,5}, (mid+1 == n), then mid is the peak, and mid+1 will cause overflow

    tc: O(logn), sc: O(1)
 */
public class FindPeakElement {

    public static void main(String[] args) {

        int a[] = {5, 17, 100, 11, 10, 9, 8};
        System.out.println(findPeak(a));
    }

    private static int findPeak(int[] A) {

        int l = 0;
        int n = A.length;
        int r = n-1;
        int peak = 0;

        while(l<=r) {
            int mid = (l+r)/2;

            if((mid+1 == n) || (A[mid] >= A[mid+1])) {
                peak = A[mid];
                r = mid - 1;
            } else if(A[mid] < A[mid+1]) {
                l = mid + 1;
            }
        }
        return peak;
    }

    // another solution
    public int solve(int[] A) {
        // Try to think when will the unique answer exists,
        //Unique answer only exists when the elements first increases and then decreases.
        // Check is first or last element is the answer.
        int n = A.length;
        //base cases
        if (n == 1)
            return A[0];
        if (A[1] <= A[0])
            return A[0];
        if (A[n - 1] >= A[n - 2])
            return A[n - 1];
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1])
                return A[mid];
            else if (A[mid] >= A[mid - 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
