package matrix.adv;

/*
    Technique: Prefix sum in 2D matrix

    Given a input matrix and queries, find the sum of elements of sub matrix mentioned in the query

 */
public class SubmatrixSum {

    public static void main(String[] args) {
        int[][] a = {
                // 0   1   2   3
                {  1,  5,  2,  3 },      // 0
                {  7,  2,  3,  4 },      // 1
                {  3,  4,  2,  5 },      // 2
                {  8,  4,  2,  3 }};     // 3

        // answer = 20
        System.out.println(bruteForce(a, 1, 1,2,3));
        System.out.println(prefixSum(a, 1, 1,2,3));
        System.out.println(prefixSumIn2DMatrix(a, 1, 1,2,3));

        // answer = 41
        System.out.println("edge case 1: " + bruteForce(a, 0, 0,2,3));
        System.out.println("edge case 1: " + prefixSum(a, 0, 0,2,3));
        System.out.println("edge case 1: " + prefixSumIn2DMatrix(a, 0, 0,2,3));

        // answer = 19
        System.out.println("edge case 2: " + bruteForce(a, 0, 1,1,3));
        System.out.println("edge case 2: " + prefixSum(a, 0, 1,1,3));
        System.out.println("edge case 2: " + prefixSumIn2DMatrix(a, 0, 1,1,3));

        // answer = 21
        System.out.println("edge case 2: " + bruteForce(a, 1, 0,2,2));
        System.out.println("edge case 2: " + prefixSum(a, 1, 0,2,2));
        System.out.println("edge case 2: " + prefixSumIn2DMatrix(a, 1, 0,2,2));
    }

    private static int prefixSumIn2DMatrix(int[][] a, int r1, int c1, int r2, int c2) {

        // 2D prefix sum
        //       0    1    2    3
        // 0 {   1,   6,   8,  11 },
        // 1 {   8,  15,  20,  27 },  1,1 to
        // 2 {  11,  22,  29,  41 },         2,3
        // 3 {  19,  34,  43,  58 }};

        int[][] pf = new int[a.length][a[0].length];

        pf[0][0] =  a[0][0];
        for(int j=1; j<a.length; j++) {
            pf[0][j] = pf[0][j-1] + a[0][j];
        }
        for(int i=1; i<a.length; i++) {
            pf[i][0] = pf[i-1][0] + a[i][0];
        }

        for(int i=1; i<a.length; i++) {
            for(int j=1; j<a.length; j++) {
                pf[i][j] = pf[i][j-1] + pf[i-1][j] - pf[i-1][j-1] + a[i][j];
            }
        }

        // iterate for q queries
        // pf[r2][c2] - pf[r1-1][c2] - pf[r2][c1-1] + pf[r1-1][c1-1]

        // edge cases
        // if r1 and c1 are 0

        if(r1 == 0 && c1 == 0) {
            return pf[r2][c2];
        }

        // r1 = 0, c1 = 1, r2 = 1, c2 = 3
        if(r1 == 0) {
            return pf[r2][c2] - pf[r2][c1-1];
        }

        // r1 = 1, c1 = 0, r2 = 2, c2 = 2
        if(c1 == 0) {
            return pf[r2][c2] - pf[r1-1][c2];
        }

        return pf[r2][c2] - pf[r1-1][c2] - pf[r2][c1-1] + pf[r1-1][c1-1];
    }

    // tc: O(n * m + n * q), sc: O(n * m)
    private static int prefixSum(int[][] a, int r1, int c1, int r2, int c2) {

        // row wise prefix sum
        //      0   1    2    3
        // 0 {  1,  6,   8,  11 },   r1 -> 1, c1-> 1, r2->2, c2->3
        // 1 {  7,  9,  12,  16 },   { 9  12  16     calculate this sum, pf[1][3] - pf[1][1] + a[1][1]
        // 2 {  3,  7,  10,  15 },     7  10  15 }   calculate this sum, pf[2][3] - pf[2][1] + a[2][1]
        // 3 {  8, 12,  14,  17 }};                  add both sum

        int[][] pf = new int[a.length][a[0].length];

        for(int i=0; i<a.length; i++) {
            pf[i][0] = a[i][0];
            for(int j=1; j<a[0].length; j++) {
                pf[i][j] = pf[i][j-1] + a[i][j];
            }
        }

        int sum = 0;
        for(int i=r1; i<=r2; i++) {
            sum = sum + pf[i][c2] - pf[i][c1] + a[i][c1];
        }

        return sum;
    }

    // tc: O(n * m * q), sc: O(1)
    private static int bruteForce(int[][] a, int r1, int c1, int r2, int c2) {
        int sum = 0;
        for(int i=r1; i<=r2; i++) {
            for(int j=c1; j<=c2; j++) {
                sum = sum + a[i][j];
            }
        }
        return sum;
    }
}
