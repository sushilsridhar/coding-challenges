package queues;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given an integer A, you have to find the Ath Perfect Number.

    A Perfect Number has the following properties:

    It comprises only 1 and 2.
    The number of digits in a Perfect number is even.
    It is a palindrome number.

    For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

    example:
    A = 3

    First four perfect numbers are:
    1. 11
    2. 22
    3. 1111
    4. 1221

    tc: O(k)
    sc: O(k)
 */
public class PerfectNumbers {

    public static void main(String[] args) {

        System.out.println(solve(4));
    }

    private static String solve(int A) {

        if(A == 1)
            return "11";

        if(A == 2)
            return "22";

        Queue<String> queue = new LinkedList<>();
        String ans = "";

        queue.add("11");
        queue.add("22");

        int count = 0;
        while(count < A) {
            String a = queue.poll();
            ans = a;

            String firstPart = a.substring(0, a.length()/2);
            String lastPart = a.substring(a.length()/2, a.length());

            String generated = firstPart + "11" + lastPart;
            String generated1 = firstPart + "22" + lastPart;

            queue.add(generated);
            queue.add(generated1);
            count++;
        }

        return ans;
    }
}
