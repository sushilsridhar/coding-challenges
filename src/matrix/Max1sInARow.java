package matrix;

/*
    Given a 2D matrix, every element is 0 or 1, every row is sorted
    find the max 1's in a row

    approach:

    start from top right, if it is 1, neglect the whole column, as it does not matter
    and move to previous column

    if previous column is 0, ignore the whole row, move to next row

    eg: starting from index
    0 4, 1 -> ignore column, move to column 3, count = 1
    0 3, 1 -> ignore column, move to column 2, count = 2
    0 2, 0 -> ignore row 0, move to row 1
    1 2, 0 -> ignore row 1, move to row 2
    2 2, 1 -> ignore column 2, move to column 1, count = 3
    2 1, 1 -> ignore column 1, move to column 0, count = 4
    2 0, 0 -> ignore column 0, end of the loop

    In each iteration we are skipping either a row or a column, max number of rows that can be skipped is n, and
    max number of columns that can be skipped in m

   tc: O(n + m)
 */
public class Max1sInARow {

    public static void main(String []args) {


        int[][] a = {
                // 0   1   2   3   4
                {  0,  0,  0,  1,  1},      // 0
                {  0,  0,  0,  0,  0},      // 1
                {  0,  1,  1,  1,  1},      // 2
                {  0,  0,  0,  1,  1},      // 3
                {  0,  0,  0,  1,  1}};     // 4

        System.out.println(bruteForce(a));
        System.out.println(efficient(a));
    }

    private static int efficient(int[][] a) {

        int n = a.length;
        int m = a[0].length-1;
        int i = 0;
        int j = m;
        int count = 0;

        while(i<n && j>=0) {
            if(a[i][j] == 1) {
                count++;
                j--;
            } else {
                i++;
            }
        }
        return count;
    }

    private static int bruteForce(int[][] a) {
        int m = a[0].length;
        int first1Index = Integer.MAX_VALUE;

        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a[0].length; j++) {
                if(a[i][j] == 1) {
                    if(j < first1Index) {
                        first1Index = j;
                    }
                    break;
                 }
            }
        }
        return m - first1Index;
    }
}
