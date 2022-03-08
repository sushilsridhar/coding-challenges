package bitmanipulation.adv;

/*
    Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
    Return the count modulo 109 + 7.

    DECIMAL    BINARY  SET BIT COUNT
        1          01        1
        2          10        1
        3          11        2
     1 + 1 + 2 = 4
     Answer = 4 % 1000000007 = 4

     approach:

     8 4 2 1
     0 0 0 0 - 0
     0 0 0 1 - 1
     0 0 1 0 - 2
     0 0 1 1 - 3
     0 1 0 0 - 4
     0 1 0 1 - 5
     0 1 1 0 - 6
     0 1 1 1 - 7
     1 0 0 0 - 8
     1 0 0 1 - 9
     1 0 1 0 - 10

     for the 0th bit, 0 1 is repeating
     for the 1th bit, 00 11 is repeating

     number of zeros and ones in 0th bit, 0 - (2^0, 2^0), 2^0 zeros and 2^0 ones
     number of zeros and ones in 1th bit, 1 - (2^1, 2^1), 2^1 zeros and 2^1 ones
     for ith bit, i - (2^i, 2^i), 2^i zeros and 2^i ones, total = 2^(i+1)

     0-A, number of elements = A+1
     number of zeros and ones in one group = 2^(i+1)

     total number of groups = A+1/ 2^(i+1) , division is not always integer,
     so find the remainder, check how many ones are there

    numberOfGroupsPresent = (A+1)/2^(i+1)
    remainingNonGroupElements = (A+1) % 2^(i+1)

    noOfSetBitsInOneGroup = 2^i

    int totalNumberOfSetBitsAtI = (numberOfGroupsPresent * noOfSetBitsInOneGroup) +
                    (remainingNonGroupElements > noOfUnsetBitsInOneGroup ? remainingNonGroupElements - noOfUnsetBitsInOneGroup : 0);

 */
public class CountTotalSetBits {

    public static void main(String[] args) {

        System.out.println(bruteForce(3)); // ans = 4
        System.out.println(optimized(3)); // ans = 4
    }

    // tc: O(n)
    private static int optimized(int A) {

        int mod = (int) Math.pow(10,9) + 7;
        int ans = 0;
        for(int i=0; i<32; i++) {
            int numberOfZerosAndOnesInIthBit = (int) Math.pow(2, i+1);
            int numberOfElementsFromZeroToA = A + 1;

            int numberOfGroupsPresent = numberOfElementsFromZeroToA / numberOfZerosAndOnesInIthBit;
            int remainingNonGroupElements = numberOfElementsFromZeroToA % numberOfZerosAndOnesInIthBit;

            int noOfSetBitsInOneGroup = (int) Math.pow(2, i);
            int noOfUnsetBitsInOneGroup = (int) Math.pow(2, i);

            int totalNumberOfSetBitsAtI = (numberOfGroupsPresent * noOfSetBitsInOneGroup) +
                    (remainingNonGroupElements > noOfUnsetBitsInOneGroup ? remainingNonGroupElements - noOfUnsetBitsInOneGroup : 0);

            ans = (ans%mod + totalNumberOfSetBitsAtI%mod)%mod;
        }

        return ans;
    }

    // tc: O(32n)
    public static int bruteForce(int A) {

        int mod = (int) Math.pow(10,9) + 7;
        int count = 0;
        for(int i=0; i<32; i++) {
            for(int j=1; j<=A; j++) {
                if((j & (1<<i)) != 0) {
                    count++;
                }
            }
        }

        return count%mod;
    }
}
