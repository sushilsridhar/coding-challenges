package matrix;

/*
    This is always a square matrix, square matrix has principle diagonal, which non square matrix do not have

    Print Diagonal from Left to Right and Right to Left

    Right to Left:
    1) i is increasing, j is decreasing
    2) i+j = N-1
 */
public class PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {

        int [][] a =  { {1, 0, 0},   // [0,2]
                        {0, 1, 0},  //  [1,1]
                        {0, 0, 1}}; //  [2,0]

        solve(a);
    }

    public static void solve(final int[][] A) {

        // Print diagonal from Right to Left
        for(int i=0,j=A.length-1; (j>=0 && i<A.length); i++,j--) {
            System.out.print(" "+A[i][j]+" ");
        }

        System.out.println(" ");

        // Print diagonal from Left to Right
        for(int i=0; i<A.length; i++) {
            System.out.print(" "+A[i][i]+" ");
        }
    }
}
