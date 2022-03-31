package arrays.subset;

/*
    Technique: contribution technique

    Given an array, find the sum of all subset sums divided by 2^n

    a[i] * 2^n-1
    ------------
        2^n

    a[i] * 2^-1 --> a[i]/2
 */
public class SumOfSubsetSumTwo {

    public static void main(String[] args) {
                 //  0   1  2
        int[] a = { -2, 6, 4}; // ans = 32

        System.out.println(optimized(a));
    }

    // tc: O(n)
    private static int optimized(int[] a) {
        int n = a.length;
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum = sum + a[i];
        }

        return sum/2;
    }
}
