package matrix;

/*
    Print Diagonal Right to Left

    Right to Left diagonals:
    1) start index of each diagonal is increasing, end index is decreasing
    2) total number of diagonals is N+M-1
 */
public class PrintDiagonalsOfRectMatrix {

    public static void main(String[] args) {
                    //   0   1   2   3
        int [][] a =  { {1,  2,  3,  4},  // 0
                        {5,  6,  7,  8},  // 1
                        {9, 10, 11, 12}}; // 2

        solve(a);
    }

    public static void solve(final int[][] A) {

        // iterating on column, while row 0 is constant
        for(int j=0; j<A[0].length; j++) {
            int start = 0;
            int end = j;  // [0,0] [0,1] [0,2] [0,3]
                          // [1,0] [1,1] --> increase start and descrease end to move along the diagonal

            while(start <A.length && end >=0) {
                System.out.print(A[start][end]+" ");
                start++;
                end--;
            }
            System.out.println("");
        }

        // iterating on row, while column N is constant
        for(int i=1; i<A.length; i++) {

            int start = i;
            int end = A[0].length-1; //      [1,3] [2,3]
                                 // [2,2] --> decrease start and increase end to move along the diagonal

            while(start <A.length && end >=0) {
                System.out.print(A[start][end]+" ");
                start++;
                end--;
            }
            System.out.println("");

        }

    }
}
