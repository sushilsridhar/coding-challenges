package arrays.subarrays;

/*
    Technique: carry forward

    Find the contiguous subarray within an array, A of length N which has the largest sum.

     int[] A = { 1, 2, 3, 4, -10 };

    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

    A = [-2,1,-3,4,-1, 2, 1, -5, 4]
 */
public class MaxSumContiguousSubarray {

    public static void main(String[] args) {

        int[] A = { 1, 2, 3, 4, -10 }; // output - 10

        System.out.println(bruteForce(A));
    }

    public static int bruteForce(final int[] A) {

        int max = Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++) {
            int sum=0;
            for(int j=i; j<A.length; j++) {

                sum = sum + A[j];

                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
