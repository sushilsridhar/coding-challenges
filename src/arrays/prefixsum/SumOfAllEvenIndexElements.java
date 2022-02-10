package arrays.prefixsum;

/*
    Given n array elements, find the sum of even indexes elements from left to right
                0   1   2  3   4   5   6   7   8   9
    arr []   -> 6, -2,  3, 4, 10,  5, 19,  2,  3,  2
    pf[Even] -> 6,  6,  9, 9, 19, 19, 38, 38, 41, 41
    pf[Odd]  -> 0, -2, -2, 2,  2,  7,  7,  9,  9, 11

    calculate prefix array for sum of even indexes

    query: 3, 7 = 29
    query: 2, 8 = 35
    query: 1, 5 = 13

    time complexity: O(q), q is number of queries
    space complexity: O(n), where n is length of the array
 */
public class SumOfAllEvenIndexElements {

    public static void main(String[] args) {
                //  0   1  2  3   4  5   6  7  8  9
        int []a = { 6, -2, 3, 4, 10, 5, 19, 2, 3, 2 };

        int[][] q = {{3,7}, {2,8}, {1,5}};

        solution(a, q);
    }

    private static void solution(int[] a, int[][] q) {

        int[] pf = new int[a.length];
        pf[0] = a[0];

        for(int i=1; i<a.length; i++) {
            if(i%2 == 0) {
                pf[i] = pf[i-1] + a[i];
            } else {
                pf[i] = pf[i-1];
            }
        }

        for(int i=0; i<q.length; i++) {
            int left = q[i][0];
            int right = q[i][1];
            int ans = 0;

            if(left%2==0) {
                ans = pf[right] - pf[left] + a[left];
            } else {
                ans = pf[right] - pf[left];
            }

            System.out.println("query: "+left+", "+right+" = "+ ans);
        }
    }

}
