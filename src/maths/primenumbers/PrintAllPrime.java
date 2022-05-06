package maths.primenumbers;

/*
    algorithm: seive of eratosthenes

    Given a number n, print all prime numbers from 1 to n

    20 -> 2 3 5 7 11 13 17 19

    seive of eratosthenes time complexity

    i=2, inner loop runs n/2 times , if n = 50, numbers of factors of 2 less than 50 is 25
    i=3, inner loop runs n/3 times
    i=5, inner loop runs n/5 times
    i=7, inner loop runs n/7 times

    1/2 + 1/3 + 1/5 + 1/7 ... -> sum of reciprocal all prime numbers from 1 to n

    1/2 + 1/3 + 1/4 + 1/5 + 1/6 + 1/7 ...  -> sum of reciprocal all numbers from 1 to n  (tc: O(logn))

    sum of reciprocal all prime numbers from 1 to n < sum of reciprocal all numbers from 1 to n

    tc(sum of reciprocal all prime numbers from 1 to n) < log n

    tc: upper bound -> O(n * logn)

 */
public class PrintAllPrime {

    public static void main(String[] args) {

        bruteForce(20);

        System.out.println("");

        sieveOfEratosthenes(20);
    }

    private static void sieveOfEratosthenes(int n) {

        boolean[] fabric = new boolean[n+1];
        for(int i=2; i<=n; i++) {
            fabric[i] = true;
        }

        for(int i=2; i<=n; i++) {

            if(fabric[i]) {
                System.out.print(i+" ");
                for(int j=i*2; j<=n; j=j+i) {
                    fabric[j] = false;
                }
            }
        }
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
