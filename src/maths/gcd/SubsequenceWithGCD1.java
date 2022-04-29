package maths.gcd;

/*
    Given an array, return true/false if there exists an subsequence with gcd 1

    4 6 3 8
    4, 3 -> 1
    4, 3, 8 -> 1

    approach:

    array: a, b, c, d, e, f

    gcd(b,c,d) = 1 -> gcd(gcd(b,c,d), a) = 1 (using associative property of gcd)

    gcd(1,x) = 1

    gcd(a, b, c, d, e, f)
    gcd(gcd(b,c,d), gcd(a,d,e,f))
    gcd(1,gcd(a,d,e,f)) -> 1
 */
public class SubsequenceWithGCD1 {

    public static void main(String[] args) {

        int a[] = { 4, 3, 8, 6};
        int b[] = { 16, 10, 6, 15, 27};

        System.out.println(subsequenceWithGCD1(a));
        System.out.println(subsequenceWithGCD1(b));
    }

    // tc: O(n * log(max(a,b)))
    private static boolean subsequenceWithGCD1(int[] a) {

        int gcd = gcd(a[0], a[1]);

        for(int i=2; i<a.length; i++) {
            gcd = gcd(gcd, a[i]);
        }

        return gcd == 1;
    }

    private static int gcd(int a, int b) {

        if(b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }
}
