package stack.adv;

import java.util.Stack;

/*
    Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
    Find the largest rectangle containing only 1's and return its area.

    Note: Rows are numbered from top to bottom and columns are numbered from left to right.

    Constraints

    1 <= N, M <= 1000
    0 <= A[i] <= 1

    input:
    A = [ [0, 0, 1]
          [0, 1, 1]
          [1, 1, 1] ]

    answer:    4

    approach:

    apply histogram concept to each and every row as base of the rectangle

    tc: O(n*m)
    sc: O(m)
 */
public class MaxRectangle {
    public static void main(String[] args) {

        int a[][] = {   {0, 0, 1},
                        {0, 1, 1},
                        {1, 1, 1}  };


        int ans = solve(a);
        System.out.println(ans);
    }

    public static int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[] hist = new int[m];
        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {   // O(n)
            for(int j=0; j<m; j++) {  // O(m)
                if(A[i][j] != 0) {
                    hist[j] = hist[j] + A[i][j];
                } else {
                    hist[j] = A[i][j];
                }
            }

            maxArea = Math.max(maxArea, calculateArea(hist)); //O(m)
        }
        return maxArea;
    }

    private static int calculateArea(int[] hist) {
        int m = hist.length;
        int maxArea = Integer.MIN_VALUE;

        int[] nsl = createNsl(hist); // O(m)
        int[] nsr = createNsr(hist); // O(m)

        for(int i=0; i<m; i++) { // O(m)

            int l = nsl[i];
            int r = nsr[i];

            int width = (r-1) - (l+1) + 1;
            int length = hist[i];
            int area = length * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int[] createNsl(int[] hist) {
        int m = hist.length;
        int[] nsl = new int[m];
        Stack<Integer> stack = new Stack<>();

        nsl[0] = -1;
        stack.push(0);

        for(int i=1; i<m; i++) {

            while(!stack.empty() && hist[i] <= hist[stack.peek()]) {
                stack.pop();
            }

            if(stack.empty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }

        return nsl;
    }

    private static int[] createNsr(int[] hist) {
        int m = hist.length;
        int[] nsr = new int[m];
        Stack<Integer> stack = new Stack<>();

        nsr[m-1] = m;
        stack.push(m-1);

        for(int i=m-2; i>=0; i--) {

            while(!stack.empty() && hist[i] <= hist[stack.peek()]) {
                stack.pop();
            }

            if(stack.empty()) {
                nsr[i] = m;
            } else {
                nsr[i] = stack.peek();
            }

            stack.push(i);
        }

        return nsr;
    }
}
