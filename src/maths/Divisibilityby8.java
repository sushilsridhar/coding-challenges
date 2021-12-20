package maths;

/*
    Given a number A in the form of string. Check if the number is divisible by 8 or not.

    Return 1 if it is divisible by 8 else return 0.
 */
public class Divisibilityby8 {

    public static void main(String[] args) {

        String a= "16";
        System.out.println(solve(a));
    }

    public static int solve(String A) {

        int k = A.length();
        long ans = 0;
        long r = 1;
        for(int i=k-1; i>=0; i--) {
            ans = ans + (((A.charAt(i)-48)%8) * r)%8;
            r = (r*10)%8;
            ans = ans%8;
        }

        if(ans%8 == 0) {
            return 1;
        }
        return 0;
    }
}
