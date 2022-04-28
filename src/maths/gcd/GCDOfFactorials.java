package maths.gcd;

/*
    Given n array elements, find the gcd of factorials of all the given elements

    4  3     8   6
    24 6 40320 720  -> ans 6

    4! -> 1 * 2 * 3 * 4
    3! -> 1 * 2 * 3
    8! -> 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8
    6! -> 1 * 2 * 3 * 4 * 5 * 6

    3! is the greatest common factor

    tc: O(n) + O(min)
 */
public class GCDOfFactorials {

    public static void main(String[] args) {

        int a[] = { 4, 3, 8, 6};
        System.out.println(gcd(a));
    }

    private static int gcd(int[] a) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++) {
            min = Math.min(min, a[i]);
        }

        int factorial = 1;
        for(int i=1; i<=min; i++) {
            factorial = factorial * i;
        }

        return factorial;
    }
}
