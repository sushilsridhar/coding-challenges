package matrix;

/*
    You are given a N X N integer matrix A. You have to tell whether it is a lower triangular matrix or not.

    O(ROW * COL)
 */
public class LowerTrianglerMatrixCheck {

    public static void main(String[] args) {

        int [][] a =  { {1, 0, 0},
                        {1, 1, 0},
                        {2, 3, 1}};

        System.out.println(solve(a));
    }

    public static int solve(final int[][] A) {

        int r=1;

        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                if(A[i][j] != 0) {
                    r=0;
                    break;
                }
            }
            if(r==0) {
                break;
            }
        }
        return r;
    }
}
