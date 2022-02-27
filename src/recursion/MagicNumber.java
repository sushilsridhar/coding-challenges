package recursion;

/*
    Given a number A, check if it is a magic number or not.

    A number is said to be a magic number, if the sum of its digits are calculated till a single digit recursively by adding
    the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.

    Sum of digits of (83557) = 28
    Sum of digits of (28) = 10
    Sum of digits of (10) = 1.
    Single digit is 1, so it's a magic number. Return 1.

    efficient approach
    The divisibility rule of 9 says that a number is divisible by 9 if the sum of its digits are also divisible by 9.
    Therefore, if a number is divisible by 9, then, recursively, all the digit sums are also divisible by 9.
    The final digit sum is always 9. An increase of 1 in the original number will increase the ultimate value by 1,
    making it 10 and the ultimate sum will be 1, thus verifying that it is a magic number.

    if(A%9 == 1){
        return 1;
    }
    return 0;
 */
public class MagicNumber {

    public static void main(String[] args) {

        System.out.println(solve(83557));
    }

    // tc: O(n), where n is number of digits
    // sc: O(n)
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
