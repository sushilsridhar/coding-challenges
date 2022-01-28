package stack;

import java.util.HashMap;
import java.util.Stack;

/*
    Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

    Refer to the examples for more clarity.

    A = {([])}  , output - 1

     A = (){    , output - 0
 */
public class BalancedParanthesisTwo {

    public static void main(String[] args) {

        String a = "{([])}";
        String b = "(){";
        System.out.println(solve(a));
        System.out.println(solve(b));
    }

    public static int solve(String A) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for(int i=0; i<A.length(); i++) {
            char currentChar = A.charAt(i);

            if(currentChar == '{' || currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            } else if(!stack.empty() && stack.peek() == map.get(currentChar)) {
                stack.pop();
            } else {
                return 0;
            }
        }

        if(stack.empty()) {
            return 1;
        }

        return 0;
    }
}
