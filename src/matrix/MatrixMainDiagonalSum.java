package matrix;

/*
   {1,2,3},
   {4,5,6},
   {7,8,9}

    diagonal = 1+5+9 = 15
 */
public class MatrixMainDiagonalSum {

    public static void main(String []args) {

        int[][] a = { {1,2,3},
                      {4,5,6},
                      {7,8,9} };

        System.out.print(solve(a));

    }

    public static int solve(int[][] A) {

        int sum = 0;

        for(int i=0; i<A.length; i++) {
            sum = sum + A[i][i];
        }
        return sum;
    }
}
