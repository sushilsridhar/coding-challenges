package arrays.sorting;

import java.util.Arrays;
import java.util.Collections;

/*
    Given N array element, at every step remove an array element.

    Cost to remove element = sum of array elements present in the array
    Find minimum cost to remove all elements?

    [4,6,1]
    remove 6, [6,4,1] - cost 11
    remove 4, [4,1]   - cost 5
    remove 1, [1]     - cost 1 , total cost = 17

    [3,5,1,-3]
    remove 5,  [3,5,1,-3] - cost - 6
    remove 3,  [3,1,-3]   - cost - 1
    remove 1,  [1,-3]     - cost - -2
    remove -3, [-3]       - cost - -3, total cost = 2

    observation:
    { a, b, c ,d}
    remove a, { a, b, c ,d}, cost = a + b + c + d
    remove b, { b, c, d}   , cost =     b + c + d
    remove c, { c ,d }     , cost =         c + d
    remove d, { d }        , cost =             d
                             total= a +2b +3c +4d
    a should be first max, b should be second max..... d should be the minimum to maintain the cost minimum

 */
public class MinCostToRemoveAllElements {

    public static void main(String[] args) {

        int[] A = { 3,5,1,-3 }; // output - 2

        System.out.println(solution(A));

        System.out.println(bestSolution(A));

    }

    // Time complexity - nlogn + n -> nlogn
    private static int bestSolution(int[] a) {

        Arrays.sort(a);
        int cost = 0;
        for(int i=a.length-1, j=1; i>=0; i--, j++) {
            cost = cost + (a[i] * j);
        }
        return cost;
    }

    // Time complexity - nlogn + 2n
    private static int solution(int[] a) {
        int sum = 0;
        for(int i=0; i<a.length; i++) {
            sum+= a[i];
        }

        Arrays.sort(a);
        int cost = 0;
        for(int i=a.length-1; i>=0; i--) {
            cost = cost + sum;
            sum-= a[i];
        }
        return cost;
    }
}
