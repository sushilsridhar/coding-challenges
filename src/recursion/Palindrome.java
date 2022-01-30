package recursion;

/*
    Given a string, write a recursive code to find whether it is palindrome or not

    MADAM
    MALAYALAM
    ABBA
 */
public class Palindrome {

    public static void main(String[] args) {

        String str = "MADAM";
        System.out.println(isPalindrome(str, 0, str.length()-1));
    }

    private static boolean isPalindrome(String str, int start, int end) {

        if(start >= end) {
            return true;
        } else if(str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, ++start, --end);
    }
}
