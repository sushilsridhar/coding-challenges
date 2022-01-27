package stack;

import java.util.Stack;

/*
    Given a string A consisting only of '(' and ')'.

    You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.

    A = "(()())" - Balanced
    A = "))(((())" - unbalanced, even though number of ( and ) are same
 */
public class BalancedParantheses {

    public static void main(String[] args) {

        String a = "(()())";
        String b = "))(((())";

        System.out.println(solve(a));
        System.out.println(solve(b));
    }

    public static int solve(String A) {

        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<A.length(); i++) {
            char currentChar = A.charAt(i);

            if(currentChar == '(') {
                stack.push('(');
            } else if(currentChar == ')') {
                if(stack.empty()) {
                    return 0;
                }
                stack.pop();
            }
        }

        if(stack.empty()) {
            return 1;
        }

        return 0;
    }

}
