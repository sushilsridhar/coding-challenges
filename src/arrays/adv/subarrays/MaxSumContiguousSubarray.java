package arrays.adv.subarrays;

/*
    Technique: kadane's algorithm

    Find the contiguous subarray within an array, A of length N which has the largest sum.

    5, 6, 7, -3, 2, -10, -12, 8, 12, 21 --> ans = 41

    The subarray [8 12 21] has the maximum possible sum of 41

    A = [-2,1,-3,4,-1, 2, 1, -5, 4] --> ans = 6, subarray [4, -1, 2, 1]
    A=  [-2, -3, -4, -1, -2, -1, -5, -4] --> ans = -1, subarray [-1]

    approach:

      _ 7 13  2 4 _
     -5

     7 13 2 4 is a subarray with sum 26,
     suppose first blank, that is element before 7 is -5, we should not consider the subarray [-5 7 13  2 4], sum 21, which decreases the total sum

     _  _ 7 13  2 4 _
    12 -5

    now 12 + (-5) -> 7, 7 is positive so this number will contribute to the total sum, subarray [12 -5 7 13  2 4], sum = 33, increases the total sum

    if previous subarray sum is positive, consider it as subarray,
    if previous subarray sum is negative, ignore the subarray, and consider the subarray starting from current index
 */
public class MaxSumContiguousSubarray {

    public static void main(String[] args) {

        int[] a = { 5, 6, 7, -3, 2, -10, -12, 8, 12, 21 }; // output -> 41

        System.out.println(bruteForce(a));
        System.out.println(kadaneAlgo(a));

        int[] b = {-2,1,-3,4,-1, 2, 1, -5, 4}; // output -> 6
        System.out.println(bruteForce(b));
        System.out.println(kadaneAlgo(b));

        int[] c = {-2, -3, -4, -1, -2, -1, -5, -4}; // output -> -1
        System.out.println(bruteForce(c));
        System.out.println(kadaneAlgo(c));
    }

    //tc: O(n), sc: O(1)
    public static int kadaneAlgo(int[] a) {

        int currentSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++) {

            currentSum = currentSum + a[i];
            max = Math.max(max, currentSum);

            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return max;
    }

    // tc: O(n2) , using carry forward
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
