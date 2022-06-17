package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    Given a queue, reverse the first k elements in queue

    1 2 9 3 7 6

    3 9 2 1 7 6

    tc: O(n)
    sc: O(k), k elements are stored in stack
 */
public class ReverseKElements {

    public static void main(String[] args) {

        Queue<Integer> queue = createQueue();

        //printQueue(queue);

        printQueue(reverseQueue(queue, 4));

    }

    private static Queue<Integer> reverseQueue(Queue<Integer> queue, int k) {
        Queue<Integer> r = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while(!queue.isEmpty() && i<k) {
            stack.push(queue.poll());
            i++;
        }

        while(!stack.isEmpty()) {
            r.add(stack.pop());
        }

        while(!queue.isEmpty()) {
            r.add(queue.poll());
        }

        return r;
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    private static Queue<Integer> createQueue() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(9);
        queue.add(3);
        queue.add(7);
        queue.add(6);

        return queue;
    }

    private static void printQueue(Queue<Integer> q) {

        while(!q.isEmpty()) {
            System.out.print(q.poll()+" ");
        }
    }
}
