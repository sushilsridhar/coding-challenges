package dp.c1;

/*
    find the fibonacci number,

    Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
    0th term is 0 So, 4th term of Fibonacci series is 3

    observations:
    optimal substructure
    overlapping subproblems

    tc: O(n)
    sc: O(n)
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1];

        for(int i=0; i<dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(fibonacci(dp, n));
    }

    private static int fibonacci(int[] dp, int n) {
        if(n < 2) {
            return n;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = fibonacci(dp, n-1) + fibonacci(dp, n-2);
        dp[n] = ans;
        return ans;
    }
}
