package bitmanipulation.adv;

/*
    Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice.
    Find the two elements that appear only once.
    Note: Output array must be sorted.

    3, 6, 4, 4, 3, 8 --> 6 and 8 are unique elements

    approach:

    8 4 2 1
    0 0 1 1 - 3
    0 1 1 0 - 6
    0 1 0 0 - 4
    0 1 0 0 - 4
    0 0 1 1 - 3
    1 0 0 0 - 8
    --------
    1 1 1 0 - total xor ( only which has odd number of set bits have their value 1, using this to optimize)
    1 3 3 2 - count of set bits,

    if even set bits, 2X, both are repeating elements, or both can be two non repeating elements
    if odd set bits, 2X + 1, 2 are repeating elements, the one element is non repeating element, it can be 6 or 8

    find the first bit index, with odd bits set, since it can contains, 2X +1, it can contains either 6 or 8,
    use that bit index, to divide the array, so the array becomes
    3,6,3 - xor of all - 6
    4,4,8 - xor of all - 8

*/
public class TwoUniqueElements {

    public static void main(String[] args) {

        int A[] = {3, 6, 4, 4, 3, 8};

        int[] r = solution(A);
        for(int ele: r) {
            System.out.print(ele+" ");
        }
        System.out.println(" ");

        int[] r1 = optimized(A);
        for(int ele: r1) {
            System.out.print(ele+" ");
        }
    }

    // tc: O( n + 32 + n) , sc: O(1)
    private static int[] optimized(int[] A) {
        int dividerBit = 0;

        int xorAll = 0;
        for(int i=0; i<A.length; i++) {
            xorAll = xorAll ^ A[i];
        }

        for(int i=0; i<32; i++) {
            if(checkIfIthBitSet(xorAll, i)) {
                dividerBit = i;
                break;
            }
        }

        int eleOne = 0;
        int eleTwo = 0;
        for(int i=0; i<A.length; i++) {
            if(checkIfIthBitSet(A[i], dividerBit)) {
                eleOne = eleOne ^ A[i];
            } else {
                eleTwo = eleTwo ^ A[i];
            }
        }

        return new int[]{eleOne, eleTwo};
    }

    // tc: O(32n + n), sc: O(1)
    private static int[] solution(int[] A) {
        int dividerBit = 0;
        for(int i=0; i<32; i++) {
            int noOfSetBitsAtI = 0;
            for(int j=0; j<A.length; j++) {
                int ele = A[j];
                if(checkIfIthBitSet(ele, i)) {
                    noOfSetBitsAtI++;
                }
            }
            if((noOfSetBitsAtI & 1) == 1) {
                dividerBit = i;
                break;
            }
        }

        int eleOne = 0;
        int eleTwo = 0;
        for(int i=0; i<A.length; i++) {
            if(checkIfIthBitSet(A[i], dividerBit)) {
                eleOne = eleOne ^ A[i];
            } else {
                eleTwo = eleTwo ^ A[i];
            }
        }

        return new int[]{eleOne, eleTwo};
    }

    private static boolean checkIfIthBitSet(int a, int i) {
        return (a & (1<<i)) != 0;
    }
}
