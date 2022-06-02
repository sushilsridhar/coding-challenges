package stack.adv;

import java.util.Stack;

/*
    Merge sort using stack

    5 11 7 100 17 4

    4 5 7 11 17 100 - output

    tc: O(nlogn)
    sc: O(n)
 */
public class SortStackUsingStack {

    private static Stack<Integer> mergeSort(Stack<Integer> stack) {

        int size = stack.size();

        if(size == 1) {
            return stack;
        }

        int mid = size/2;
        int c = 1;
        Stack<Integer> stack1 = new Stack<>();

        while(c<=mid) {
            stack1.push(stack.pop());
            c++;
        }

        stack1 = mergeSort(stack1);
        stack = mergeSort(stack);

        return merge(stack, stack1);
    }

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

        Stack<Integer> stack = createStack();

        Stack<Integer> rstack = mergeSort(stack);

        printStack(rstack);
    }


    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */

    private static Stack<Integer> createStack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(11);
        stack.push(7);
        stack.push(100);
        stack.push(17);
        stack.push(4);

        return stack;
    }

    private static void printStack(Stack<Integer> rstack) {
        while(!rstack.empty()) {
            System.out.print(rstack.pop()+" ");
        }
        System.out.println("");
    }
}
