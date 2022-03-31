package arrays.subset;

/*
    Technique: contribution technique

    Given an array of size n, find the sum of subset sum

    -2, 6, 4 -> ans 32

    approach:

    a0 a1 a2 a3 a4
    1  2  2  2  2  - each element have two choices, either they can be included or excluded

    a0 is included, so the total subsets in which a0 can occur is 2^4
 */
public class SumOfSubsetSum {

    public static void main(String[] args) {
                //  0   1  2
        int[] a = { -2, 6, 4}; // ans = 32

        System.out.println(bruteForce(a));
        System.out.println(optimized(a));
    }

    // tc: O(n) TODO use power function to avoid overflow
    private static int optimized(int[] a) {
        int n = a.length;
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum = sum + (a[i] * (1<<n-1)); // this 2^n can be written as 1<<n
            // multiplication cause overflow
        }

        return sum;
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
