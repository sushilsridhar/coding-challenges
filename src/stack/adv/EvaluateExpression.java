package stack.adv;

import java.util.Stack;

/*
    An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each character may be an integer or an operator.

    A = ["4", "13", "5", "/", "+"]

    Explanation:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6

    tc: O(n)
    sc: O(no of operands)
 */
public class EvaluateExpression {

    public static void main(String[] args) {

        String[] A = {"4", "13", "5", "/", "+"};
        String[] B = {"2", "-", "1", "-", "2", "-"};
        System.out.println(evalRPN(B));
    }

    public static int evalRPN(String[] A) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<A.length; i++) {
            int b = 0;
            int a = 0;

            if(A[i].equals("+")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a+b);
            } else if(A[i].equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a-b);
            } else if(A[i].equals("*")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a*b);
            } else if(A[i].equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a/b);
            } else {
                int ele = Integer.parseInt(A[i]);
                stack.push(ele);
            }
        }

        return stack.pop();
    }
}
