package sorting.adv;

import java.util.Arrays;

/*
    Given an array A of N integers where each value represents number of chocolates in a packet.

    i-th can have A[i] number of chocolates.

    There are B number students, the task is to distribute chocolate packets following below conditions:

    1. Each student gets one packet.
    2. The difference between the number of chocolates in packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.
    Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.

    A : [3, 4, 1, 9, 56, 7, 9, 12]
    B : 5

    Minimum Difference is 6
    The set goes like 3,4,7,9,9 and the output is 9-3 = 6

    approach:
    distribute any 5 packets to 5 students, such that condition is met
    array needs to be sorted, so that we can distribute chocolate to B students such that difference is minimum,
    1 3 4 7 9 9 --> for 4 diff between 3 and 4, 4 and 7 is small, this happens only after sorting

    tc: O(nlogn)
 */
public class ChocolateDistribution {

    public static void main(String[] args) {

        int a[] = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(solve(a, 5)); // ans -> 6
    }

    private static int solve(int[] A, int B) {

        if(B == 0 || A.length == 0) {
            return 0;
        }

        Arrays.sort(A);

        int n = A.length;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<=n-B; i++) {
            int j = B-1 + i;
            ans = Math.min(ans, A[j] - A[i]);
        }

        return ans;
    }
}


