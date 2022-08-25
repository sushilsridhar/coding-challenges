package twopointers;

import java.util.Arrays;

/*
    Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

    Assume that there will only be one solution

    Problem Constraints

    -108 <= B <= 108
    1 <= N <= 104
    -108 <= A[i] <= 108

    input
    A = {-1, 2, 1, -4}
    B = 1

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

    bruteforce: sort the array, iterate the array with 3 loops,
    with i=0, j = i+1, k = j+1, to avoid considering duplicate triplets,

    find which is closest to b, and save the answer, keep doing for all the triplets

    tc: O(nlogn + n^3)
    sc: O(1)

    two pointers,

    sort the array, so that two pointers can be applied,
    fix one elements, find the other two using two pointers,

    calculate sum, find if the sum is closer to the target, try out all combination and
    maintain the answer which is closer to target

    tc: O(nlogn + n^2)
    sc: O(1)
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
       int[] A = {-1, 2, 1, -4};
       int B = 1;

        System.out.println(bruteForce(A, B));
        System.out.println(twoPointers(A, B));

    }

    private static int twoPointers(int[] A, int B) {

        Arrays.sort(A);
        int target = B;
        int n = A.length;
        int ans = 1000 * 1000 * 100;

        for(int k=0; k<n-2; k++) {
            int i = k+1;
            int j = n-1;

            while(i<j) {
                int sum = A[k] + A[i] + A[j];

                if(sum == target) {
                    return sum;
                } else {
                    int distanceBetweenSumAndTarget = Math.abs(sum - target);
                    int distanceBetweenAnsAndTarget = Math.abs(ans - target);

                    if(distanceBetweenSumAndTarget < distanceBetweenAnsAndTarget) {
                        ans = sum;
                    }

                    if(sum > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }

        return ans;
    }

    private static int bruteForce(int[] A, int B) {

        Arrays.sort(A);
        int target = B;
        int ans = 1000 * 1000 * 100;

        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                for(int k=j+1; k<A.length; k++) {
                    int sum = A[i] + A[j] + A[k];
                    if(sum == target) {
                        return sum;
                    }
                    int distanceBetweenSumAndTarget = Math.abs(sum - target);
                    int distanceBetweenAnsAndTarget = Math.abs(ans - target);

                    if(distanceBetweenSumAndTarget < distanceBetweenAnsAndTarget) {
                        ans = sum;
                    }
                }
            }
        }

        return ans;
    }
}
