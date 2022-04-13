package sorting.adv;

/*
    Find the Bth smallest element in given array A .

    NOTE: Users should try to solve it in less than equal to B swaps.

    A = [2, 1, 4, 3, 2]
    B = 3

    approach:
    selection sort

    tc: O(B * n)
 */
public class KthSmallestElement {

    public static void main(String[] args) {

        int[] A = {2, 1, 4, 3, 2};
        int B = 3;

        System.out.println(kthsmallest(A, B));
    }

    private static int kthsmallest(final int[] A, int B) {

        int sortedArrayIndex = 0;

        while(sortedArrayIndex < B) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            for(int i=sortedArrayIndex; i<A.length; i++) {
                if(A[i] < min) {
                    min = A[i];
                    minIndex = i;
                }
            }

            int temp = A[sortedArrayIndex];
            A[sortedArrayIndex] = A[minIndex];
            A[minIndex] = temp;

            sortedArrayIndex++;
        }

        return A[B-1];
    }
}
