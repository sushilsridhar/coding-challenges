package search;

/*
    Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
    If not, return the index where it would be if it were inserted in order.

    NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.

    approach:

    track the element that is lesser than k, index k should be inserted is indexOfSmallerElementThanB + 1

    indexOfSmallerElementThanB is initialized as -1, to handle k = -4

    tc: O(logn), sc: O(1)
 */
public class FindInsertPosition {

    public static void main(String[] args) {
        //           0  1  2  3  4   5   6   7   8
        int a[] = { -5, 2, 3, 6, 9, 10, 11, 14, 18};

        System.out.println(searchInsert(a, 3));
        System.out.println(searchInsert(a, 1));
        System.out.println(searchInsert(a, 19));
        System.out.println(searchInsert(a, -4));
        System.out.println(searchInsert(a, -6));
        System.out.println(searchInsert(a, 8));

    }

    private static int searchInsert(int[] A, int B) {

        int l = 0;
        int r = A.length-1;
        int indexOfSmallerElementThanB = -1;

        while(l<=r) {

            int mid = (l+r)/2;

            if(A[mid] == B) {
                return mid;
            } else if(A[mid] > B) {
                r = mid - 1;
            } else if(A[mid] < B) {
                indexOfSmallerElementThanB = mid;
                l = mid + 1;
            }
        }

        return indexOfSmallerElementThanB + 1;
    }
}
