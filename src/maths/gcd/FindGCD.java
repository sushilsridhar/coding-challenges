package maths.gcd;

/*
    Find the gcd of two numbers, a and b, provided a and b > 0

    5 is the gcd
    15 -> 1 3  5 15
    25 -> 1 5 25

    euclidean algorithm
    tc: O(log(max(a,b)))
 */
public class FindGCD {

    public static void main(String[] args) {

        System.out.println(bruteForceGCD(15, 25));
        System.out.println(gcd(15, 25));

        System.out.println(euclidean(15,25));
        System.out.println(euclideanAlgo(15,25));

    }

    // tc: O(log(max(a,b)))
    private static int euclideanAlgo(int A, int B) {

        if(B == 0) {
            return A;
        }

        return euclideanAlgo(B, A%B);
    }

    // tc: O(log(max(a,b)))
    private static int euclidean(int A, int B) {

        if(A < B) {
            int temp = B;
            B = A;
            A = temp;
        }

        if(B == 0) {
            return A;
        }

        return gcd(A-B, B);
    }

    // tc: O(sqrt(min(a,b))
    private static int gcd(int a, int b) {
        int x = Math.min(a,b);
        int y = Math.max(a,b);

        for(int i = (int) Math.sqrt(x); i>=1; i--) {
            if(x%i == 0) {
                // 2 factors are there , if i is factor, x/i is also a factor,
                // since we are using sqrt root, we need to consider two factors in single iteration

                int anotherFactorOfX = x/i; // this factor will always be the greatest factor than i

                if(y%anotherFactorOfX == 0) {
                    return anotherFactorOfX;
                } else if(y%i == 0) {
                    return i;
                }
            }
        }

        return 1;
    }

    // tc: O(minValue(a,b))
    private static int bruteForceGCD(int a, int b) {

        for(int i=Math.min(a,b); i>=1; i--) {
            if((a%i == 0) && (b%i == 0)) {
                return i;
            }
        }

        return 1;
    }
}
