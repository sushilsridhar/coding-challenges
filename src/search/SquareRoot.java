package search;

/*
    Given an integer A.
    Compute and return the square root of A.
    If A is not a perfect square, return floor(sqrt(A)).
    DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.
    NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.

    tc: O(logn)

    int mid = (l+r)/2;
    long square = mid*(long)mid; , long casting is must to avoid overflow
 */
public class SquareRoot {

    public static void main(String[] args) {

        System.out.println(sqrt(11));
        System.out.println(sqrt(9));
    }

    private static int sqrt(int A) {

        if(A == 0 || A == 1) {
            return A;
        }

        int l = 0;
        int r = A/2;
        int ans = 0;

        while(l<=r) {
            int mid = (l+r)/2;
            long square = mid*(long)mid;

            if(square == A) {
                return mid;
            } else if(square > A) {
                r = mid - 1;
            } else if(square < A) {
                ans = mid;
                l = mid + 1;
            }
        }

        return ans;
    }
}
