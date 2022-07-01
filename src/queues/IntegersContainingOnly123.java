package queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.

    NOTE: All the A integers will fit in 32-bit integers.

    k = 7
    1 2 3 11 12 13 21

    tc: O(k)
    sc: O(k)
 */
public class IntegersContainingOnly123 {

    public static void main(String[] args) {

        ArrayList<Integer> r = solve(7);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> solve(int A) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        if(A == 1) {
            list.add(1);
            return list;
        } else if(A == 2) {
            list.add(1);
            list.add(2);
            return list;
        } else if(A == 3) {
            list.add(1);
            list.add(2);
            list.add(3);
            return list;
        }

        queue.add(1);
        queue.add(2);
        queue.add(3);

        int count = 3;
        while(count < A) {
            int x = queue.poll();
            int i = 1;
            while(count < A && i <= 3) {
                queue.add(x*10+i);
                i++;
                count++;
            }
            list.add(x);
        }

        while(!queue.isEmpty()) {
            list.add(queue.poll());
        }

        return list;
    }
}
