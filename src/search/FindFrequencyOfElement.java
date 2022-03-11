package search;

/*
   Given a sorted array of size n, find the frequency of the given element k

   approach:

   search for the first occurrence using binary search, (0+17)/2 = 8, a[8] == 5, 8 can be the first occurrence,
   save it and search on the left side to see if anymore 5 is there

   search for the last occurrence using binary search

   lastOccurrence - firstOccurrence + 1 --> frequency

   tc: O(logn + logn), sc: O(1)
 */
public class FindFrequencyOfElement {

    public static void main(String[] args) {
                //   0   1   2  3  4  5  6  7  8  9  10  11  12  13  14 15  16  17
        int a[] = { -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5,  5,  5,  5,  8, 10, 10, 15};
        System.out.println(findFrequency(a, 5));
        System.out.println(findFrequency(a, -5));
        System.out.println(findFrequency(a, 10));
        System.out.println(findFrequency(a, 15));
        System.out.println(findFrequency(a, 0));

    }

    private static int findFrequency(int[] a, int k) {

        int l = 0;
        int r = a.length-1;
        int firstOccurrence = Integer.MAX_VALUE;
        int lastOccurrence = Integer.MIN_VALUE;

        while(l<=r) {
            int mid = (l+r)/2;

            if(a[mid] == k) {
                firstOccurrence = mid;
                r = mid - 1;
            } else if(a[mid] > k) {
                r = mid - 1;
            } else if(a[mid] < k) {
                l = mid + 1;
            }
        }

        l = 0;
        r = a.length-1;

        while(l<=r) {
            int mid = (l+r)/2;

            if(a[mid] == k) {
                lastOccurrence = mid;
                l = mid + 1;
            } else if(a[mid] > k) {
                r = mid - 1;
            } else if(a[mid] < k) {
                l = mid + 1;
            }
        }

        return lastOccurrence - firstOccurrence + 1;
    }
}
