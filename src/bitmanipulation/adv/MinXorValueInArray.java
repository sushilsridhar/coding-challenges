package bitmanipulation.adv;

import java.util.Arrays;

/*
    Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.
    Report the minimum XOR value.

     A = [1, 9, 7, 4]

     4^7 is 3, minimum value

     approach:
                       0  1  2  3
     - sort the array [1, 4, 7, 9], the xor of element at index 0 and index 3, will have the max value
             8 4 2 1
     1^9 --> 0 0 0 1 ^ 1 0 0 1 --> 8
     1^7 --> 0 0 0 1 ^ 0 1 1 1 --> 6
     1^4 --> 0 0 0 1 ^ 0 1 0 0 --> 5

     when distance between index 0 and another index reduces, the xor value also reduces,
     so the min xor for any index will be generated, if XORed with left and right of index

     left ^ index and index ^ right, for any index, this will be the min xor

     1 - 4 --> start with second element, the right side will be checked in next iteration 4,7 is same as 7,4
     4 - 7
     7 - 9
 */
public class MinXorValueInArray {

    public static void main(String[] args) {

        int A[] = {1, 9, 7, 4};
        System.out.println(bruteForce(A));
        System.out.println(optimized(A));
    }

    // tc: O(nlogn)
    private static int optimized(int[] A) {

        Arrays.sort(A);

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<A.length; i++) {
            int val = A[i-1] ^ A[i];
            ans = Math.min(ans, val);
        }
        return ans;
    }

    // tc: O(n^2)
    private static int bruteForce(int[] A) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                int r = A[i] ^ A[j];
                ans = Math.min(ans, r);
            }
        }
        return ans;
    }
}
