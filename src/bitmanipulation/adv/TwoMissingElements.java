package bitmanipulation.adv;

/*
    Given an array of size n, the array contains all the elements from 1 to n+2 except 2 elements
    Find those two elements.
    Note: Not allowed to modify the input array

    approach:
    convert this problem into two unique elements problem

    3, 6, 1, 4  - original array
    1, 2, 3, 4, 5, 6 - imaginary array from 1 to n+2

    combine,
    [1, 1, 2, 3, 3, 4, 4, 5, 6, 6] , 2 and 5 are unique elements

 */
public class TwoMissingElements {

    public static void main(String[] args) {

        int A[] = {3, 6, 1, 4}; // n = 4

        int[] r = solution(A);
        for(int ele: r) {
            System.out.print(ele+" ");
        }
    }

    // tc: O(n), sc: O(1)
    private static int[] solution(int[] A) {
        int xorAll = 0; // --> have the total xor
        int n = A.length;

        for(int i=1; i<=n+2; i++) {
            xorAll = xorAll ^ i;
        }

        for(int i=0; i<n; i++) {
            xorAll = xorAll ^ A[i];
        }

        // finding the first set bit
        int dividerBitIndex = 0;
        for(int i=0; i<32; i++) {
            if((xorAll & 1)  == 1) {
                dividerBitIndex = i;
                break;
            }
        }

        int eleOne = 0;
        int eleTwo = 0;
        for(int i=1; i<=n+2; i++) {
            if((i & (1<<dividerBitIndex)) != 0) {
                eleOne = eleOne ^ i;
            } else {
                eleTwo = eleTwo ^ i;
            }
        }

        for(int i=0; i<A.length; i++) {
            if((A[i] & (1<<dividerBitIndex)) != 0) {
                eleOne = eleOne ^ A[i];
            } else {
                eleTwo = eleTwo ^ A[i];
            }
        }

        return new int[]{eleOne, eleTwo};
    }
 }
