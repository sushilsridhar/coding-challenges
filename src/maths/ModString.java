package maths;

/*
    You are given a huge number in the form of a string A where each character denotes a digit of the number.
    You are also given a number B. You have to find out the value of A % B and return it.

    constraints:
    1 <= A.size() <= 105
    0 <= Ai <= 9
    1 <= B <= 109
 */
public class ModString {

    public static void main(String[] args) {

        String a = "43535321";
        int b = 47;

        System.out.println(findMod(a,b));
    }

    public static int findMod(String A, int B) {
        int k = A.length();
        long ans = 0;  // this can overflow, so long
        long r=1;     // this can overflow, so long
        for(int i=k-1; i>=0; i--) {
            ans = ans + ((A.charAt(i)-48)%B * r)%B;
            r = (r*10)%B;
            ans = ans%B;
        }
        return (int)ans%B;
    }
}
