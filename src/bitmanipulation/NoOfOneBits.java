package bitmanipulation;

/*
    Write a function that takes an integer and returns the number of 1 bits it has.

    A: 450676354
    output: 14 - number of 1's in 32 bits
 */
public class NoOfOneBits {
    public static void main(String[] args) {

        System.out.println(numSetBits(450676354));
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
