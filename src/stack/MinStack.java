package stack;

import java.util.Stack;

/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
    NOTE:

    All the operations have to be constant time operations.
    getMin() should return -1 if the stack is empty.
    pop() should return nothing if the stack is empty.
    top() should return -1 if the stack is empty.

    output -2 1 2

    Time complexity: O(n), where n is the number of operations, push pop top, but all operations are O(1)
    Space complexity: O(x) + O(y), where x is the number of value added in stack and y is the number of times the minimum changes
 */
public class MinStack {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minValueStack = new Stack<>();

    public static void push(int x) {
        stack.push(x);

        if(minValueStack.empty() || x <= minValueStack.peek()) {
            minValueStack.push(x);
        }
    }

    public static void pop() {
        if(!stack.empty()) {
            int removedEle = stack.pop();

            if(removedEle == minValueStack.peek()) {
                minValueStack.pop();
            }
        }
    }

    public static int top() {
        if(!stack.empty()) {
            return stack.peek();
        }
        return -1;
    }

    public static int getMin() {
        if(!minValueStack.empty()) {
            return minValueStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(-2);
        System.out.print(getMin()+" ");
        pop();
        System.out.print(getMin()+" ");
        System.out.print(top()+" ");


        /* output: -1 -1
        System.out.print(getMin()+" ");
        pop();
        System.out.print(top()+" ");*/
    }
}
