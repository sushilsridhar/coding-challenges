package matrix;

/*
    Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

    input:
    1 2 3
    4 5 6
    7 8 9

    output:
    1 0 0
    2 4 0
    3 5 7
    6 8 0
    9 0 0

    refer PrintDiagonalsOfSquareMatrix and PrintDiagonalsOfRectMatrix
 */
public class AntiDiagonals {
    public static void main(String []args) {

        int [][] a =  { {1, 2, 3},   // [0,2]
                        {4, 5, 6},  //  [1,1]
                        {7, 8, 9}}; //  [2,0]

        int r[][] = diagonal(a);

        for(int i=0; i<r.length; i++) {
            for(int j=0; j<r[0].length; j++) {
                System.out.print(r[i][j]+" ");
            }
            System.out.println("");
        }

    }

    public static int[][] diagonal(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int len = n + m - 1; // total number of diagonals in matrix

        int[][] r = new int[len][m];

        int x=0, y=0;

        for(int j=0; j<A[0].length; j++) {

            int start = 0;
            int end = j;
            y=0;

            while(start<A.length && end>=0) {
                r[x][y] = A[start][end];
                start++;
                end--;
                y++;
            }
            x++;
        }


        for(int i=1; i<A.length; i++) {
            int start = i;
            int end = A[0].length-1;
            y=0;

            while(start<A.length && end>=0) {
                r[x][y] = A[start][end];
                start++;
                end--;
                y++;
            }
            x++;
        }

        return r;

    }
}
