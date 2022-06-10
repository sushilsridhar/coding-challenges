package stack.adv;

import java.util.Stack;

/*
    find the distance between every element and it's smallest element close it
    0    1  2   3   4  5  6
    5,   2, 8, 10, 12, 6, 1

    -1, -1, 1, 1,  1,  4, -1 -> ans

    tc: O(n)
    sc: O(n)
 */
public class NearestSmallElementDistance {

    public static void main(String[] args) {

        int a[] = {5, 2, 8, 10, 12, 6, 1};

        int[] ans = nsl(a);
        for(int i: ans) {
            System.out.print(i+" ");
        }
    }

    // tc: O(n)
    // sc: O(n)
    private static int[] nsl(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        ans[0] = -1;
        stack.push(0);

        for(int i=1; i<a.length; i++) {

            while(!stack.empty() && a[i] <= a[stack.peek()]) {
                stack.pop();
            }

            if(stack.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
}
