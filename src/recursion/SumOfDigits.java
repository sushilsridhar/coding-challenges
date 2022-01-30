package recursion;

/*
    Given a number, write a recursive code to calculate the sum of the digits of given number

    1234 -> 10
 */
public class SumOfDigits {

    public static void main(String[] args) {

        int n = 1234;
        System.out.println(sumOfDigits(n));
    }

    private static int sumOfDigits(int n) {

        if(n==0) {
            return 0;
        }

        int d = n%10;
        n = n/10;

        return sumOfDigits(n) + d;
    }
}
