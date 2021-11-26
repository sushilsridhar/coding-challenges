package matrix;

/*
    You are given a N X N square integer matrix A. You have to tell whether A is an identity matrix or not.
    Identity matrix is a special square matrix whose main diagonal elements are equal to 1 and all other elements are 0.

    O(ROW * COL)
 */
public class IsIdentityMatrix {

    public static void main(String[] args) {

        int [][] a =  { {1, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}};

        System.out.println(solve(a));
    }

    public static int solve(final int[][] A) {

        int r=1;

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A.length; j++) {
                if(i==j) {
                    if(A[i][j] != 1) {
                        r=0;
                        break;
                    }
                } else if(A[i][j] != 0) {
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
