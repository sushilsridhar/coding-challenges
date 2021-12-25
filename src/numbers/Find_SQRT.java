package numbers;

/*
    Q: find sqrt using binary search

    the square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned


    Binary search

    The idea of binary search is to use the information that
    the array is sorted
    and reduce the time complexity to O(Log n)

    1 2 3 4 5

    start = 1 , end = 5

    find mid, which is 3

    3*3 is not 5 , so square root must be a value less than mid, hence end = mid - 1

    start = 1 , end = 2

    find mid, which is 1

    1*1 is not 5, so increment start and save mid as answer, hence start = mid +1 =2, ans =1

    start = 2 , end = 2

    2*2 is not 5, so increment start, start = 3, save answer as mid, answer = 2

    so 2 is the floored square root of 5
 */
public class Find_SQRT {
    public static void main(String[] args) {

        int n = 2147483647; // ans = 46340

        System.out.println(findSqrt(n));

        int x = 25;
        System.out.println(bestSolution(x));

        System.out.println(mySqrt(x));
    }

    // binary search - Time complexity: O(log n), solution with same pattern
    public static int mySqrt(int x) {

        if(x == 0) {
            return 0;
        }
        if(x < 4) {
            return 1;
        }

        long left = 2, right = x;
        long ans = 0;

        while(left<=right) {
            long center = (left+right)/2;

            long square = center*center;

            if(square == x) {
                return (int)center;
            } else if (square < x) {
                left = center + 1;
                ans = center;
            } else if(square > x) {
                right = center - 1;
            }
        }
        return (int)ans;
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
