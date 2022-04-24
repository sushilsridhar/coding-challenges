package maths.modulararthimetic;

/*
    Implement power function

    Implement pow(A, B) % C.
    In other words, given A, B and C, Find (A^B % C).

    Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative

    constraints:
    -109 <= A <= 109
    0 <= B <= 109
    1 <= C <= 109

    explanation:
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

    Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.

    Note:
    -1%20 = -1, but we need to add 20 --> (20-1)%20 = 19%20 = 19, is the answer, we do this to avoid negative results

    5%20 = 5, eg, +20 on top, 25%20 = 5, both are same

    power = ((long)halfPower%m * halfPower%m * (a%m + m)) % m;

    a%m + m will handle negative a, and convert to positive number
 */
public class PowerFunction {

    public static void main(String[] args) {

        int a = 2, n = 3, m = 3; // (2^3)%3 = 2

        System.out.println(powerFunction(a, n, m));

    }

    //    Time complexity: O(log n)
    //    Space complexity: O(log n)
    private static int powerFunction(int a, int n, int m) {

        if(a == 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        int halfPower = powerFunction(a, n/2, m);
        long power = 0;

        if(n%2 == 1) { // TODO casting explore more
            power = ((long)halfPower%m * halfPower%m * (a%m + m)) % m;
        } else {
            power = ((long)halfPower%m * halfPower%m) % m;
        }

        return (int)power;
    }
}
