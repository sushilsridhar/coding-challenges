package arrays.subarrays;

/*
    technique: sliding window

    Given an array of size N, Find the subarray with least average of size k.

    eg: A=[3, 7, 90, 20, 10, 50, 40]
        B=3

    ans: Subarray between indexes 3 and 5
    The subarray {20, 10, 50} has the least average
    among all subarrays of size 3.
 */
public class SubarrayOfSizeKWithLeastAverage {

    public static void main(String[] args) {
                //   0  1  2   3  4  5   6  7   8  9  10 11  12 13 14
        int a[] = { 15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18};
        int B = 6;

        int b[] = { 20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11 };
        int C = 9;

        System.out.println(averageSol(a, B)); // O(n^2)

        System.out.println(efficient(a, B)); // O(n)

    }

    public static int efficient(int[] A, int B) {

        int n = A.length;
        int minAvgIndex = 0;
        int sum = 0;

        for(int i=0; i<B; i++) {
            sum = sum + A[i];
        }

        float avg = (float)sum/B;
        float minAvg = avg;

        for(int i=1; i<=n-B; i++) {
            int j = B-1+i;

            sum = sum - A[i-1] + A[j];

            avg = (float)sum/B;

            if(avg < minAvg) {
                minAvg = avg;
                minAvgIndex = i;
            }
        }
        return minAvgIndex;
    }

    private static int averageSol(int[] A, int B) {

        int n = A.length;
        float minAvg = Float.MAX_VALUE;
        int minAvgIndex = 0;

        for(int i=0; i<=n-B; i++) {
            int j = B-1+i;
            int sum = 0;

            for(int x=i; x<=j; x++) {
                sum = sum + A[x];
            }
            float avg = (float)sum/B;

            if(avg < minAvg) {
                minAvg = avg;
                minAvgIndex = i;
            }
        }
        return minAvgIndex;
    }
}
