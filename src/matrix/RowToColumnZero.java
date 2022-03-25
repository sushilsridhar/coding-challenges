package matrix;

import java.util.HashSet;

/*
    You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
    Specifically, make entire ith row and jth column zero.

    input:
    [1,2,3,4]
    [5,6,7,0]
    [9,2,0,4]

    output:
    [1,2,0,0]
    [0,0,0,0]
    [0,0,0,0]

    approach:

    iterate every row, if a zero is found, make all elements in that row -1 except the element with zero
    iterate every column, if a zero is found, make all elements in that column -1 except the element with zero

    iterate over the both rows and columns, and make all elements which are -1 to 0

    tc: O(n2), sc: O(1)
 */
public class RowToColumnZero {

    public static void main(String[] args) {

        int[][] a =  {

                { 1, 2, 3, 4 },
                { 5, 6, 7, 0 },
                { 9, 2, 0, 4 }
        };

        int [][] r = solve(a);

        for(int i=0; i<r.length; i++) {
            for(int j=0; j<r[0].length; j++) {
                System.out.print(r[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println(" ");

        int[][] b =  {

                { 1, 2, 3, 4 },
                { 5, 6, 7, 0 },
                { 9, 2, 0, 4 }
        };

        int [][] r1 = spaceEfficient(b);

        for(int i=0; i<r1.length; i++) {
            for(int j=0; j<r1[0].length; j++) {
                System.out.print(r1[i][j]+" ");
            }
            System.out.println("");
        }
    }

    // tc: O(n2), sc: O(1)
    public static int[][] spaceEfficient(int[][] A) {

        for(int i=0; i<A.length; i++) {
            boolean flag = false;

            for(int j=0; j<A[0].length; j++) {
                if(A[i][j] == 0) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                for(int j=0; j<A[0].length; j++) {
                    if(A[i][j] != 0) {
                        A[i][j] = -1;
                    }
                }
            }
        }

        for(int j=0; j<A[0].length; j++) {
            boolean flag = false;

            for(int i=0; i<A.length; i++) {
                if(A[i][j] == 0) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                for(int i=0; i<A.length; i++) {
                    if(A[i][j] != 0) {
                        A[i][j] = -1;
                    }
                }
            }
        }


        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[0].length; j++) {
                if(A[i][j] == -1) {
                    A[i][j] = 0;
                }
            }
        }

        return A;
    }

    // tc: O(n2), sc: O(n)
    public static int[][] solve(int[][] A) {

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[0].length; j++) {
                if(A[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for(int i: rows) {
            int j = 0;
            while(j<A[0].length) {
                A[i][j] = 0;
                j++;
            }
        }

        for(int j: columns) {
            int i = 0;
            while(i<A.length) {
                A[i][j] = 0;
                i++;
            }
        }
        return A;
    }
}
