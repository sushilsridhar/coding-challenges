package numbers;

/*
    find sqrt using binary search

    the square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned
 */
public class Find_SQRT {
    public static void main(String[] args) {

        int n = 2147483647; // ans = 46340

        System.out.println(findSqrt(n));

        int x = 25;
        System.out.println(bestSolution(x));
    }

    // binary search - Time complexity: O(log n)
    private static int bestSolution(int x) {

        if(x < 2) {
            return x;
        }

        int left = 2, right = x/2;
        int center = 0;
        long square = 0;

        while(left<=right) {
            center = (left+right)/2;

            square = (long) center*center;

            if(square > x) {
                right = center - 1;
            } else if (square < x) {
                left = center + 1;
            } else {
                return center;
            }
        }
        return right;

    }

    // Time complexity: O(n)
    private static int findSqrt(int n) {

        if(n==0) {
            return 0;
        }
        if (n<=3) {
            return 1;
        }
        int prevI = 0;
        for(int i=2; i<=n/2; i++) {
            long square = (long)i*i;

            if(square == n) { // this is for perfect squares
                return i;
            } else if(square > n) { // this is for non perfect squares
                break;
            }
            prevI = i;
        }
        return prevI;
    }
}
