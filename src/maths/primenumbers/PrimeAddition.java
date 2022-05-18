package maths.primenumbers;

/*
    You are given an even number N and you need to represent the given number as the sum of primes.
    The prime numbers do not necessarily have to be distinct. It is guaranteed that at least one possible solution exists.
    You need to determine the minimum number of prime numbers needed to represent the given number.

    Constraints:
    The first argument contains an integer N,the number you need to represent (3<=N<=10^9)

    A = 26,

    23 + 3
    19 + 7
    13 + 13,

    approach:

    Goldbach's conjecture states that every even integer greater than 2 can be expressed as the sum of two primes.
    Bonus : This conjecture is not proven yet but verified uptil 4*10^18 integers.

    tc: O(1)
 */
public class PrimeAddition {

    public static void main(String[] args) {

        System.out.println(bruteForce(26));
        System.out.println(optimized(26));
    }

    // tc: O(1)
    private static int optimized(int A) {
        if(A == 2) {
            return 1;
        }
        return 2;
    }

    // heap exception for larger inputs
    // tc: O(n * logn)
    // sc: O(n)
    private static int bruteForce(int A) {
        int n = A;
        boolean[] fabric = new boolean[n+1];
        fabric[1] = false;

        for(int i=2; i<=n; i++) {
            fabric[i] = true;
        }

        for(int i=2; i<=n; i++) {
            if(fabric[i]) {
                for(int j=i*2; j<=n; j=j+i) {
                    fabric[j] = false;
                }
            }
        }

        for(int i=2; i<=A; i++) {
            if(fabric[i] && fabric[A-i]) {
                return 2;
            }
        }

        return 1;
    }
}
