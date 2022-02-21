package bitmanipulation;

/*
    Write a function that takes an integer and returns the number of 1 bits it has.

    A: 450676354
    output: 14 - number of 1's in 32 bits
 */
public class NoOfOneBits {
    public static void main(String[] args) {

        System.out.println(numSetBits(450676354));

        System.out.println(numSetBits(24));

        System.out.println(Optimized(24));

        System.out.println(MoreOptimized(24)); // log n is better

    }

    // number of iterations is log n, where n = n/2
    private static int MoreOptimized(int n) {

        int count = 0;
        while(n>0) {
            if((n&1) == 1)
                count++;

            n = n>>1; // this is n = n/2, 16 8 4 2 1 -> binary place
            // assignment of result to n above is important else n is not updated
        }
        return count;
    }

    // runs for 32 iterations
    private static int Optimized(int n) {

        int count = 0;
        for(int i=0; i<32; i++) {
            if(checkIthBitSetOrNot(n, i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkIthBitSetOrNot(int n, int i) {

        return ((n >> i) & 1) == 1;
    }

    public static int numSetBits(int A) {

        int arr[] = new int[32];
        int i=0;
        while(A>0) {
            arr[i] = A%2;
            i++;
            A=A/2;
        }

        int count = 0;
        for(int j=0; j<arr.length; j++) {
            if(arr[j] == 1) {
                count++;
            }
        }
        return count;
    }
}
