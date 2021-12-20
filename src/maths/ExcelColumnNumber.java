package maths;

/*
    Given a column title as appears in an Excel sheet, return its corresponding column number.

    ABCD -> 19010

    explanation:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

    binary is off base 2, [0,1] range for each digit, these alphabets are off base 26,
    ABCD -> max value of each alphabet is 26, -> convert this alphabet to decimal, same as binary to decimal convertion

    D * 26^0 + C * 26^1 + B * 26^2 + D * 26^3

    4 * 26^0 + 3 * 26^1 + 2 * 26^2 + 1 * 26^3 = 19010

    A.charAt(i)-'A'+1 --> 'D'-'A' + 1 -> 4-1 +1 = 4, 4 is the position of D
 */
public class ExcelColumnNumber {

    public static void main(String[] args) {

        String a= "ABCD";
        System.out.println(titleToNumber(a));
    }

    public static int titleToNumber(String A) {

        int k = A.length();
        int ans=0, mul=1;
        for(int i=k-1; i>=0; i--) {
            ans = ans + ((A.charAt(i)-'A'+1)*mul);
            mul = mul * 26;
        }
        return ans;
    }
}
