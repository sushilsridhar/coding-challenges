package queues.deque;

import java.util.ArrayDeque;

/*
    TODO
 */
public class SlidingWindowMaximum {

    public int[] slidingMaximum(final int[] A, int B) {
        int k = B;
        int n = A.length;
        int noOfSubarrayOfK = n-k+1;

        int[] r = new int[noOfSubarrayOfK];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<k; i++) {

            while(!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.pollLast();
            }

            deque.offerLast(A[i]);
        }

        r[0] = deque.peekFirst();

        for(int i=1; i<=n-k; i++) {
            int j = k - 1 + i;

            if(!deque.isEmpty() && deque.peekFirst() == A[i-1]) {
                deque.pollFirst();
            }

            while(!deque.isEmpty() && deque.peekLast() < A[j]) {
                deque.pollLast();
            }

            deque.offerLast(A[j]);
            r[i] = deque.peekFirst();
        }

        return r;
    }
}
