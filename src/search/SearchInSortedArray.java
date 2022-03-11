package search;

/*
    Given a sorted array with distinct elements, search and return the index of the element k. if not present return -1

    tc: O(logn)
    sc: O(1)
 */
public class SearchInSortedArray {

    public static void main(String[] args) {

        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(a, 3));
    }

    private static int binarySearch(int[] a, int k) {

        int l = 0;
        int r = a.length-1;

        while(l<=r) {
            int mid = (l+r)/2;

            if(a[mid] == k) {
                return mid;
            } else if(a[mid] > k) {
                r = mid - 1;
            } else if(a[mid] < k) {
                l = mid + 1;
            }
        }

        return -1;
    }
}
