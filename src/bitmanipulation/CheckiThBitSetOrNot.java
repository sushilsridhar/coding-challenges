package bitmanipulation;

/*
    Check if i bit in a number is set or unset

    using left shift and right shift operator

             4 3 2 1 0
    N = 24 - 1 1 0 0 0
    i = 3, bits start from 0, so ith bit is set for the above N

    N = 106, -  1 1 0 1 0 1 0
    i = 3,   -  0 0 0 1 0 0 0 , left shift 1 , 3 times
           r -  0 0 0 1 0 0 0 , = 8, which is 2^i
 */
public class CheckiThBitSetOrNot {
    public static void main(String[] args) {

        System.out.println(checkSetOrUnSet(24, 3));

        System.out.println(checkSetOrUnSetOptimizedRightShift(24, 3));

        System.out.println(checkSetOrUnSetOptimizedLeftShift(24, 3));

    }

    // optimized - using right shift
    private static boolean checkSetOrUnSetOptimizedRightShift(int n, int i) {

        return ((n >> i) & 1) == 1;
    }

    // optimized - using left shift
    private static boolean checkSetOrUnSetOptimizedLeftShift(int n, int i) {

        return (n & (1 << i)) == Math.pow(2, i);

        // OR use this
        // return (n & (1 << i)) != 0;

    }

    private static boolean checkSetOrUnSet(int n, int i) {

        int[] arr = new int[32];
        int j = 0;

        while(n>0) {
            arr[j] = n%2;
            j++;
            n=n/2;
        }

        if(arr[i] == 1) {
            return true;
        } else
            return false;
    }
}
