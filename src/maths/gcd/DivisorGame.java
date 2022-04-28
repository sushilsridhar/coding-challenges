package maths.gcd;

/*
    Scooby has 3 three integers A, B, and C.

    Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
    You need to tell the number of special integers less than or equal to A.

    A = 12
    B = 3
    C = 2

    ans = 2
    The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.

    approach:

    least common multiple of 3 and 2 is 6

    - all the multiples of 6 is divisible by both 3 and 2
    - no number is not a multiple of 6 and divisble by 3 and 2

    find the multiples of 6 <= 12 -> solution

    gcd(b,c) * lcm(b,c) = b * c

    lcm(b,c) = (b * c)/gcd(b,c)

    4, 8, 12, 16... 100

    100/4 = 25, there are 25 multiples of 4 within 100
 */
public class DivisorGame {

    public static void main(String[] args) {

        System.out.println(bruteForce(12, 3, 2));
        System.out.println(optimized(12, 3, 2));
    }

    // tc: O(log(max(a,b)))
    private static int optimized(int A, int B, int C) {

        int gcd = gcd(B,C);

        int lcm = (B*C)/gcd;

        return A/lcm;
    }

    private static int gcd(int a, int b) {

        if(b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }

    // tc: O(A)
    private static int bruteForce(int A, int B, int C) {
        int count = 0;
        for(int i=1; i<=A; i++) {
            if(i%B == 0 && i%C == 0) {
                count++;
            }
        }
        return count;
    }

}
