package matrix;

/*
    Given a matrix of integers A of size N x M and an integer B.
    In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
    If A[i][j] = B then return (i * 1009 + j)
    If B is not present return -1.

    Note 1: Rows are numbered from top to bottom and columns are numbered from left to right. (i.e indexes are starting from 1 for row and column)
    Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.

    A = [ [1, 2, 3]
          [4, 5, 6]
          [7, 8, 9] ]
    B = 2

    A[1][2]= 2
    1*1009 + 2 =1011

    approach:

       0  1  2  3
    0 {1, 2, 3, 4},
    1 {4, 6, 6, 7},
    2 {7, 8, 9, 10}

    4 less than 6, move to row 1, 7>6 -> move to column 2, 6 ==6, move to column 1, to find the lowest possible value of i

    tc: O(n+m), n and m are rows and columns
 */
public class SearchInSortedMatrix {

    public static void main(String[] args) {
        int[][] A = {
               //0  1  2  3
                {1, 2, 3, 4},     // 0
                {4, 6, 6, 7},     // 1
                {7, 8, 9, 10 }};  // 2

        int B = 6; // ans --> (1+1) * 1009 + (1+1) , actual index of 6 is 1,1, but ans is calculated with starting index as 1

        System.out.println(solve(A, B));
    }

    // tc: O(n+m), n and m are rows and columns
    private static int solve(int[][] A, int B) {
        int ans = -1;

        int i = 0;
        int j = A[0].length-1;
        int maxI = Integer.MAX_VALUE;

        while((j>=0) && (i<A.length-1)) {

            if(i > maxI) {
                break;
            }

            if(A[i][j] == B) {
                ans = (i+1) * 1009 + (j+1);
                j--;
                maxI = i;
            } else if(A[i][j] < B) {
                i++;
            } else if(A[i][j] > B) {
                j--;
            }
        }


        return ans;
    }

    // tc: O(n2)
    private static int bruteForce(int[][] a, int b) {
        int n = a.length, m = a[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] == b)
                    return (i + 1) * 1009 + j + 1;
        return -1;
    }
}
