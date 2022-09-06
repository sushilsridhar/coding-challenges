package heaps;

import java.util.PriorityQueue;

/*
    You are given an array A of integers that represent the lengths of ropes.
    You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

    Find and return the minimum cost to connect these ropes into one rope

    A = [5, 17, 100, 11]

    Given array A = [5, 17, 100, 11].
    Connect the ropes in the following manner:
    5 + 11 = 16
    16 + 17 = 33
    33 + 100 = 133

    So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182

    approach:

    choosing only the minimum ropes to connect will reduce the total cost

    5 + 100 = 105 , [ 105, 17, 11]
    105 + 17 = 122, [ 122 , 11]
    122 + 11 = 133, [ 133 ]

    total cost = 360

    pick rope of minimum size at each step,
    5 + 11 = 16
    16 + 17 = 33
    33 + 100 = 133

    total cost = 133

    construct a min heap, so that we can remove min size ropes and still maintain the min heap with ropes of smaller size first,

    adding and deleting from minheap take logn time,

    tc: O(nlogn)
    sc: O(n)
 */
public class ConnectRopes {

    // TODO
    public int solve(int[] A) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<A.length; i++) {
            minHeap.add(A[i]);
        }

        int cost = 0;
        while(minHeap.size() > 1) {
            int r1 = minHeap.poll();
            int r2 = minHeap.poll();

            int newRope = r1 + r2;
            cost = cost + newRope;

            minHeap.add(newRope);
        }

        return cost;
    }
}
