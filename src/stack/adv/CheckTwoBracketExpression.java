package stack.adv;

import java.util.Stack;

/*
    Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
    The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.

    NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.

    -(a+b-c+d-(e-f)+g)
    -(a+b-c+d-(e-(-f))+g)

    -a-b+c-d+e-f-g
    -a-b+c-d+e+f-g , these two expressions are not same

    A = "-(a+b+c)"
    B = "-a-b-c" , these two are same expressions

    approach:

    find out the signs of each operands(a,b,c..) and save it in another array
    if we encounter inner brackets,
    have the sign before the opening braces and global sign from stack , multiple it and push it to stack,
    this sign becomes the global sign for the operands inside the braces

    to calculate the sign of operand, peek from stack, to get global sign and get the sign using getAdjacent method

    tc: O(n+m), length of string a and b
    sc: O(k), k is number of pair of braces present
 */
public class CheckTwoBracketExpression {

    public static void main(String[] args) {
        String A = "a-b-(c-d)";
        String B = "a-b-c-d";

        System.out.println(solution(A, B));
    }

    public static int solution(String A, String B) {

        int[] signsOfStringA = new int[26];
        int[] signsOfStringB = new int[26];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        populateSigns(A, signsOfStringA, stack);
        populateSigns(B, signsOfStringB, stack);

        for(int i=0; i<26; i++) {
            if(signsOfStringA[i] != signsOfStringB[i]) {
                return 0;
            }
        }

        return 1;
    }

    private static void populateSigns(String s, int[] signsArray, Stack<Integer> stack) {

        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i) == '+' || s.charAt(i) == '-')
                continue;
            else if(s.charAt(i) == '(') {
                int localSign = getAdjacent(s, i);
                int globalSign = stack.peek();
                int innerGlobalSign = localSign * globalSign;

                stack.push(innerGlobalSign);
            } else if(s.charAt(i) == ')') {
                stack.pop();
            } else {
                int localSign = getAdjacent(s, i);
                int globalSign = stack.peek();
                int signOfVariable = localSign * globalSign;

                signsArray[s.charAt(i) - 'a'] = signOfVariable;
            }
        }
    }

    private static int getAdjacent(String s, int i) {
        if(i == 0) {
            return 1;
        } else if(s.charAt(i-1) == '(' || s.charAt(i-1) == '+') {
            return 1;
        }
        return -1;
    }
}

