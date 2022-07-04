package queues.deque;

import java.util.ArrayDeque;

/*
    Given an array A of both positive and negative integers.

    Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

    NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.

    Problem Constraints

    1 <= size of array A <= 105
    -109 <= A[i] <= 109
    1 <= B <= size of array

    explanation:
     A = [2, 5, -1, 7, -3, -1, -2]
     B = 4

     Subarrays of size 4 are :
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4
    Sum of all min & max = 6 + 4 + 4 + 4 = 18

    approach:

    have two deques,
    maxDequeue - maintain the numbers in decreasing order
    minDequeue - maintain the numbers in increasing order

    front of the deque has the max and min

    tc: O(n)
    sc: O(k)
 */
public class SumOfMinAndMax {

    public static void main(String[] args) {

        int A[] = {2, 5, -1, 7, -3, -1, -2};
        int r = solve(A, 4);
        System.out.println(r);
    }

    private static int solve(int[] A, int B) {

        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        ArrayDeque<Integer> minDeque = new ArrayDeque<>();

        int n = A.length;
        int k = B;
        long sum = 0;
        int mod = (int) Math.pow(10, 9) + 7;

        for(int i=0; i<k; i++) {

            while(!maxDeque.isEmpty() && maxDeque.peekLast() < A[i]) {
                maxDeque.pollLast();
            }

            while(!minDeque.isEmpty() && minDeque.peekLast() > A[i]) {
                minDeque.pollLast();
            }

            maxDeque.offerLast(A[i]);
            minDeque.offerLast(A[i]);
        }

        sum = maxDeque.peekFirst() + minDeque.peekFirst();

        for(int i=1; i<=n-k; i++) {
            int j = k - 1 + i;

            if(!maxDeque.isEmpty() && maxDeque.peekFirst() == A[i-1]) {
                maxDeque.pollFirst();
            }

            if(!minDeque.isEmpty() && minDeque.peekFirst() == A[i-1]) {
                minDeque.pollFirst();
            }

            while(!maxDeque.isEmpty() && maxDeque.peekLast() < A[j]) {
                maxDeque.pollLast();
            }

            while(!minDeque.isEmpty() && minDeque.peekLast() > A[j]) {
                minDeque.pollLast();
            }

            maxDeque.offerLast(A[j]);
            minDeque.offerLast(A[j]);

            long x = (sum%mod + mod)%mod;
            long y = (maxDeque.peekFirst()%mod + mod)%mod;
            long z = (minDeque.peekFirst()%mod + mod)%mod;

            sum = (x+y+z)%mod;

        }

        return (int) sum;
    }

}
