package bitmanipulation.adv;

/*
    Divide two integers without using multiplication, division and mod operator.
    Return the floor of the result of the division.
    Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

    NOTE: INT_MAX = 2^31 - 1

    brute force edge case:
    -2147483648/ -1 -> 2147483648 ( which is > INT MAX), so return 2147483647 ( Integer MAX)
    -2147483648/ 1  -> -2147483648 , return A

    approach:

    81/3 = 27

    3 * 27 = 81, we need to plot 27 in the binary representation

    64   32   16   8    4    2    1
    2^6  2^5  2^4  2^3  2^2  2^1  2^0
    0    0    1    1    0    1    1

    3 * 2^6 = 192 <= 81
    3 * 2^5 = 96  <= 81
    3 * 2^4 = 48  <= 81, set the 2^4 bit as 1, subtract 81-48
    3 * 2^3 = 24  <= 33, set 1
    3 * 2^2 = 12  <= 9
    3 * 2^1 = 6   <= 9 , set 1
    3 * 2^0 = 3   <= 3 , set 1

    81/1
    1 * 81 = 81

    64   32   16   8    4    2    1
    2^6  2^5  2^4  2^3  2^2  2^1  2^0
    1    0    1    0    0    0    1

    1 * 2^6 = 64  <= 81, set 1 , 81-64 = 17
    1 * 2^5 = 32  <= 17,
    1 * 2^4 = 16  <= 17, set 1, 17-16 = 1
    1 * 2^3 = 8   <= 1,
    1 * 2^2 = 4   <= 1,
    1 * 2^1 = 2   <= 1,
    1 * 2^0 = 1   <= 1, set 1, 1-1 = 0
 */
public class DivideIntegers {

    public static void main(String[] args) {

        System.out.println(bruteForce(81, 3)); // ans = 27
        System.out.println(optimized(81, 3));
    }

    // tc: O(1), sc: O(1)
    private static int optimized(int A, int B) {
        long a = A;
        long b = B;
        int sign = 1;

        if(a < 0) {
            sign = -sign;
        }
        if(b < 0) {
            sign = -sign;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        long q = 0;
        for(int i=31; i>=0; i--) {
            if((b<<i) <= a) {
                a = a - (b<<i);
                q = q + (1L<<i);

                if(a == 0) {
                    break;
                }
            }
        }

        if(q > Integer.MAX_VALUE && sign == 1) {
            return Integer.MAX_VALUE;
        }

        return sign * (int) q;
    }

    // tc: o(q) , where q is quotient
    private static int bruteForce(int A, int B) {
        int q = 0;
        int sign = 1;

        if(A == B) {
            return 1;
        }

        if(A < 0 && B < 0) {
            sign = 1;
        } else if(A<0 || B<0) {
            sign = -1;
        }

        long a = A;
        long b = B;
        a = Math.abs(a);
        b = Math.abs(b);

        if(a > Integer.MAX_VALUE && b == 1) { // edge case
            if(sign == -1) {
                return (int) -a;
            }
            return Integer.MAX_VALUE;
        }

        if(b == 1 || a == 0) {
            return sign * (int) a;
        }

        while(a>=b) {
            a = a - b;
            q++;
        }

        return (int) sign * q;
    }
}
