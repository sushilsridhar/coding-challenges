package matrix;

/*
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}

    output:

    1 5 9
    2 6 10
    3 7 11
    4 8 12
 */
public class TransposeOfRectangleMatrix {

    public static void main(String[] args) {

        int [][] a =  { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}};

        int [][] r = solve(a);

        for(int i=0; i<r.length; i++) {
            for(int j=0; j<r[0].length; j++) {
                System.out.print(r[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static int[][] solve(final int[][] A) {

        int r[][] = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                r[j][i] = A[i][j];
            }
        }
        return r;
    }
}
