package maths;

/*
    Given an integer A, find and return the Ath magic number.
    A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.

    First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5)

    A = 10, ans = 650

    5^4 5^3 5^2      5^1
    0   0   0        5^1 *1  - 5   - 1st magical number
    0   0  (5^2)*1   0       - 25  - 2nd magical number
    0   0  (5^2)*1   5^1 *1  - 30  - 3rd magical number
 */
public class NthMagicalNumber {

    public static void main(String[] args) {

        System.out.println(findMagicalNumber(10));
        System.out.println(findMagicalNumber(25));
        System.out.println(findMagicalNumber(100));

    }

    // tc: O(1), without power function, might cause overflow
    private static int findMagicalNumber(int n) {
        int ans = 0;
        int powVal = 1;

        for(int i=0; i<31; i++) {
            powVal = powVal * 5;

            if((n & (1<<i)) > 0) {
                ans = ans + powVal;
            }
        }
        return ans;
    }

    // with power function
    public int solve(int A) {

        int ans = 0;

        for(int i=0; i<31; i++) {

            if((A & (1<<i)) > 0) {
                ans = ans + (int) Math.pow(5,i+1);
            }
        }
        return ans;
    }
}
