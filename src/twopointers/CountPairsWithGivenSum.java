package twopointers;

/*
    Given a sorted array of distinct integers A and an integer B,
    find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

    tc: O(n)
 */
public class CountPairsWithGivenSum {

    public static void main(String[] args) {
        //          0   1   2    3    4
        int a[] = { 5, 10, 20, 100, 105}; // ans -> 2
        int k = 110;

        System.out.println(solve(a, k));
    }

    public static int solve(int[] A, int B) {

        int i = 0;
        int j = A.length-1;
        int count = 0;

        while(i<j) {
            int sum = A[i] + A[j];

            if(sum == B) {
                count++;
                i++;
                j--;
            } else if(sum > B) {
                j--;
            } else if(sum < B) {
                i++;
            }
        }

        return count;
    }
}
