package arrays.subsequence;

import java.util.Arrays;

/*
    Technique: contribution technique

    Given an array of size n, calculate sum of max of every subsequence

    3 1 -4      -4 1 3

    {}           {}
    3            -4
    1            1
    -4           3
    3 1          -4 1
    1 -4         1 3
    3 -4         -4 3
    3 1 -4       -4 1 3

    min, max, sum, product of subsequences of given array and sorted array are same

    -4 1 3
         2^2 - in 4 subsequences 3 is max -> 12
       2^1 - in 2 subsequences 1 is max   -> 2
     2^0 - in 1 subsequences -4 is max    -> -4

     ans --> 10
 */
public class MaxOfEverySubsequence {

    public static void main(String[] args) {
                //  0  1  2
        int[] a = { 3, 1, -4}; // ans --> 10

        System.out.println(solution(a));
    }

    // tc: O(nlogn + n) -> O(nlogn)
    private static int solution(int[] a) {

        Arrays.sort(a);

        int sum = 0;
        for(int i=0; i<a.length; i++) {
            sum = sum + (a[i] * (1<<i));
        }

        return sum;
    }
}
