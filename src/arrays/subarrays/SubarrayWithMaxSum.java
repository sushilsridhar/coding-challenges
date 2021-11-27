package arrays.subarrays;

/*
    Given sum of all elements from
    [2,5] is x
    [2,6] is x + arr[6]

    Carry forward technique

    Given an array, find max sum of all subarrays of length k

    Sliding window for efficient solution
 */
public class SubarrayWithMaxSum {
    public static void main(String[] args) {
                //   0  1   2  3  4   5  6  7   8  9
        int a[] = { -3, 4, -2, 5, 3, -2, 8, 2, -1, 4};

        averageSol(a); // O(n^2)

        efficient(a); // O(n)

    }

    private static void efficient(int[] a) {
        int N = a.length;
        int k = 5;

        int sum = 0;

        for(int i=0; i<N-k; i++) { // i<k-1
            sum = sum + a[i];
        }

        int maxSum = sum;

        for(int i=1,j; i<N-k; i++) {
            j = k-1 + i;
            sum = sum - a[i-1] + a[j];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println("maxSum: "+ maxSum);

    }

    private static void averageSol(int[] a) {

        int N = a.length;
        int k = 5;

        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<N-k; i++) {
            int j = k-1 + i;
            int sum =0;
            for(int x=i; x<=j; x++) {
                //[i-j] is a subarray of length k
                sum = sum + a[x];
            }

            if(sum > maxSum) {
                maxSum = sum;
            }
        }

        System.out.println("maxSum: "+ maxSum);
    }
}
