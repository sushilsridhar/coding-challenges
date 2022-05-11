package maths.combinatorics;

/*
    Compute NCR

    option 1: brute force
    N C R % m = ( N!/(R! * (N-R)!) ) % m

    tc: O(N + R + (N-R)) -> O(N)

    option 2: using inverse modulus
    (N! % m) * ( R! ^ -1 % m ) * ( (N-R)! ^ -1 % m)
    - if m is prime, apply fermat's theorem
    - R! & m are co-prime , iterate from 1 t0 m-1 and find

    option 3: using combination properties

    N C R = N-1 C R + N-1 C R-1 (check github documentation)

    using recursion, but it cause TLE, since there is repetition in the sub problems
    use dynamic programming,

    5C3 = 10, refer the image notes for explanation

    tc: O(n*r)
    sc: O(n*r)

 */
public class ComputeNCR {
    public static void main(String[] args) {

        System.out.println(calculate(5, 3, Integer.MAX_VALUE));
        System.out.println(dpSolution(5, 3, Integer.MAX_VALUE));

    }

    private static int dpSolution(int A, int B, int C) {

        int n = A;
        int r = B;
        int m = C;

        int minValue = Math.min(n, r);
        int[][] matrix = new int[n+1][r+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=minValue; j++) {

                if(j==0 || j==i) {
                    matrix[i][j] = 1;
                } else if(i==0) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
                    matrix[i][j] = matrix[i][j]%m;
                }
            }
        }

        return matrix[n][r]%m;
    }

    private static int calculate(int n, int r, int m) {

        if(r == 0 || n == r) {
            return 1;
        }

        if(r == 1) {
            return n%m;
        }

        int x = calculate(n-1, r, m)%m;
        int y = calculate(n-1, r-1, m)%m;

        return (x+y)%m;
    }
}
