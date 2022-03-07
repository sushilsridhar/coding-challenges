package bitmanipulation.adv;

/*
    Reverse the bits of an 32 bit unsigned integer A.

    input 3, ans = 3221225472
 */
public class ReverseBits {

    public static void main(String[] args) {

        System.out.println(reverse(3));
    }

    private static long reverse(long a) {

        long r = 0;
        for(int i=0, j=31; i<32; i++, j--) {
            if((a & (1L<<i)) != 0) {
                r = r | (1L<<j);
            }
        }
        return r;
    }
}
