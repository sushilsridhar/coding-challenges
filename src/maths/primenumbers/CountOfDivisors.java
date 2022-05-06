package maths.primenumbers;

/*
    algorithm: seive of eratosthenes

    Given a integer n, return an array containing the count of divisors of all elements from 1 to n.

    N = 5
    1 2 3 4 5
    1 2 2 3 2 = no of divisors

    seive of eratosthenes time complexity

    i=2, inner loop runs n/2 times , if n = 50, numbers of factors of 2 less than 50 is 25
    i=3, inner loop runs n/3 times
    i=4, inner loop runs n/4 times
    i=5, inner loop runs n/5 times
    i=6, inner loop runs n/6 times
    i=7, inner loop runs n/7 times
    i=n, inner loop runs 1 times

    1 + 1/2 + 1/3 + 1/4 + 1/5 + 1/6 + 1/7 ... -> log n

    tc: O(n * logn)
    sc: O(1)
 */
public class CountOfDivisors {

    public static void main(String[] args) {

        int[] r1 = seiveOfEratosthenes(5);

        for(int i: r1) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n * logn)
    private static int[] seiveOfEratosthenes(int n) {
        int[] r = new int[n];

        int[] fabric = new int[n+1];
        fabric[1] = 1;
        for(int i=2; i<=n; i++) {
            fabric[i] = 2;
        }

        for(int i=2; i<=n; i++) {
            for(int j = i*2; j<=n; j= j+i) {
                fabric[j]++;
            }
        }

        return fabric;
    }
}
