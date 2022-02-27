package recursion;

/*
    Implement pow(x, n) % d.
    In other words, given x, n and d, find (x^n % d)

    Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.

    Note:
    -1%20 = -1, but we need to add 20 --> (20-1)%20 = 19%20 = 19, is the answer, we do this to avoid negative results

    5%20 = 5, eg, +20 on top, 25%20 = 5, both are same


    ans = (int)(((long)pow%C * pow%C)%C); , to avoid overflow, convert the variable to long before modulo
 */
public class PowFunctionWithModulus {

    public static void main(String[] args) {

        int a = 2, b = 3, c = 3; // (2^3)%3 = 2

        System.out.println(pow(a,b,c));

    }

    public static int pow(int A, int B, int C) {

        if(A == 0) {
            return 0;
        }

        if(B == 0) {
            return 1;
        }

        int ans = 1;
        int pow = pow(A, B/2, C);
        if(B%2 == 0) {
            ans = (int)(((long)pow%C * pow%C)%C); // modular arithmetics
        } else {
            ans = (int)(((long)A%C * pow%C * pow%C)%C);
        }

        return (ans+C)%C; // check Note above
    }
}
