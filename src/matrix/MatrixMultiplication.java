package matrix;

/*
    You are given two integer matrices A(having M X N size) and B(having N X P).
    You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).

    output matrix is off size M * P

    two for loops for marking the insert position, c[i][j],
    k loop is to multiply

    answer:
    [[19, 22], 1(5) + 2(7) = 19
    [43, 50]]
 */
public class MatrixMultiplication {

    public static void main(String[] args) {

        int [][] a =  { {1, 2},
                        {3, 4}};

        int [][] b =  { {5, 6},
                        {7, 8}};

        int[][] r = solve(a, b);

        for(int i=0; i<r.length; i++) {
            for(int j=0; j<r[0].length; j++) {
                System.out.print(r[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static int[][] solve(int[][] A, int[][] B) {

        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] c = new int[m][p];

        for(int i=0; i<m; i++) {
            for(int j=0; j<p; j++) {
                c[i][j] = 0;
                for(int k=0; k<n; k++) {
                    c[i][j] = c[i][j] + A[i][k] * B[k][j];
                }
            }
        }

        return c;
    }
}
