package dp.c1;

/*
    In Danceland, one person can party either alone or can pair up with another person.
    Can you find in how many ways they can party if there are A people in Danceland?

    Note: Return your answer modulo 10003, as the answer can be large
    n = 5
    ans = 26

    approach:

    number of ways one person can dance, n=1, ways = 1
    number of ways two person can dance,
    n=2, ways = 2,
    1 2  - alone
    (1,2) - pair

    n=3, ways = 4
    1 2 3
    (1 2) 3
    (1 3) 2
    (2 3) 1

    for 4 people to dance, 4 needs to dance alone or 4 needs to choose a partner,

    4 dancing alone - same as ways of 3 people dancing
      1 2 3 4
    (1 2) 3 4
    (1 3) 2 4
    (2 3) 1 4

    4 choosing a partner,
    4 can choose 1 or 2 or 3

    4 - (4,1) - remaining 2 people left, these two can dance alone or pair up, which is ways of 2 people dancing
        (4,2) - remaining 2 people left
        (4,3) - remaining 2 people left

    ways(4) = ways(3) + 3 * ways(2)

    4 dancing alone = ways(3)
    4 with partner = 4 can choose 3 partner * remaining ways of dancing for 2 partners

    recurrence relation: ways(n) = ways(n-1) + (n-1) * ways(n-2)
    total number of unique state is n, time taken for one state is O(1)

    observations,
    optimal sub problems
    overlapping sub problems

    tc: O(n)
    sc: O(n)
 */
public class LetsParty {

    public static void main(String[] args) {

        System.out.println(solve(5));
    }

    private static int solve(int A) {

        int[] dp = new int[A+1];
        for(int i=0; i<dp.length; i++) {
            dp[i] = -1;
        }
        return ways(dp, A);
    }

    private static int ways(int[] dp, int n) {

        if(n <= 2) {
            return n;
        }

        if(dp[n] != -1) {
            return dp[n];
        }
        int ans = (int) (ways(dp, n-1)%10003 + ((long)(n-1)%10003 * ways(dp, n-2)%10003)%10003)%10003;
        dp[n] = ans;
        return ans;
    }
}
