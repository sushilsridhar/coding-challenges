package queues.deque;

import java.util.ArrayDeque;

/*
    Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.

    Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

    Refer to the given example for clarity.

    NOTE: If B > length of the array, return 1 element with the max of the array.

    explanation:
     A = [1, 3, -1, -3, 5, 3, 6, 7]
     B = 3

      Window position     | Max
     --------------------|-------
     [1 3 -1] -3 5 3 6 7 | 3
     1 [3 -1 -3] 5 3 6 7 | 3
     1 3 [-1 -3 5] 3 6 7 | 5
     1 3 -1 [-3 5 3] 6 7 | 5
     1 3 -1 -3 [5 3 6] 7 | 6
     1 3 -1 -3 5 [3 6 7] | 7

     approach:
     maintain a deque which stores the elements in decreasing order

     11 10 7 6 5 , if encounter a large element, remove the smaller elements that it
     11 10 8

     use sliding window technique

     tc: O(n),
     sc: O(k)
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int A[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] r = slidingMaximum(A, 3);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    public static int[] slidingMaximum(final int[] A, int B) {
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
