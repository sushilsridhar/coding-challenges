package queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
    Given a stream of characters, after adding every character, find the first non repeating character so far
    s contains {a..z}

    a b c a d e d a b e c g -> streams
    a a a b b b b b c c # g -> answer

    solution same as FirstNonRepeatingChar,
    1. tc: O(n^2) sc: O(k)
    2. tc: O(n*k) sc: O(k)

    approach:
    useful for multiple queries

    create a candidate list for potential answers, append them to queue,
    for each query, check if top of the queue is correct answer, if not remove them,
    the next ele in queue would be the answer

    tc: O(n + k), we are adding to the queue k times, removing can be done only <=k times, so n + k
    sc: O(k), k is the alphabet set, hashmap contains k space and queue also contains k space at max

 */
public class FirstNonRepeatingCharStreams {

    public static void main(String[] args) {

        String a = "abcadedabecg";
        char[] ans = efficient(a);

        for(int i=0; i<a.length(); i++) {
            System.out.print(a.charAt(i)+" ");
        }

        System.out.println();

        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    private static char[] efficient(String a) {
        char[] r = new char[a.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for(int i=0; i<a.length(); i++) {
            char x = a.charAt(i);

            if(map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
                queue.add(x);
            }

            while(!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.poll();
            }

            if(queue.isEmpty()) {
                r[i] = '#';
            } else {
                r[i] = queue.peek();
            }
        }

        return r;
    }
}
