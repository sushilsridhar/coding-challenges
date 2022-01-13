package arrays.sorting;

/*
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note: Using library sort function is not allowed.

    A = [0 1 2 0 1 2 1 0 2 1]
        [0 0 0 1 1 1 1 2 2 2] - output

    optimized:
    iterate and insert zero at the beginning, and insert two at the end, one will be automatically arranged
 */
public class SortByColor {
    public static void main(String[] args) {

        int[] A = {0, 1, 2, 0, 1, 2, 1, 0, 2, 1};

        int[] r = optimized(A);
        for(int i=0; i<r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }

    // Time complexity - O(n) -
    public static int[] optimized(int[] A) {

        int n = A.length;
        int zeroInsertPosition=0, twoInsertPosition=n-1;

        for(int i=0; i<=twoInsertPosition; ) {

            if(A[i] == 0) {
                int temp = A[zeroInsertPosition];
                A[zeroInsertPosition] = A[i];
                A[i] = temp;
                zeroInsertPosition++;
                i++;
            } else if(A[i] == 2) {
                int temp = A[twoInsertPosition];
                A[twoInsertPosition] = A[i];
                A[i] = temp;
                twoInsertPosition--;
            } else {
                i++;
            }
        }

        return A;
    }
    // Time complexity - O(n)
    public static int[] sortColors(int[] A) {

        int redCount=0, whiteCount=0, blueCount=0;
        for(int i=0; i<A.length; i++) {

            if(A[i] == 0) {
                redCount++;
            } else if(A[i] == 1) {
                whiteCount++;
            } else if(A[i] == 2) {
                blueCount++;
            }
        }

        int redInitial=0, whiteInitial=0, blueInitial=0;
        for(int i=0; i<A.length; i++) {

            if(redInitial<redCount) {
                A[i] = 0;
                redInitial++;
            } else if(whiteInitial<whiteCount) {
                A[i] = 1;
                whiteInitial++;
            } else if(blueInitial<blueCount) {
                A[i] = 2;
                blueInitial++;
            }
        }

        return A;
    }
}
