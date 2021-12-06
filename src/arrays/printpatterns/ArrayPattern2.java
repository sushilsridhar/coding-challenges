package arrays.printpatterns;

/*
    [  [0, 0, 0, 1]
       [0, 0, 2, 1]
       [0, 3, 2, 1]
       [4, 3, 2, 1]  ]
 */
public class ArrayPattern2 {

    public static void main(String[] args) {

        int A =4;
        int[][] b = solve(A);

        for(int i=0; i<b.length; i++) {
            System.out.println();
            for(int j=0; j<b.length; j++) {
                System.out.print(b[i][j]+" ");
            }
        }
    }

    public static int[][] solve(int A) {

        int n = A;
        int[][] a = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=n-1, k=1; j>=n-1-i; j--, k++) {
                a[i][j] = k;
            }
        }
        return a;
    }
}
