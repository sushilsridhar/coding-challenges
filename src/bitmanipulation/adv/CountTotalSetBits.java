package bitmanipulation.adv;

/*
    Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
    Return the count modulo 109 + 7.


 */
public class CountTotalSetBits {

    public static void main(String[] args) {

        System.out.println(bruteForce(3)); // ans = 4
    }

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
