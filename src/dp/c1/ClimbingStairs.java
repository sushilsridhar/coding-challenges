package dp.c1;

/*
    You are climbing a stair case and it takes A steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    approach:

    number of ways to climb one stair is 1,
    number of ways to climb two stairs is 2,
    number of ways to climb 4 stairs is 5,

    if n = 5, we can take one step from 4, or we can take two steps from 3 to reach 5,

        5
     /     \
    4       3

    recurrence relation is ways(n) = ways(n-1) + ways(n-2)
    same as fibonacci series, use top down approach, to divide n in to sub problems,

    observations,
    optimal sub problems

    total number of unique state is n, time taken for one state is O(1)

    tc: O(n)
    sc: O(n)
 */
public class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int A) {

        int[] dp = new int[A+1];

        for(int i=1; i<=A; i++) {
            dp[i] = -1;
        }

        return ways(dp, A);
    }

    private static int ways(int[] dp, int s) {

        if(s <= 2) {
            dp[s] = s;
            return s;
        }

        if(dp[s] != -1) {
            return dp[s];
        }

        int ans = ways(dp, s-1) + ways(dp, s-2);
        dp[s] = ans;
        return ans;
    }

}
