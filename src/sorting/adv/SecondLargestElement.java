package sorting.adv;

/*
    Given an array of N distinct elements and k, find the kth largest element
    k is fixed in this case, k = 2

    if k = 3...4..5 we can't use the iterative approach, we need to use sorting approach

    tc: O(n*k) , n-k is 7-2, 5, index 5 contains the second largest element
 */
public class SecondLargestElement {

    public static void main(String[] args) {
              //    0  1  2  3   4  5  6
        int[] a = { 5, 8, 1, 3, 15, 9, 2}; // ans = 9
        int k = 2;

        int[] sortingApproach1 = { 5, 8, 1, 3, 15, 9, 2};
        int[] sortingApproach2 = { 5, 8, 1, 3, 15, 9, 2};
        int[] sortingApproach3 = { 5, 8, 1, 3, 15, 9, 2};

        System.out.println(solution(a, k));
        System.out.println("---");

        System.out.println(sortingApproach(sortingApproach1, k));
        System.out.println(sortingApproach(sortingApproach2, 3));
        System.out.println(sortingApproach(sortingApproach3, 5));
        System.out.println("---");

        int[] sortingApproachTwo1 = { 5, 8, 1, 3, 15, 9, 2};
        int[] sortingApproachTwo2 = { 5, 8, 1, 3, 15, 9, 2};
        int[] sortingApproachTwo3 = { 5, 8, 1, 3, 15, 9, 2};

        System.out.println(sortingApproachTwo(sortingApproachTwo1, k));
        System.out.println(sortingApproachTwo(sortingApproachTwo2, 3));
        System.out.println(sortingApproachTwo(sortingApproachTwo3, 5));
    }

    // bubble sort, constraint, only allowed to swap only adjacent elements
    // tc: O(n*k), n-k is 7-2, 5, index 5 contains the second largest element
    private static int sortingApproachTwo(int[] a, int k) {

        /*
            5, 8, 1, 3, 15, 9, 2 , for k = 2

            1: 5, 1, 3, 8, 9, 2, 15
            2: 1, 3, 5, 8, 2, 9, 15

         */
        int n = a.length;
        int unsortedArraySize = n-1;

        while(unsortedArraySize >= (n-k)) {
            for(int i=0; i<n-1; i++) {
                if(a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            unsortedArraySize = unsortedArraySize - 1;
        }
        return a[n-k];
    }

    // selection sort, tc: O(n*k) , n-k is 7-2, 5, index 5 contains the second largest element
    private static int sortingApproach(int[] a, int k) {
        int n = a.length;
        int unsortedArraySize = n-1;

        while(unsortedArraySize >= (n-k)) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;

            for(int i=0; i<=unsortedArraySize; i++) {
                if(a[i] > max) {
                    max = a[i];
                    maxIndex = i;
                }
            }

            int temp = a[unsortedArraySize];
            a[unsortedArraySize] = a[maxIndex];
            a[maxIndex] = temp;

            unsortedArraySize = unsortedArraySize-1;
        }

        return a[n-k];
    }

    // tc: O(n), sc: O(1)
    private static int solution(int[] a, int k) {

        int max1 = Math.max(a[0], a[1]);
        int max2 = Math.min(a[0], a[1]);

        for(int i=2; i<a.length; i++) {

            if(a[i] < max2) {
                continue;
            }

            if(a[i] > max1) {
                max2 = max1;
                max1 = a[i];
            } else if(a[i] > max2) {
                max2 = a[i];
            }
        }

        return max2;
    }
}
