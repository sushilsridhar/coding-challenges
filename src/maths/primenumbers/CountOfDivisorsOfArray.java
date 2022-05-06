package maths.primenumbers;

/*
    algorithm: seive of eratosthenes

    Given an array of integers A, find and return the count of divisors of each element of the array.

    A = [2, 3, 4, 5]
    ans = [2, 2, 3, 2]

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
public class CountOfDivisorsOfArray {

    public static void main(String[] args) {

        int[] A = {2, 3, 4, 5}; // ans [ 2, 2, 3, 2]

        int[] r = bruteForce(A);

        for(int i: r) {
            System.out.print(i+" ");
        }
        System.out.println("");

        int[] r1 = seiveOfEratosthenes(A);

        for(int i: r1) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n * logn)
    private static int[] seiveOfEratosthenes(int[] A) {
        int[] r = new int[A.length];

        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++) {
            max = Math.max(max, A[i]);
        }


        int[] fabric = new int[max+1];
        fabric[1] = 1;
        for(int i=2; i<=max; i++) {
            fabric[i] = 2;
        }

        for(int i=2; i<=max; i++) {
            for(int j = i*2; j<=max; j= j+i) {
                fabric[j]++;
            }
        }

        for(int i=0; i<A.length; i++) {
            r[i] = fabric[A[i]];
        }

        return r;
    }

    // tc: O(n * sqrt(n))
    private static int[] bruteForce(int[] A) {

        int[] r = new int[A.length];

        for(int i=0; i<A.length; i++) {
            r[i] = getFactorsCount(A[i]);
        }

        return r;
    }

    private static int getFactorsCount(int n) {
        int count = 0;
        for(int i=1; i*i<=n; i++) {

            if(n%i == 0) {
                count++;

                if(n/i != i) {
                    count++;
                }
            }
        }

        return count;
    }
}
