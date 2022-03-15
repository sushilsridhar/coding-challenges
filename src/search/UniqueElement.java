package search;

/*
    Every element occurs twice, except one element

    Note: Duplicates are present adjacent to each other

    approach:

    array is always odd size, because of one extra element

      0  1  2  3  4  5   6   7   8  9  10  11 12  13  14
    { 3, 3, 1, 1, 8, 8, 10, 10, 19, 6,  6,  2, 2,  4,  4};

    l   r   m
    0  14   7
    8  14  11
    8  10


    separate the array based on size,
    element on 7 is same as 6, so include the mid in first subarray,
    0-7 -> 8 elements in first subarray, since even, ignore the left part and move to towards right

    element at 11, is same as element at 10, include 11 to right sub array,

    8-10 -> one subarray
    11-14 -> one subarray, ignore this, as size is even, move towards left

    size becomes 3, now pick the unique element directly

    8  9 10
    19 6 6

    tc: O(logn)
 */
public class UniqueElement {

    public static void main(String[] args) {
        //          0  1  2  3  4  5   6   7   8  9  10  11 12  13  14
        int a[] = { 3, 3, 1, 1, 8, 8, 10, 10, 19, 6,  6,  2, 2,  4,  4};

        //          0  1  2  3  4  5   6   7   8   9  10  11 12  13  14
        int b[] = { 3, 3, 1, 1, 8, 8, 10, 10, 19, 19,  6,  2, 2,  4,  4};

        //          0   1   2  3  4  5  6  7    8  9  10  11 12  13  14
        int c[] = { 3, 19, 19, 1, 1, 8, 8, 10, 10, 6,  6,  2, 2,  4,  4};

        //          0   1   2  3  4  5  6  7    8  9  10  11 12  13  14
        int d[] = { 3,  3, 19, 19, 1, 1, 8, 8, 10, 10, 6,  6,  2, 2,  4};

        System.out.println(search(a));
        System.out.println(search(b));
        System.out.println(search(c));
        System.out.println(search(d));

    }

    private static int search(int[] a) {

        int l = 0;
        int r = a.length-1;

        while(l<=r) {

            int lengthOfTotalArray = r-l+1;
            int mid = (l+r)/2;

            int lengthOfFirstSubArray = a[mid-1] == a[mid] ? mid -l+1 : mid-1 -l+1;

            if(lengthOfTotalArray == 3) {
                if(a[l] == a[l+1]) {
                    return a[r];
                } else if(a[r] == a[r-1]) {
                    return a[l];
                }
            } else if((lengthOfFirstSubArray & 1) == 0) {
                l = mid + 1;
            } else if((lengthOfFirstSubArray & 1) == 1) {
                r = mid - 1;
            }
        }

        return -1;
    }
}
