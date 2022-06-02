package stack.adv;

import java.util.HashMap;
import java.util.Stack;

/*
    Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
    String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

    Find and return the postfix expression of A.

    NOTE:
    ^ has the highest precedence.
    / and * have equal precedence but greater than + and -.
    + and - have equal precedence and lowest precedence among given operators.

    infix:   a+b*(c^d-e)^(f+g*h)-i
    postfix: abcd^e-fgh*+^*+i-

    tc: O(n)
    sc: O(n)
 */
public class InfixToPostfix {

    static HashMap<Character, Integer> precedenceOfOperators = new HashMap<>();
    static Stack<Character> stack = new Stack<>();

    static {
        precedenceOfOperators.put('^', 3);
        precedenceOfOperators.put('/', 2);
        precedenceOfOperators.put('*', 2);
        precedenceOfOperators.put('+', 1);
        precedenceOfOperators.put('-', 1);
        precedenceOfOperators.put('(', 0);
    }


    public static String infixToPostfix(String A) {

        StringBuilder builder = new StringBuilder();

        for(int i=0; i<A.length(); i++) {
            char ch = A.charAt(i);

            if(ch == '^') {
                predenceCheck(ch, builder);
                stack.push(ch);
            } else if(ch == '/') {
                predenceCheck(ch, builder);
                stack.push(ch);

            } else if(ch == '*') {
                predenceCheck(ch, builder);
                stack.push(ch);

            } else if(ch == '+') {
                predenceCheck(ch, builder);
                stack.push(ch);

            } else if(ch == '-') {
                predenceCheck(ch, builder);
                stack.push(ch);

            } else if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {

                while(stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                stack.pop();

            } else {
                builder.append(ch);
            }
        }

        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    private static void predenceCheck(char ch, StringBuilder builder) {

        int chPrecedence = precedenceOfOperators.get(ch);

        while(!stack.isEmpty() && chPrecedence <= precedenceOfOperators.get(stack.peek())) {
            builder.append(stack.pop());
        }
    }

    public static void main(String[] args) {

        String a = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(a));
    }
}
