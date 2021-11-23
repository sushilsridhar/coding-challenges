package bitmanipulation;

public class SmallestXor {

    public static void main(String[] args ) {

        System.out.println(solve(4, 6));
    }

    public static int solve(int A, int B) {

        int countOfSetBitsInA = 0;
        for(int i=0; i<32; i++) {
            if(checkIthBitSetOrUnset(A, i)) {
                countOfSetBitsInA++;
            }
        }

        int[] arr = new int[32];

        int k = 31;
        while(A > 0) {
            arr[k] = A%2;
            k--;
            A=A/2;
        }

        if(countOfSetBitsInA < B) {
            int noOfBitsToBeSet = B - countOfSetBitsInA;

            for(int i=31; i>=0 && noOfBitsToBeSet>0; i--) {
                if(arr[i] == 0) {
                    arr[i] = 1;
                    noOfBitsToBeSet--;
                }
            }
        } else if(countOfSetBitsInA > B) {
            int noOfBitsToBeSet = countOfSetBitsInA - B;

            for(int i=31; i>=0 && noOfBitsToBeSet>0; i--) {
                if(arr[i] == 1) {
                    arr[i] = 0;
                    noOfBitsToBeSet--;
                }
            }
        }

        int result = 0;
        for(int i=0,j=31; i<arr.length && j>=0; i++,j--) {
            if(arr[j] == 1) {
                result = result + (int) Math.pow(2, i);
            }
        }
        return result;
    }

    private static boolean checkIthBitSetOrUnset(int A, int i) {
        return ((A >> i) & 1) == 1;
    }
}
