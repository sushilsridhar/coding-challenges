package bitmanipulation.adv;

/*
    Given an array of n elements, return the max & value of any pair.

    max(A[i] & A[j]) where, i!=j

    26, 13, 23, 28, 27, 7, 25 --> ans 26 & 27 --> 26
         4 3 2 1 0
        16 8 4 2 1
    26 - 1 1 0 1 0
    13 - 0 1 1 0 1
    23 - 1 0 1 1 1
    28 - 1 1 1 0 0
    27 - 1 1 0 1 1
     7 - 0 0 1 1 1
    25 - 1 1 0 0 1

    for & operation to be maximum, the right most bit should be set,
    if the right most bit is set for 1 pair, ignore the rest of elements in array which has right most bit as 0

    at position 4, number of set bits are 5, 5 > 1, set bits more than 1 pair present
    our ans should have the position 4 bit set
    eliminate number 13, 7 as it's 4th bit is 0, since we have better elements
 */
public class MaxValueOfPair {

    public static void main(String[] args) {

        int A[] = {26, 13, 23, 28, 27, 7, 25}; // ans = 26
        System.out.println(bruteForce(A));

        System.out.println(optimized(A));
    }

    // tc: O(31*n + 31*n) , sc: O(1)
    private static int optimized(int[] A) {
        int ans = 0;
        for(int i=30; i>=0; i--) { // 31st bit is for the sign in signed bit which has both positive and negative numbers
            int noOfSetBitsAtI = 0;
            for(int j=0; j<A.length; j++) {
                int ele = A[j];
                if((ele & (1<<i)) != 0) {
                    noOfSetBitsAtI++;
                }
            }
            if(noOfSetBitsAtI > 1) {
                ans = ans | (1<<i);

                for(int j=0; j<A.length; j++) {
                    int ele = A[j];
                    if((ele & (1<<i)) == 0) {
                        A[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    // tc: O(n^2)
    private static int bruteForce(int[] A) {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                int r =  A[i] & A[j];
                ans = Math.max(ans, r);
            }
        }
        return ans;
    }
}
