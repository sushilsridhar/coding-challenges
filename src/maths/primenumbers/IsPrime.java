package maths.primenumbers;

/*
    Given a number n, return true if it is a prime number else false

    i = 1, n/i is also factor

    11 -> ignore 1 and 11, see if there are other factors

    tc: O(sqrt(n))
 */
public class IsPrime {

    public static void main(String[] args) {

        System.out.println(sol(11));
        System.out.println(sol(9));

    }

    // tc: O(sqrt(n))
    private static boolean sol(int n) {

        for(int i=2; i*i<=n; i++) { // if we use i<=Math.sqrt(n), it takes extra logn time to calculate square root
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
