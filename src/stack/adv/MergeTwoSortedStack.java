package stack.adv;

import java.util.Stack;

/*
    Given two sorted stack, merge them

    3 5 10 15
    2 4 6 7 9

    2 3 4 5 6 7 9 10 15

    tc: O(n+m)
    sc: O(n+m)

    TODO: how to find the methods present in the class programmatically, methods of stack class
 */
public class MergeTwoSortedStack {

    private static Stack<Integer> merge(Stack<Integer> stack1, Stack<Integer> stack2) {
        Stack<Integer> newStack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        while(!stack1.empty() && !stack2.empty()) {

            if(stack1.peek() > stack2.peek())
                newStack.push(stack1.pop());
            else
                newStack.push(stack2.pop());
        }

        while(!stack1.empty()) {
            newStack.push(stack1.pop());
        }

        while(!stack2.empty()) {
            newStack.push(stack2.pop());
        }

        while(!newStack.empty()) {
            resultStack.push(newStack.pop());
        }

        return resultStack;
    }

    public static void main(String[] args) {

        Stack<Integer> stack1 = createStack();
        Stack<Integer> stack2 = createStackTwo();

        Stack<Integer> rstack = merge(stack1, stack2);

        printStack(rstack);
    }


    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */

    private static Stack<Integer> createStack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(5);
        stack.push(10);
        stack.push(15);

        return stack;
    }

    private static Stack<Integer> createStackTwo() {
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(7);
        stack.push(9);

        return stack;
    }

    private static void printStack(Stack<Integer> rstack) {
        while(!rstack.empty()) {
            System.out.print(rstack.pop()+" ");
        }
        System.out.println("");
    }
}
