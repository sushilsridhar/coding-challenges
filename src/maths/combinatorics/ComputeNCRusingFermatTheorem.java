package maths.combinatorics;

/*
   Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n,
   find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

    x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
    NOTE: For this problem, we are considering 1 as a prime.

    constraints:
    1 <= A <= 106
    1 <= B <= A
    A <= C <= 109+7

    Brute force approach:

    we know that, (a * a^-1) % m = 1
    let a^-1 = x, if (a * x) % m = 1, then x is the inverse mod value
    the range of the x will be from 1 to m-1,
    simply iterate from 1 to m-1, for x, which satisfies this equation (a * x) % m = 1

    Optimized:

    nCr % m = (n! / ((n-r)! * r!)) % m

    5C3 % 7 = (5!/ 2! * 3!) % 7,
    given r <= n, we don't have to calculate n! and r! separately, subtract the r! while calculating n! itself

    5C3 % 7 = 4 * 5/ 2! = (4 * 5 * (2!) ^ -1 ) % m = (20%m * ((2!) ^ -1)%m ) % m
    applying fermat's theorem

    a^-1 % m = a^m-2 % m
    (3!) ^ -1)%m = (3!)^m-2 %m, calculate power using power function,

    m = 7, a^5 % 7

    (3! * 3! * 3! * 3! * 3!) % m -> this is what power function is doing, multiplying the a value n times,

    (3! %m * 3! %m * 3! %m * 3! %m * 3! %m) % m -> by this, apply %m while calculating the (n-r)! itself

    tc: O(n + nMinusR + log(nMinusRFactorial)) -> O(n)
 */
public class ComputeNCRusingFermatTheorem {

    public static void main(String[] args) {

        System.out.println(calculateNCR(5, 2, 13));
    }

    // tc: O(n + nMinusR + log(nMinusRFactorial))
    private static int calculateNCR(int A, int B, int C) {

        int n = A;
        int r = B;
        int m = C;
        int nMinusR = n - r;

        long nByRFactorial = 1;
        for(int i=r+1; i<=n; i++) {     // i starts from r+1, subtract the r! while calculating n! itself
            nByRFactorial = (nByRFactorial%m * i%m)%m;
        }

        long nMinusRFactorial = 1;
        for(int i=1; i<=nMinusR; i++) {
            nMinusRFactorial = (nMinusRFactorial%m * i%m)%m; // check note mentioned in top
        }

        int nMinusRFactorialInverseMod = powerFunction(nMinusRFactorial, m-2, m);

        long ans = (nByRFactorial%m * nMinusRFactorialInverseMod%m)%m;

        return (int) ans;
    }

    private static int powerFunction(long a, int n, int m) {

        if(a == 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        int halfPower = powerFunction(a, n/2, m);
        long power = 0;

        if(n%2 == 1) {
            power = ((long)halfPower%m * halfPower%m * (a%m + m)) % m;
        } else {
            power = ((long)halfPower%m * halfPower%m) % m;
        }

        return (int)power;
    }
}
