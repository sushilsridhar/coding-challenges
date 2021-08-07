package numbers;

/*
   Time complexity, o(n), where n is the number of digits in number
 */
public class Palindrome {

    public static void main(String[] args) {

        int n = 2147483647;

        boolean isNegative = n < 0 ? true : false;

        int number = Math.abs(n);

        int r = 0;
        int reverse = 0;

        System.out.println(Integer.MAX_VALUE);

        while(number > 0) {

            r = number%10;

            //reverse = (reverse * 10 + r) < Integer.MAX_VALUE ? (reverse * 10 + r) : -1;

            reverse = reverse * 10 + r;

            System.out.println(reverse);

            if(reverse == -1) {
                break;
            }

            number = number/10;
        }

        System.out.println("final reverse "+reverse);

        if(isNegative) {
            reverse = -reverse;
        }

        if(reverse == n) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not a palindrome");
        }
    }
    static int isSubstring(String s1, String s2) {

        char first_char_of_s2 = s2.charAt(0);

        for(int i = 0; i< s1.length(); i++) {
            char char_of_s1 = s1.charAt(i);

            if(first_char_of_s2 == char_of_s1) {
                int k;
                for(k=0; k<s2.length() && s1.charAt(i+k) == s2.charAt(k); k++) {}

                if(k == s2.length()) {
                    return i;
                }
            }
        }


        return -1;
    }
}


