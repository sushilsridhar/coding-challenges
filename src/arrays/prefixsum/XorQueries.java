package arrays.prefixsum;

/*
    You are given an array A (containing only 0 and 1) as element of N length.
    Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.

    use prefix array to solve this

    input:
    A=[1,0,0,0,1]
    B=[ [2,4],
        [1,5],
        [3,5] ]

    output:
    [[0 3]
    [0 3]
    [1 2]]
 */
public class XorQueries {
    public static void main(String[] args) {


    }

    public static int[][] solve(int[] A, int[][] B) {

        int[][] result = new int[B.length][2];

        for(int q=0; q<B.length; q++) {
            int startIndex = B[q][0] -1;
            int endIndex = B[q][1] -1;

            int xor = 0, zeroCount=0;

            for(int i=startIndex; i<=endIndex; i++) {
                xor = xor ^ A[i];

                if(A[i] == 0) {
                    zeroCount++;
                }
            }

            result[q][0] = xor;
            result[q][1] = zeroCount;
        }

        return result;
    }
}
