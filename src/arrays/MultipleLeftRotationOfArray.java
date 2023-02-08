package arrays.numbers;

/*
    Given an array of integers A and multiple values in B which represents number of times array A needs to be left rotated.

    Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the i'th value in B.

    A = [1, 2, 3, 4, 5]
    B = [2, 3]

    answer:
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]

 */
public class MultipleLeftRotationOfArray {

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 3};
        solve(A, B);

    }

    public static int[][] solve(int[] A, int[] B) {

        int[][] result = new int[B.length][A.length];

        for(int i=0; i<B.length; i++) {
            int[] arr = A.clone();

            leftRotateArray(arr, B[i]);

            for(int j=0; j<A.length; j++) {
                result[i][j] = arr[j];
            }
        }
        return result;
    }

    public static void leftRotateArray(int[] arr, int numberOfRotation) {
        int n = arr.length;
        int k = numberOfRotation%n;

        reverse(arr, 0, n-1);
        reverse(arr, 0, n-1-k);
        reverse(arr, n-k, n-1);
    }

    public static void reverse(int[] arr, int start, int end) {

        while(start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
