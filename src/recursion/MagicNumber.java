package recursion;

/*
    Given a number A, check if it is a magic number or not.

    A number is said to be a magic number, if the sum of its digits are calculated till a single digit recursively by adding
    the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.

    Sum of digits of (83557) = 28
    Sum of digits of (28) = 10
    Sum of digits of (10) = 1.
    Single digit is 1, so it's a magic number. Return 1.
 */
public class MagicNumber {

    public static void main(String[] args) {

        System.out.println(solve(83557));
    }

    public static int solve(int A) {

        while(A >= 10) {
            A = sumOfDigits(A);
        }

        if(A==1) {
            return 1;
        }
        return 0;
    }

    private static int sumOfDigits(int n) {

        if(n==0) {
            return 0;
        }

        return (n%10) + sumOfDigits(n/10);
    }
}
