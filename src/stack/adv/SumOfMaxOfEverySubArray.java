package stack.adv;

import java.util.Stack;

/*
    technique: contribution technique
               adding contribution of each and every element

    refer: arrays/subarrays/TotalSumOfAllSubArrays

    0   1  2  3   4  5
    10, 2, 7, 6, 11, 9

    i=0, 1 * 4 = 4 * 10 = 40
    i=1, 1 * 1 = 1 * 2  = 2
    i=2, 2 * 2 = 4 * 7  = 28
    i=3, 1 * 1 = 1 * 6  = 6
    i=4, 5 * 2 = 10 * 11= 110
    i=5, 1 * 1 = 1  * 9 = 9

    total = 195

    0   1  2  3   4  5
    10, 2, 7, 6, 11, 9
    -1  0  0  2  -1  4 -> ngl

    0   1  2  3   4  5
    10, 2, 7, 6, 11, 9
    4   2  4  4  6   6 -> ngr

    tc: O(n)
    sc: O(n)
 */
public class SumOfMaxOfEverySubArray {

    public static void main(String[] args) {

        int a[] = {10, 2, 7, 6, 11, 9};
        int b[] = {1, 4, 3};

        System.out.println(solution(a));
        System.out.println(solution(b));
    }

    private static int solution(int[] a) {
        int[] ngl = ngl(a);
        int[] ngr = ngr(a);
        int contribution = 0;

        for(int i=0; i<a.length; i++) {

            int lmax = ngl[i];
            int rmax = ngr[i];

            int leftSide = i - (lmax+1) + 1;
            int rightSide = (rmax - 1) - i + 1;
            int noOfSubarraysIndexIisPresent = leftSide * rightSide;
            contribution = contribution + noOfSubarraysIndexIisPresent * a[i];
        }

        return contribution;
    }

    private static int[] ngl(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        ans[0] = -1;
        stack.push(0);

        for(int i=1; i<a.length; i++) {

            while(!stack.empty() && a[i] >= a[stack.peek()]) {
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

    private static int[] ngr(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();

        int n = a.length;
        ans[n-1] = n;
        stack.push(n-1);

        for(int i=n-2; i>=0; i--) {

            while(!stack.empty() && a[i] >= a[stack.peek()]) {
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

}
