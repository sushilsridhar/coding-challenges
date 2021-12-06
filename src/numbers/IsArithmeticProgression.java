package numbers;

import java.util.Arrays;

/*
    Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.

    A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

    A = [3, 5, 1]

    We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.

    NOTE: even two element array can be arithmetic progression
 */
public class IsArithmeticProgression {
    public static void main(String[] args) {

        int[] A = {3, 5, 1};

        System.out.println(solve(A));
    }

    public static int solve(int[] A) {

        if(A.length < 2) {
            return 0;
        }

        Arrays.sort(A);

        int diff = A[1]-A[0];
        for(int i=2; i<A.length; i++) {
            if(diff != (A[i]-A[i-1])) {
                return 0;
            }
        }
        return 1;
    }
}
