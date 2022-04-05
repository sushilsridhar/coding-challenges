package sorting;

/*
    Selection sort

    1. find the max element in the unsorted array
    2. swap the max element with the last element in the unsorted array
    3. decrement unsorted array size, as the last element is sorted
    4. repeat

    0  1  2  3   4  5  6
    5, 8, 1, 3, 15, 9, 2

    0  1  2  3  4  5   6
    5, 8, 1, 3, 2, 9, 15  ( swap 15, 2 )

    tc: O(n^2), sc: O(1)
 */
public class SelectionSort {

    public static void main(String[] args) {
              //    0  1  2  3   4  5  6
        int[] a = { 5, 8, 1, 3, 15, 9, 2};

                 // 1, 2, 3, 5, 8, 9, 15

        int[] r = selectionSort(a);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n^2)
    private static int[] selectionSort(int[] a) {
        int n = a.length;
        int unsortedArraySize = n-1;

       while(unsortedArraySize > 0) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;

            for(int i=0; i<=unsortedArraySize; i++) {
                if(a[i] > max) {
                    max = a[i];
                    maxIndex = i;
                }
            }

            int temp = a[maxIndex];
            a[maxIndex] = a[unsortedArraySize];
            a[unsortedArraySize] = temp;

            unsortedArraySize = unsortedArraySize-1;
        }

        return a;
    }
}
