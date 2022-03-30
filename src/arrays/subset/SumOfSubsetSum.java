package arrays.subset;

/*
    Given an array of size n, find the sum of subset sum
// TODO: find optimized solution


 */
public class SumOfSubsetSum {

    public static void main(String[] args) {
                //  0   1  2
        int[] a = { -2, 6, 4}; // ans = 32

        System.out.println(bruteForce(a));
    }

    // tc: (n * 2^n)
    private static int bruteForce(int[] a) {
        int n = a.length;
        // 2^n -> 1<<n
        int ans = 0;
        for(int i=0; i<(1<<n); i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                if((i & (1<<j)) > 0 ) {
                    sum = sum + a[j];
                }
            }
            ans = ans + sum;
        }
        return ans;
    }
}
