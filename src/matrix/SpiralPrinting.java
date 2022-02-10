package matrix;

/*
    Spiral printing of 2D matrix
 */
public class SpiralPrinting {

    public static void main(String []args) {

                      //  0  1   2   3   4
        int[][] a = {   {-1, 3, -2,  4,  6},      // 0
                        {2,  4, -3,  2, -6},      // 1
                        {3, -2,  4, -1,  2},      // 2
                        {1,  3,  1,  2, -1}};     // 3

                      //  0  1   2   3   4
        int[][] b = {   {-1, 3, -2,  4,  6}};      // 0

                      //  0
        int[][] c = {   {-1 },     // 0
                        { 2 },      // 1
                        { 3 },      // 2
                        { 1 }};     // 3

                      //  0  1
        int[][] d = {   {-1,  3},      // 0
                        { 2,  4},      // 1
                        { 3, -2}};     // 2

        //spiral(a);
        spiral(b);
        spiral(c);
        spiral(d); // n = 3, m = 2 , at the end of iterations, n = 1, m = 0, edge case handled

        // edge cases
    }

    private static void spiral(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int i = 0, j = 0;

        while(n > 1 && m > 1) {
            System.out.println();

            for(int k=0; k<m-1; k++) {
                System.out.print(a[i][j]+" ");
                j++;
            }
            System.out.println();

            for(int k=0; k<n-1; k++) {
                System.out.print(a[i][j]+" ");
                i++;
            }

            System.out.println();

            for(int k=0; k<m-1; k++) {
                System.out.print(a[i][j]+" ");
                j--;
            }

            System.out.println();

            for(int k=0; k<n-1; k++) {
                System.out.print(a[i][j]+" ");
                i--;
            }

            i++; // moves to inner rectangle, i and j will end at 0,0 in initial loop
            j++; // moves to inner rectangle

            n = n - 2; // size of inner rectangle
            m = m - 2; // size of inner rectangle
        }

        if(n == 0 || m == 0) { // edge case for input d
            System.out.println("Everything printed");
        } else if(n == 1 || m == 1) {
            if(n > 1) {
                for(i=0; i<=n-1; i++) {
                    System.out.print(a[i][j]+" ");
                }
            } else {
                for(j=0; j<=m-1; j++) {
                    System.out.print(a[i][j]+" ");
                }
            }
        }
    }
}
