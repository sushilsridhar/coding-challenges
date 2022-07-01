package queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array,
    leaving the other elements in the same relative order.

    NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.

    input
    A = [1, 2, 3, 4, 5]
    B = 3

    ouput
    [3, 2, 1, 4, 5]

    tc: O(k)
    sc: O(k)
 */
public class ReverseKElementsUsingQueue {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};

        int[] r = solve(a, 3);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    private static int[] solve(int[] A, int B) {
        int k = B;
        Queue<Integer> queue = new LinkedList<>();

        int i = 0;
        while(i < k) {
            queue.add(A[i]);
            i++;
        }

        int j = k-1;
        while(!queue.isEmpty()) {
            A[j] = queue.poll();
            j--;
        }

        return A;
    }
}
