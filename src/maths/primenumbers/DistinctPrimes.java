package maths.primenumbers;

import java.util.HashSet;

/*
    algorithm: seive of eratosthenes

    You have given an array A having N integers. Let say G is the product of all elements of A.
    You have to find the number of distinct prime divisors of G.

    constraints:
    1 <= N <= 1e5
    1 <= A[i] <= 1e5

    Input: A = [1, 2, 3, 4]
    Output: 2

    Explanation:
        here G = 1 * 2 * 3 * 4 = 24
        and distinct prime divisors of G are [2, 3]

    approach:

    a = { 4, 10, 3 }
    product of all array elements = x,
    x = 120
    4 * 10 * 3 = 120, sometimes multiplied value of array elements is too big,

    120 -> find all prime factors of 120, brute force approach with seive of eratosthenes

    instead, find individual prime factors of 4 * 10 * 3,

    4 -> 2
    10 -> 2, 5
    3 -> 3,

    total 3 prime factors

    start marking the factors of prime numbers,
    i=2, 2 is prime, all factors of two must be marked as non prime,
    if any factor of 2 present in A[], then 2 is a prime factor of x (product of all array elements)

    i=3 is prime, all factors of two must be marked as non prime,
    if any factor of 3 present in A[], then 3 is a prime factor of x (product of all array elements)

    i=5 is prime, all factors of two must be marked as non prime,
    if any factor of 5 present in A[], then 5 is a prime factor of x (product of all array elements)

    5 * 2 = 10, 10 present in array, so 5 is a prime factor of x

    tc: O(n * logn)
    sc: O(n + prime factors of x), where x is product of all elements of array
 */
public class DistinctPrimes {
    public static void main(String[] args) {

        int[] A = { 96, 98, 5, 41, 80 };
        int[] B = { 4, 10, 3 };

        System.out.println("bruteForce: "+bruteForce(A));
        System.out.println("seiveOfEratosthenesOptimized: "+seiveOfEratosthenesOptimized(A));
        System.out.println("bruteForce: "+bruteForce(B));
        System.out.println("seiveOfEratosthenesOptimized: "+seiveOfEratosthenesOptimized(B));
    }

    // tc: O(n + n + n * logn)
    // sc: O(n + prime factors of x), where x is product of all elements of array
    private static int seiveOfEratosthenesOptimized(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++) {
            max = Math.max(max, A[i]);
            set.add(A[i]);
        }

        HashSet<Integer> ansSet = new HashSet<>();
        int n = max;
        boolean[] fabric = new boolean[n+1];
        fabric[1] = false;

        for(int i=2; i<=n; i++) {
            fabric[i] = true;
        }

        for(int i=2; i<=n; i++) {
            if(fabric[i]) {
                for(int j=i; j<=n; j=j+i) {
                    fabric[j] = false;
                    if(set.contains(j)) {
                        ansSet.add(i);
                    }
                }
            }
        }

        return ansSet.size();
    }

    // tc: O(n + n + n * logn + n^2)
    // sc: O(n + prime factors of x), where x is product of all elements of array
    private static int bruteForce(int[] A) {

        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++) {
            max = Math.max(max, A[i]);
        }

        int n = max;
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

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++) {
            int ele = A[i];
            for(int j=2; j<=n; j++) {
                if(fabric[j] && (ele%j == 0)) {
                    set.add(j);
                }
            }
        }

        return set.size();
    }
}
