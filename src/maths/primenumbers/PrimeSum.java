package maths.primenumbers;

/*
    algorithm: seive of eratosthenes

    Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

    If there is more than one solution possible, return the lexicographically smaller solution.

    If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
    [a, b] < [c, d], If a < c OR a==c AND b < d.
    NOTE: A solution will always exist. Read Goldbach's conjecture.

    constraints: 4 <= A <= 2*107

    4 -> 2,2
    8 -> 3,5
    16-> 3,13

    tc: O(A * sqrt(A))

    tc: seive of eratosthenes -> O(n * logn)
 */
public class PrimeSum {
    public static void main(String[] args) {

        int [] r = primesum(8);
        for(int i: r) {
            System.out.print(i+" ");
        }

        System.out.println(" ");

        int [] r1 = primesum(16);
        for(int i: r1) {
            System.out.print(i+" ");
        }

        System.out.println(" ");

        int[] r2 = seiveOfEratosthenes(16);
        for(int i: r2) {
            System.out.print(i+" ");
        }
    }

    // tc: O(A + A * logA + A) -> O(A * log A)
    private static int[] seiveOfEratosthenes(int A) {

        int[] r = new int[2];

        boolean[] fabric = new boolean[A+1];
        fabric[1] = false;

        for(int i=2; i<=A; i++) {
            fabric[i] = true;
        }

        for(int i=2; i<=A; i++) {

            if(fabric[i]) {

                for(int j=i*2; j<=A; j=j+i) {
                    fabric[j] = false;
                }
            }
        }

        for(int i=2; i<=A/2; i++) {

            int j = A-i;

            if(fabric[i] && fabric[j]) {
                r[0] = i;
                r[1] = j;
                return r;
            }
        }

        return r;
    }

    // tc: O(A * sqrt(A))
    private static int[] primesum(int A) {

        int[] r = new int[2];

        for(int i=2; i<=A/2; i++) {

            int j = A-i;

            if(isPrime(i, j)) {
                r[0] = i;
                r[1] = j;
                return r;
            }
        }

        return r;
    }

    private static boolean isPrime(int x, int y) {

        boolean xIsPrime = true;
        boolean yIsPrime = true;

        for(int i=2; i*i<=x; i++) {
            if(x%i == 0) {
                xIsPrime = false;
                break;
            }
        }

        for(int i=2; i*i<=y; i++) {
            if(y%i == 0) {
                yIsPrime = false;
                break;
            }
        }

        return xIsPrime && yIsPrime;
    }
}
