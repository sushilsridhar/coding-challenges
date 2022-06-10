package stack.adv;

import java.util.Stack;

/*

    Given an array of integers A.
    A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
    Find the area of the largest rectangle formed by the histogram.

    The largest rectangle has area = 10 unit. Formed by A[3] to A[4].

    approach:

    for a index i,
    find the smallest element closest on left to i
    find the smallest element closest on right to i, only from index left+1 to right-1, can form a rectangle

    nsl[] = [ -1  -1  1  2  1  4]
    nsr[] = [  1   n  4  4  n  n]

    tc: O(n)
    sc: O(n)
 */
public class Histogram {
    public static void main(String[] args) {

        int a[] = {2, 4, 3, 4, 5, 1};

        int ans = solution(a);
        System.out.println(ans);

        int ans1 = largestRectangleArea(a);
        System.out.println(ans1);
    }

    public static int largestRectangleArea(int[] A) {
        int n = A.length;
        int maxArea = Integer.MIN_VALUE;

        int[] nsl = createNSL(A); // O(n)
        int[] nsr = createNSR(A); // O(n)

        for(int i=0; i<n; i++) { // O(n)

            int p1 = nsl[i];
            int p2 = nsr[i];

            int w = (p2-1) - (p1+1) + 1;
            int l = A[i];
            int area = l * w;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int[] createNSL(int[] a) {
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
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }

    private static int[] createNSR(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        int n = a.length;
        ans[n-1] = n;
        stack.push(n-1);

        for(int i=n-2; i>=0; i--) {

            while(!stack.empty() && a[i] <= a[stack.peek()]) {
                stack.pop();
            }

            if(stack.empty()) {
                ans[i] = n;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }

    // tc: O(n^2)
    // sc: O(1)
    private static int solution(int[] a) {
        int maxArea = 0;
        for(int i=0; i<a.length; i++) {

            int p1 = i;
            int p2 = i;

            while(p1 >= 0 && a[p1] >= a[i]) {
                p1--;
            }

            while(p2 < a.length && a[p2] >= a[i]) {
                p2++;
            }

            int w = (p2-1) - (p1+1) + 1;
            int l = a[i];
            int area = l * w;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
