package sorting.adv;

/*
    Bubble Sort

    1. take pointer to element ( first element in first iteration)
    2. inner loop, take pointer element and pointer+1 element (adjacent elements), if left > right element,
       swap adjacent elements, so that smaller elements are moved to left
    3. move pointer to next element
    4. repeat


    5, 8, 1, 3, 15, 9, 2

    5 1 3 8 9 2 15 - iteration 1
    1 3 5 8 2 9 15 - iteration 2
    1 3 5 2 8 9 15 - iteration 3
    1 3 2 5 8 9 15 - iteration 4
    1 2 3 5 8 9 15 - iteration 5

    6 elements - 5 iterations to sort all elements, 1 element will be sorted by default at the end

    tc: O(n^2), sc: O(1)
 */
public class BubbleSort {

    public static void main(String[] args) {
              //    0  1  2  3   4  5  6
        int[] a = { 5, 8, 1, 3, 15, 9, 2};

        // 1, 2, 3, 5, 8, 9, 15

        int[] r = bubbleSort(a);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n^2)
    private static int[] bubbleSort(int[] a) {
        int n = a.length;
        int unsortedArraySize = n-1; // at the end, one element will be already sorted

        while(unsortedArraySize > 0) {
            for(int i=0; i<n-1; i++) {
                if(a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            unsortedArraySize = unsortedArraySize - 1;
        }
        return a;
    }
}
