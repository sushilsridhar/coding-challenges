package search;

/*
    Given a sorted array, find the floor of a given number k
    floor -> greatest number <= k

    approach:
    keep ignoring the left side, and save the element , the final element which is less than k is the answer
    keep saving the element less than k

    tc: O(logn), sc: O(1)
 */
public class FindFloorInSortedArray {

    public static void main(String[] args) {

        int a[] = { -5, 2, 3, 6, 9, 10, 11, 14, 18};
        System.out.println(search(a, 1));
        System.out.println(search(a, 3));
        System.out.println(search(a, -6));
        System.out.println(search(a, 12));
        System.out.println(search(a, 19));
        System.out.println(search(a, 8));
        System.out.println(search(a, 15));

    }

    private static int search(int[] a , int k) {

        if(k < a[0]) { // no floor exist for this k
            return Integer.MIN_VALUE;
        }

        int l = 0;
        int r = a.length-1;
        int ans = Integer.MIN_VALUE;

        while(l<=r) {
            int mid = (l + r)/2;

            if(a[mid] == k) {
                return a[mid];
            } else if(a[mid] > k) {
                r = mid - 1;
            } else if(a[mid] < k) {
                ans = a[mid];
                l = mid + 1;
            }
        }
        return ans;
    }
}
