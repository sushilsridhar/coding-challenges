package maths;

/*
    Given N, numbers of elements from 1-N have odd number of factors,
    return the count of total numbers having odd factors

    N = 10, ans = 3

    1 2 3 4 5 6 7 8 9 10
    1 2 2 3 2 4 2 4 3 4  - factors,

    1, 4, 9 have odd factors, odd factors are perfect squares,
    get number of perfect squares from 1-N

 */
public class CountOddFactors {

    public static void main(String[] args) {

        System.out.println(findPerfectSquares(10));
        System.out.println(findPerfectSquares(25));
        System.out.println(findPerfectSquares(100));

    }

    private static int findPerfectSquares(int n) {
       int i = 1;
       int count = 0;

       while(i*i<=n) {
           count++;
           i++;
       }

       return count;
    }
}
