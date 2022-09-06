package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*
    Given an integer array A of size N.
    You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N
    Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1
         0   1   2  3
    A = [10, 2, 13, 4]

    output:  [-1, -1, 260, 520]

    For i = 0, ans = -1
    For i = 1, ans = -1
    For i = 2, ans = 10 * 2 * 13 = 260
    For i = 3, ans = 10 * 13 * 4 = 520

    So, the output is [-1, -1, 260, 520]

    approach:

    use a max heap, so that top 3 largest elements can be maintained and retrieved in max heap

    addition to heap, takes log n tc, total n times we are adding,

    tc: O(nlogn)
    sc: O(n), space of the heap
 */
public class ProductOf3 {

    private static int[] solve(int[] A) {
        int[] r = new int[A.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<A.length; i++) {

            pq.add(A[i]);

            if(i < 2) {
                r[i] = -1;
            } else {
                int x = pq.poll();
                int y = pq.poll();
                int z = pq.poll();

                r[i] = x * y * z;

                pq.add(x);
                pq.add(y);
                pq.add(z);
            }
        }
        return r;
    }

    public static void main(String[] args) {

        int[] a = {10, 2, 13, 4};

        int[] r = solve(a);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }
}
