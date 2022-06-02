package stack.adv;

import java.util.Stack;

/*
    You are given a string A.
    An operation on the string is defined as follows:
    Remove the first occurrence of the same consecutive characters. eg for a string "abbcd",
    the first occurrence of same consecutive characters is "bb".

    Therefore the string after this operation will be "acd".
    Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.

    abccbc
    ac - output

    keep inserting in stack, if ele already found before insertion, pop that element

    tc: O(n)
    sc: O(n)
 */
public class DoubleCharacterTrouble {

    public static String removeConsecutive(String A) {

        Stack<Character> stack = new Stack<>();

        for(int i=A.length()-1; i>=0; i--) {
            char ch = A.charAt(i);

            if(!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder builder = new StringBuilder();

        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String A = "abccbc";
        System.out.println(removeConsecutive(A));
    }
}
