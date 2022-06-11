package stack.adv;

import java.util.Stack;

/*
    Given an array,
    1) find the nearest greatest element on the left for every element
    2) find the nearest greatest element on the right for every element

    10,  3,  9, 5, 7, 2,  11
    -1  10  10  9  9  7   -1 -> ngl

    10,  3,  9, 5,  7,  2,  11
    11   9  11  7  11  11   -1  -> ngr

    approach: maintain a candidate list of possible candidates
    top of stack will always have the element greater to the current element of array

    tc: O(n), we are iterating once over the array, and inserting all elements only once,
    so deletion will also run for max n times,

    n(insertion) + n(deletion) = O(n)

    sc: O(n)
 */
public class NearestGreatestElement {

    public static void main(String[] args) {

        int a[] = {10, 3, 9, 5, 7, 2, 11};

        int[] ans = ngl(a);
        for(int i: ans) {
            System.out.print(i+" ");
        }

        System.out.println("");

        int[] ans1 = ngr(a);
        for(int j: ans1) {
            System.out.print(j+" ");
        }
    }

    private static int[] ngl(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        ans[0] = -1;
        stack.push(a[0]);

        for(int i=1; i<a.length; i++) {

            while(!stack.empty() && a[i] >= stack.peek()) {
                stack.pop();
            }

            if(stack.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(a[i]);
        }

        return ans;
    }

    private static int[] ngr(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        int n = a.length;
        ans[n-1] = -1;
        stack.push(a[n-1]);

        for(int i=n-2; i>=0; i--) {

            while(!stack.empty() && a[i] >= stack.peek()) {
                stack.pop();
            }

            if(stack.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(a[i]);
        }

        return ans;
    }

}
