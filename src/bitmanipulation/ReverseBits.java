package bitmanipulation;

/*
    Reverse the bits of an 32 bit unsigned integer A.

 */
public class ReverseBits {

    public static void main(String[] args) {

        System.out.println(reverse(3));
        System.out.println(reverseOptimized(3));

    }

    public static long reverseOptimized(long a) {

        if(a == 0) {
            return 0;
        }

        int i = 31;
        long result = 0;

        while(a > 0) {
            if(a%2 == 1) {
                result = result + (long) Math.pow(2, i);
            }
            i--;
            a = a/2;
        }
        return result;
    }

    private static long reverse(long a) {

        if(a == 0) {
            return 0;
        }

        long[] arr = new long[32];
        int k = 0;

        while(a > 0) {
            arr[k] = a%2;
            k++;
            a = a/2;
        }

        long result = 0;

        for(int i=31,j=0; i>=0 && j<arr.length; i--,j++) {

            if(arr[j] == 1) {
                result = result + (long) Math.pow(2, i);
            }
        }

        return result;
    }
}
