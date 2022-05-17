package maths.modulararthimetic;

/*
    Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

    "^" means power,

    "%" means "mod", and

    "!" means factorial.

    constraints: 1 <= A, B <= 5e5

    approach:

    fermat's theorem

    a ^ m = a mod m
    a ^ m-1 = 1 mod m

    we need to calculate a ^ b!, if we can express a ^ b! as a ^ m-1 ...

    a ^ b! = (a ^ m-1 * a ^ m-1 * a ^ m-1 .. a ^ x ) % m
    a ^ b! = 1 mod m * 1 mod m * ... a ^ x % m
    a ^ b! = a ^ x % m

    b! is expressed as m-1, the remaining left over number will be,
    x = b! % (m-1)

    find x and using fast exponential fn to calculate powers

    tc: O(B + log x)
    sc: O(log x)
 */
public class VeryLargePower {

    public static void main(String[] args) {

        System.out.println(bruteForce(2, 27));
        System.out.println(optimized(2, 27));
        System.out.println(bestSolution(2, 27));

    }

    // tc: O(B + log x)
    // sc: O(log x)
    private static int bestSolution(int A, int B) {

        int m = (int) Math.pow(10,9) + 7;
        int x = 1;

        for(int i=B; i>=1; i--) {
            x = (int)((long)x%(m-1) * i%(m-1))%(m-1);
        }

        return powerFunction(A, x, m);
    }

    private static int powerFunction(int a, int pow, int mod) {

        if(pow == 0) {
            return 1;
        }

        long halfPower = powerFunction(a, pow/2, mod);

        long ans = 0;

        if((pow&1) == 1) {
            ans = (halfPower%mod * halfPower%mod * a%mod)%mod;
        } else {
            ans = (halfPower%mod * halfPower%mod)%mod;
        }

        return (int) ans;
    }

    // tc: O(B * log B)
    private static int optimized(int A, int B) {

        int ans = A;
        int mod = (int) Math.pow(10,9) + 7;

        for(int i=B; i>=1; i--) {
            ans = powerFunction(ans, i, mod)%mod;
        }

        return ans;
    }

    private static int powerFunction(int a, long pow, int mod) {

        if(pow == 0) {
            return 1;
        }

        long halfPower = powerFunction(a, pow/2, mod);

        long ans = 0;

        if((pow&1) == 1) {
            ans = (halfPower%mod * halfPower%mod * a%mod)%mod;
        } else {
            ans = (halfPower%mod * halfPower%mod)%mod;
        }

        return (int) ans;
    }

    // tc: O(B) + O(log B!)
    private static int bruteForce(int A, int B) {

        long factorial = 1;
        int mod = (int) Math.pow(10,9) + 7;

        for(int i=B; i>=1; i--) {
            factorial = factorial * i;
        }

        return powerFunction2(A, factorial, mod);
    }

    private static int powerFunction2(int a, long pow, int mod) {

        if(pow == 0) {
            return 1;
        }

        long halfPower = powerFunction2(a, pow/2, mod);

        long ans = 0;

        if((pow&1) == 1) {
            ans = (halfPower * halfPower * a)%mod;
        } else {
            ans = (halfPower * halfPower)%mod;
        }

        return (int) ans;
    }
}
