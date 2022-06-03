package stack.adv;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
    Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
    Check whether A has redundant braces or not.
    NOTE: A will be always a valid expression and will not contain any white spaces.

    A = "((a+b))" - redundant braces
    A = "(a+(a+b))"

    tc: O(n)
    sc: O(n)
 */
public class RedundantBraces {

    public static void main(String[] args) {

        System.out.println(braces("(a+(a+b))"));
        System.out.println(braces("((a+b))"));
    }

    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        Set<Character> operatorSet = new HashSet<>();
        operatorSet.add('+');
        operatorSet.add('-');
        operatorSet.add('*');
        operatorSet.add('/');

        for(int i=0; i<A.length(); i++) {
            char ch = A.charAt(i);

            if(ch == '(' || operatorSet.contains(ch)) {
                stack.push(ch);
            } else if(ch == ')') {

                if(stack.peek() == '(')
                    return 1;

                while(stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }
        return 0;
    }
}
