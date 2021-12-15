package matrix;

/*
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}

    output:

    1 4 7
    2 5 8
    3 6 9
 */
public class TransposeOfSquareMatrix {

    public static void main(String[] args) {

        int [][] a =  { {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        int [][] r = efficient(a);

        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a[0].length; j++) {
                System.out.print(r[i][j]+" ");
            }
            System.out.println("");
        }
    }

    // using swapping, saving space
    public static int[][] efficient(final int[][] A) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j<i; j++) {
                int temp = A[j][i];
                A[j][i] = A[i][j];
                A[i][j] = temp;
            }
        }
        return A;
    }

    // Extra space
    public static int[][] solve(final int[][] A) {

        int r[][] = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                r[j][i] = A[i][j];
            }
        }
        return r;
    }
}
