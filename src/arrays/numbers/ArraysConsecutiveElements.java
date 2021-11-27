package arrays.numbers;

import java.util.Arrays;

/*

    find if the array elements are consecutive or not

    solution 1:
    Sort the arrays, difference between first element and second element must be 1

    solution 2: Below solution not working for larger input
    Sum of a particular sequence of numbers (ex: 5,6,7,8,9,10)- Arithmetic progression formula - n/2 * [2a + (n-1)*d]
    where a is first term of AP and d is difference between two terms, which is 1 and n is total size.

 */
public class ArraysConsecutiveElements {
    public static void main(String[] args) {

        int a[] = { 4, 2, 3, 1, 5};

        System.out.println(solve(a));

    }

    public static int solve(int[] A) {

        Arrays.sort(A);

        for(int i=0; i<A.length-1; i++) {
            if(A[i+1] - A[i] != 1) {
                return 0;
            }
        }

        return 1;
    }

    public int usingAP(int[] A) {

        int firstTerm = Integer.MAX_VALUE;
        int n = A.length;
        int sum = 0;

        for(int i=0; i<n; i++) {
            if(A[i] < firstTerm) {
                firstTerm = A[i];
            }
            sum+=A[i];
        }

        int apSum = (n*((2*firstTerm) + ((n-1) * 1)))/2;

        return sum == apSum? 1:0;
    }
}
