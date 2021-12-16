package matrix;

/*
    [1,2,3,4]
    [5,6,7,8]
    [9,2,3,4]

    Column 1 = 1+5+9 = 15
    Column 2 = 2+6+2 = 10
    Column 3 = 3+7+3 = 13
    Column 4 = 4+8+4 = 16
 */
public class MatrixColumnSum {

    public static void main(String []args) {

        int[][] a = { {1,2,3,4},
                      {5,6,7,8},
                      {9,2,3,4} };

        int[] b = solve(a);

        for(int i=0; i<b.length; i++) {
            System.out.print(b[i]+" ");
        }
    }

    public static int[] solve(int[][] A) {

        int[] r = new int[A[0].length];

        for(int j=0; j<A[0].length; j++) {
            int sum = 0;
            for(int i=0; i<A.length; i++) {
                sum = sum + A[i][j];
            }
            r[j] = sum;
        }
        return r;
    }
}
