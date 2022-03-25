package matrix;

/*
    Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
    constraint: 1 <= A <= 1000

     1   2   3  4
    12  13  14  5
    11  16  15  6
    10   9   8  7

    move from 0 to n-1, 1 to 3
    move from 0 to n-1, 4 to 6
    move from 0 to n-1, 7 to 9
    move from 0 to n-1, 10 to 12

    now i and j will have 0 as value, increment them, so that i=1, j=1
    reduce the n by 2, since 2 rows and 2 columns are filled up,
    remaining empty matrix is off size 2 ( 4-2 = 2)


     1   2   3
     8   9   4
     7   6   5

     edge case, for odd size matrix, middle element will be missed

     if(n == 1) {
          arr[i][j] = ele;
     }

 */
public class GenerateSpiralOrderMatrix {

    public static void main(String []args) {

        int[][] r = generateMatrix(4);

        SpiralPrinting.spiral(r);

    }

    private static int[][] generateMatrix(int A) {

        int[][] arr = new int[A][A];

        int n = A;

        if(A == 1) {
            arr[0][0] = 1;
            return arr;
        }


        int ele = 1;
        int i = 0;
        int j = 0;

        while(n > 1) {

            for(int k=0; k<n-1; k++) {
                arr[i][j] = ele;
                ele++;
                j++;
            }

            for(int k=0; k<n-1; k++) {
                arr[i][j] = ele;
                ele++;
                i++;
            }

            for(int k=0; k<n-1; k++) {
                arr[i][j] = ele;
                ele++;
                j--;
            }

            for(int k=0; k<n-1; k++) {
                arr[i][j] = ele;
                ele++;
                i--;
            }

            i++;
            j++;

            n = n - 2;
        }

        if(n == 1) {
            arr[i][j] = ele;
        }

        return arr;
    }
}
