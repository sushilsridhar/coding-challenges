package matrix;

/*
    Print boundaries

    edge case
    { 0 1 2 3 4 5}, for 1x6, logic will not work

    if single row or single column, it will not work, print it directly
 */
public class PrintBoundaries {

    public static void main(String []args) {

                    //  0   1   2   3   4
        int[][] a = { {-1,  3, -2,  4,  6},      // 0
                      { 2,  4, -3,  2, -6},      // 1
                      { 3, -2,  4, -1,  2},      // 2
                      { 1,  3,  1,  2, -1} };    // 3

        // 4x5 matrix
        int n = a.length;
        int m = a[0].length;
        int i=0, j=0;

        // 0th row
        // print row from 0 upto column 3, first row
        for(j=0; j<m-1; j++) {
            System.out.print(a[0][j]+" ");
        }
        System.out.println("");

        // print m-1 th column
        // print column from m-1, upto n-1, last column
        for(i=0; i<n-1; i++) {
            System.out.print(a[i][j]+" "); // j has become m-1 in previous loop
        }

        System.out.println("");

        // print n-1th row,
        // print row from n-1 upto 0, base row
        for(; j>0; j--) { // j = m-1, i = n-1
            System.out.print(a[i][j]+" "); // i has become n-1 in previous loop
        }

        System.out.println("");

        // print 0th column,
        // print column from n-1 upto 0, first column
        for(; i>0; i--) { // i = n-1, j = 0
            System.out.print(a[i][j]+" "); // j has become 0 in previous loop
        }

        // after this, both i and j will be zero
    }
}
