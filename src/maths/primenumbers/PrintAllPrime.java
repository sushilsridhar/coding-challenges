package maths.primenumbers;

/*
    Given a number n, print all prime numbers from 1 to n

    20 -> 2 3 5 7 11 13 17 19
 */
public class PrintAllPrime {

    public static void main(String[] args) {

        bruteForce(20);

    }

    // tc: O(n * sqrt(n))
    private static void bruteForce(int n) {

        for(int i=2; i<=n; i++) {
            if(isPrime(i)) {
                System.out.print(i+" ");
            }
        }
    }

    private static boolean isPrime(int n) {

        for(int i=2; i*i<=n; i++) { // if we use i<=Math.sqrt(n), it takes extra logn time to calculate square root
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
