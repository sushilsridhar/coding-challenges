package arrays.subarrays;

/*
    Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array

    and atleast one occurrence of the minimum value of the array.

          0  1  2  3  4  5  6  7  8  9  10
    A = [ 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1]

    min = 1
    max = 6
    indexes [2,5] [5,8] [8,10] - min length is 3

    solution:
    start iterating from the right,
    if you find max element, update maxEleIndex, calculate the difference between max and min index to find array length, and find minimium of length
    if you find min element, update minEleIndex, calculate the difference between max and min index to find array length, and find the minimium of length
 */
public class ClosestMinMaxInSubArray {

    public static void main(String[] args) {

        int[] A = { 814, 761, 697, 483, 981 };

        solve(A);
    }

    public static int solve(int[] A) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        if(max == min) {
            return 1;
        }

        int maxIndex = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        int minArrayLength =  Integer.MAX_VALUE;

        for(int i=A.length-1; i>=0; i--) {
            if(A[i] == max) {
                minArrayLength = Math.min(minArrayLength, minIndex-i+1);
                maxIndex = i;
            }

            if(A[i] == min) {
                minArrayLength = Math.min(minArrayLength, maxIndex-i+1);
                minIndex = i;
            }
        }

        return minArrayLength;
    }

    // similiar solution
    public static int solve2(int[] A) {
        int min_Index = -1, max_Index = -1;
        int min_ele = Integer.MAX_VALUE, max_ele = Integer.MIN_VALUE;

        int ans = Integer.MAX_VALUE;
        for(int x:A)
        {
            min_ele = Math.min(min_ele, x);
            max_ele = Math.max(max_ele, x);
        }

        for(int i=0 ; i<A.length ; i++)
        {
            if(A[i] == min_ele) min_Index = Math.max(min_Index, i);
            if(A[i] == max_ele) max_Index = Math.max(max_Index, i);

            if(min_Index != -1 && max_Index != -1)
            {
                int len = Math.abs(max_Index - min_Index) + 1;
                ans = Math.min(ans, len);
            }

        }
        return ans;
    }
}
