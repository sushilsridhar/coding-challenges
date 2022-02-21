package bitmanipulation.adv;

/*
    Given an array of integers A, every element appears twice except for one. Find that single one.

    approach:
    1) a ^ c ^ d ^ c ^ a ^ e ^ d = e

    2) Binary approach,
      - calculate number of set bits at each position of all numbers
      - if number of set bits at position 1 is even, contribution of unique number on that position is 0
      - if number of set bits at position 1 is odd, contribution of unique number on that position is 1

    3 2 1 0
    -------
    0 1 0 1 - 5
    0 1 1 1 - 7
    0 1 0 1 - 5
    0 1 0 0 - 4
    0 1 1 1 - 7
    1 0 1 1 - 11
    1 0 0 1 - 9
    1 0 1 1 - 11
    0 1 0 0 - 4

    number of set bits at position 0, 7, odd, contribution of unique number is 1
 */
public class UniqueElement {
    public static void main(String[] args) {

        int A[] = {5, 7, 5, 4, 7, 11, 9, 11, 4};
        System.out.println(xorApproach(A));
        System.out.println(binaryApproach(A));
    }

    // tc: O(32 * n)
    public static int binaryApproach(final int[] A) {
        int ans = 0;

        for(int i=0; i<32; i++) {
            int noOfSetBits = 0;
            for(int j=0; j<A.length; j++) {
                if(checkIfIthBitSet(A[j], i)) {
                    noOfSetBits++;
                }
            }
            if((noOfSetBits&1) == 1) {
                ans = ans | 1<<i;
            }
        }

        return ans;
    }

    private static boolean checkIfIthBitSet(int ele, int i) {
        return (ele & (1 << i)) != 0;
    }

    // tc: O(n)
    public static int xorApproach(final int[] A) {

        int result = 0;
        for(int i=0; i<A.length; i++) {
            result =  result ^ A[i];
        }
        return result;

    }
}
