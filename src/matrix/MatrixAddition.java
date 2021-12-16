package matrix;

/*
    Note: watch video and add here

   o(rc) => where r is rows and c is columns
 */
public class MatrixAddition {

    public static void main(String []args) {

        int[][] m1 =  {
                {1,2,3,4},
                {4,5,6,4},
                {7,8,9,4}
        };

        int[][] m2 =  {
                {1,2,3,4},
                {4,5,6,4},
                {7,8,9,4}
        };

        int m4[][] = solve(m1,m2);

        for(int i=0 ; i<m4.length; i++) {
            for(int j=0; j<m4[0].length; j++) {

                System.out.print(m4[i][j]+" ");
            }
            System.out.println();
        }
    }

    // time complexity, O(r * c), space complexity: O(1)
    public static int[][] solve(int[][] A, int[][] B) {

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[0].length; j++) {
                A[i][j] = A[i][j] + B[i][j];
            }
        }
        return A;
    }

    // with extra space, space complexity: O(r * c)
    static int[][] add2arrays(int[][] m1, int[][] m2) {

        int[][] m3 = new int[m1.length][m1[0].length];


        for(int i=0 ; i<m1.length; i++) {

            for(int j=0; j<m1[0].length; j++) {

                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m3;
    }
}
