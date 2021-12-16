package matrix;

/*
    [1,2,3,4]
    [5,6,7,8]
    [9,2,3,4]

    Row 1 = 1+2+3+4 = 10
    Row 2 = 5+6+7+8 = 26
    Row 3 = 9+2+3+4 = 18
 */
public class MatrixRowSum {

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

        int[] r = new int[A.length];
        for(int i=0; i<A.length; i++) {
            int sum=0;
            for(int j=0; j<A[0].length; j++) {
                sum = sum + A[i][j];
            }
            r[i] = sum;
        }
        return r;
    }
}
