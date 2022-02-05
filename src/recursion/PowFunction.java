package recursion;

/*
    Implement power function

    pow(a,n) -> 3^3 -> 27

    this recursive code will have some space complexity, while the code written with for loop has O(1) space complexity

    can be split into
    a^10 --> a * a^9   --> O(n)
    a^10 --> a^5 * a^5 --> O(log n)

    Time complexity: O(log n)

    Where ever multiplication happens, apply %d --> modular arithmetic to avoid TLE
    d should be less than or equal to 10^9,

    if n%d, where d = 10^9+1, and halfPower is 10^9

    halfPower * halfPower --> (halfPower%d * halfPower%d)%d -->
    (halfPower * halfPower) %d --> ( 10^9 * 10^9)%d, this will cause overflow
    in this case, use the long datatype

    Math.pow() --> native implementation provided

    recursive relation for optimized solution:
    T(N) = T(N/2) + 1 --> O(log n)

    space complexity: O(log n) , height of stack or recursive function calls, reduces by half every time

    64
    |
    32
    |
    16

    Time complexity: O(log n)
    Space complexity: O(log n)
 */
public class PowFunction {

    public static void main(String[] args) {

        int a = 3, n = 7;

        System.out.println(pow(a,n));

        System.out.println(powOptimized(a,n));

        System.out.println(optimized(a,n));
    }

    // Time complexity: O(log n), n is reduced by half for every recursive function call
    private static int optimized(int a, int n) {

        if(n==0) {
            return 1;
        }

        int halfPower = optimized(a, n/2);
        int r = halfPower * halfPower;

        if(n%2 == 0) {
            return r;
        } else {
            r = r * a;
        }

        return r;
    }

    // Time complexity: O(n), which is same if we use for loop
    private static int pow(int a, int n) {

        if(n == 1) {
            return a;
        }
        return pow(a, --n) * a;
    }

    //Time complexity: O(n), because recursive function is called twice
    /*
        recursive relation:

        T(n) = 2T(n/2) + 1

        T(n/2) = 2T(N/4)+1
        T(n) = 2[ 2T(n/4) + 1] + 1
        T(n) = 4 T(n/4) +  3
        T(n) = 4[ 2T(n/8) + 1] + 3
        T(n) = 8T(n/8) + 7
        T(n) = 2^3 T(n/2^3) + 2^3 -1

        after k steps, T(n) = 2^k T(n/2^k) + 2^k -1

        last iteration is O(1), N/2^k = 1 --> N = 2^k --> take log on both sides, log n = k
     */
    private static int powOptimized(int a, int n) {

        if(n==1) {
            return a;
        }

        int r = 0;
        if(n%2 == 0) {
            r = powOptimized(a, n/2) * powOptimized(a, n/2);
        } else {
            r = powOptimized(a, n/2) * powOptimized(a, n/2) * powOptimized(a, n%2);
        }

        return r;
    }
}
