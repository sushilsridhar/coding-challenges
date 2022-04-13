package sorting.adv;

/*
    Insertion Sort

    1. start from the second element, this element(current element) is the element to be inserted at correct position,
       save the current element in a variable elementToBeInserted
    2. inner loop: if previous element > elementToBeInserted, shifting the previous element to the right side
    3. inner loop: decrement the previous element index, if this element > elementToBeInserted, repeat step 2, shift the element to the right
    4. if previous element < elementToBeInserted, we have reached the index value which is less than elementToBeInserted,
       insert at previous element index + 1 (j+1 index)
    5. set the next element in the array as elementToBeInserted

    0  1  2  3   4  5  6
    5, 8, 1, 3, 15, 9, 2

    5, 8,| 1, 3, 15, 9, 2
    5, 8, 1,| 3, 15, 9, 2  - after iteration 1
    1, 5, 8, 3,| 15, 9, 2  - after iteration 2
    1, 3, 5, 8, 15,| 9, 2  - after iteration 3
    1, 3, 5, 8, 15, 9,| 2  - after iteration 4
    1, 3, 5, 8, 9, 15, 2 | - after iteration 5
    1, 2, 3, 5, 8, 9, 15   - after iteration 6

 */
public class InsertionSort {
    public static void main(String[] args) {
        //          0  1  2  3   4  5  6
        int[] a = { 5, 8, 1, 3, 15, 9, 2};

        // 1, 2, 3, 5, 8, 9, 15

        int[] r = insertionSort(a);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n^2), sc: O(1)
    private static int[] insertionSort(int[] a) {

        for(int i=1; i<a.length; i++) {
            int eleToBeInserted = a[i];
            int j = i-1;
            for(; j>=0 ; j--) {
                if(a[j] > eleToBeInserted) {
                    a[j+1] = a[j];
                } else {
                   break;
                }
            }
            a[j+1] = eleToBeInserted;
        }

        return a;
    }
}
