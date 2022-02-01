package arrays.adv.prefixsum;

/*
       There are N (N > 0) beggars sitting in a row outside a temple.
       Each beggar initially has an empty pot. When the devotees come to the temple,
       they donate some amount of coins to these beggars.
       Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.
       Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N,
       find out the final amount of money in each beggar's pot at the end of the day,
       provided they don't fill their pots by any other means.

       Example: Input: N = 7, q = [[1, 3], [4, 2], [2, 1]]
       Return: [0, 3, 4, 4, 6, 6, 6]

       Explanation:=> First devotee donated 3 coins to beggars ranging from 1 to n.
       Final amount in each beggars pot after first devotee: [0, 3, 3, 3, 3, 3]
       Second devotee donated 2 coins to beggars ranging from 4 to n.
       Final amount in each beggars pot after second devotee: [0, 3, 3, 3, 5, 5, 5]
       Third devotee donated 25 coins to beggars ranging from 2 to n.
       Final amount in each beggars pot after third devotee: [0, 3, 4, 4, 6, 6, 6]
 */
public class BeggarOutsideTemple {

    public static void main(String[] args) {
        int n = 7;
        int[][] q = {{1, 3}, {4, 2}, {2, 1}};
        // ans Return: [0, 3, 4, 4, 6, 6, 6]

        int[] ans = bestSolution(n, q);
        for(int a: ans) {
            System.out.print(a+" ");
        }
    }

    // tc: O(n) , sc: O(n)
    private static int[] bestSolution(int n, int[][] q) {

        int[] ans = new int[n];

        for(int i=0; i<q.length; i++) {
            int index = q[i][0];
            int value = q[i][1];

            ans[index] = value;
        }

        for(int i=1; i<n; i++) { // prefix sum calculation
            ans[i] = ans[i-1] + ans[i];
        }

       return ans;
    }
}
