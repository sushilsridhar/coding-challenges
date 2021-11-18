package bitmanipulation;

/*
    Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice.
    Find the two elements that appear only once.

    step 1: find all elements XOR
    step 2: In the XOR results, find the first set bit (which is the bit set as 1)
    step 3: split the array elements based pos which is set (refer intro to bits 2, scaler notes)
 */
public class TwoUniqueElements {

     public static void main(String[] args) {

         int[] A = { 1, 2, 3, 1, 2, 4};

         int[] arr = solve(A);
      }

     public static int[] solve(int[] A) {

        int allXor = 0;
        for(int i=0; i<A.length; i++) {
            allXor = allXor ^ A[i];
        }

        int first1bitPos = 0;

        for(int i=0; i<32; i++) {
            if(checkBitSetOrUnset(allXor, i)) {
                first1bitPos = i;
                break;
            }
        }

        int set = 0, unset = 0;
        for(int i=0; i<A.length; i++) {
            if(checkBitSetOrUnset(A[i], first1bitPos)) {
                set = set ^ A[i];
            } else {
                unset = unset ^ A[i];
            }
        }

        int[] arr = new int[2];

        if(set < unset) {
            arr[0] = set;
            arr[1] = unset;
        } else {
            arr[0] = unset;
            arr[1] = set;
        }

        return arr;
    }

    public static boolean checkBitSetOrUnset(int n, int i) {
        return ((n >> i) & 1) == 1;
    }
}
