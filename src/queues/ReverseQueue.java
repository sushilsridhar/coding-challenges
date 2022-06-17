package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    Given a queue, reverse the queue

    1 2 9 3 7 6

    6 7 3 9 2 1

    tc: O(n)
    sc: O(n)
 */
public class ReverseQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = createQueue();

        //printQueue(queue);

        printQueue(reverseQueue(queue));

    }

    private static Queue<Integer> reverseQueue(Queue<Integer> queue) {

        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    private static Queue<Integer>  createQueue() {
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
