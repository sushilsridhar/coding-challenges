package arrays.subset;

/*
    Technique: technique to use binary indexes to count the number of combinations possible

    Given a array of N elements, check if a subset exists with sum = k

    generate all subsets
            0 1 2
         { -2 6 4 } -> total number of subsets 2^n

            2 1 0  -> binary index 2^0
    {}      0 0 0  - 0
    -2      0 0 1  - 1
    6       0 1 0  - 2
    4       1 0 0  - 4
    -2 6    0 1 1  - 3
    -2 4    1 0 1  - 5
    6 4     1 1 0  - 6
    -2 6 4  1 1 1  - 7

    tc: O(n * 2^n) , will work only for n<=20
    sc: O(1)

    backtracking solution -> O(2^n)
    DP solution -> O(n * k)
 */
public class CheckIfSubsetExists {

    public static void main(String[] args) {
                //  0   1  2  3  4   5  6
        int[] a = { 3, -1, 0, 6, 2, -3, 5};
        int k = 10;

        System.out.println(solution(a, k));
    }

    private static boolean solution(int[] a, int k) {
        int n = a.length;
        // 2^n -> 1<<n
        for(int i=0; i<(1<<n); i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                if((i & (1<<j)) > 0 ) {
                    sum = sum + a[j];
                }
            }
            if(sum == k) {
                return true;
            }
        }
        return false;
    }
}
