package stack.adv;

import java.util.Stack;

/*
    There is a football event going on in your city. In this event, you are given A passes and players having ids between 1 and 106.
    Initially, some player with a given id had the ball in his possession. You have to make a program to display the id of the player who possessed the ball
    after exactly A passes.

    There are two kinds of passes:
    1) ID
    2) 0

    For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.
    For the second kind of pass, the player in possession of the ball passes the ball back to the player who had forwarded the ball to him.
    In the second kind of pass "0" just means Back Pass.

    Return the ID of the player who currently possesses the ball

    explanation:
     Initially, Player having  id = 23  posses ball.
     After pass  1,  Player having  id = 86  posses ball.
     After pass  2,  Player having  id = 63  posses ball.
     After pass  3,  Player having  id = 60  posses ball.
     After pass  4,  Player having  id = 63  posses ball.
     After pass  5,  Player having  id = 47  posses ball.
     After pass  6,  Player having  id = 63  posses ball.
     After pass  7,  Player having  id = 99  posses ball.
     After pass  8,  Player having  id = 9   posses ball.
     After pass  9,  Player having  id = 99  posses ball.
     After pass  10, Player having  id = 63  posses ball.

    tc: O(n)
    sc: O(n)
 */
public class PassingGame {

    private static int solve(int A, int B, int[] C) {

        Stack<Integer> stack = new Stack<>();
        stack.push(B);

        for(int i=0; i<C.length; i++) {

            if(C[i] == 0) {
                stack.pop();
            } else {
                stack.push(C[i]);
            }
        }

        return stack.peek();
    }


    public static void main(String[] args) {
        int A = 10;
        int B = 23;
        int[] C = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};

        System.out.println(solve(A, B, C));
    }
}
