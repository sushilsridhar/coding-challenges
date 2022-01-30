package recursion;

/*
    Implement power function

    pow(a,n) -> 3^3 -> 27

    this recursive code will have some space complexity, while the code written with for loop has O(1) space complexity

    can be split into
    a^10 --> a * a^9   --> O(n)
    a^10 --> a^5 * a^5 --> O(log n)
 */
public class ImplementPowFunction {

    public static void main(String[] args) {

        int a = 3, n = 7;

        System.out.println(pow(a,n));

        System.out.println(powOptimized(a,n));

        System.out.println(optimized(a,n));

    }

    // Time complexity: O(n), which is same if we use for loop
    private static int pow(int a, int n) {

        if(n == 1) {
            return a;
        }
        return pow(a, --n) * a;
    }

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

}
