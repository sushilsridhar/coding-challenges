package matrix;

/*
    given a 2D matrix, every row is sorted, every column is sorted, find the element k

    brute force: tc -> O(n*m)
    BS on every row: tc -> O(n * logm)

    approach:
    k = 15
    start with right top element, 11

    if 11 < 15, means all elements on that row is less than 15, so ignore that row,
    i++
    if 18 > 15 (row 2), means, all elements on the column after row 2 is greater than 15, ignore the column,
    j--
    decrease the searching space, by ignoring the rows and columns

    tc: At every iteration, a row or a column is ignored
    worst case, the element we are searching is at 7,0
    we will iterate first for n times to reach 7, for row, and iterate for m times to reach the column 0

    In each iteration we are skipping either a row or a column, max number of rows that can be skipped is n, and
    max number of columns that can be skipped in m

    O(n + m)
    sc: O(1)
 */
public class FindElementInSortedMatrix {

    public static void main(String []args) {


        int[][] a = {
                // 0   1   2   3    4   5
                 {-1,  2,  4,  5,   9, 11},      // 0
                 { 1,  4,  7,  8,  10, 14},      // 1
                 { 3,  7,  9, 10,  12, 18},      // 2
                 { 6, 10, 12, 14,  16, 20},      // 3
                 { 9, 13, 16, 19,  22, 24},      // 4
                 {11, 15, 19, 21,  24, 27 },     // 5
                 {14, 20, 25, 29,  31, 39},      // 6
                 {18, 24, 29, 32,  34, 42}};     // 7

        System.out.println(findElement(a, 15));
        System.out.println(findElement(a, 30));
    }

    private static boolean findElement(int[][] a, int k) {

        int i = 0;
        int j = a[0].length-1;

        int n = a.length;

        while(i<n && j>=0) {
            if(a[i][j] == k) {
                return true;
            } else if(a[i][j] < k) {
                i++;
            } else if(a[i][j] > k) {
                j--;
            }
        }

        return false;
    }
}
