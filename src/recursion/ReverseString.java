package recursion;

/*
    Write a recursive function that, given a string S, prints the characters of S in reverse order.

    tc: O(n), number of characters
    sc: O(n), number of characters
 */
public class ReverseString {

    public static void main(String[] args) {

        reverseString("cool", 0);
    }

    private static String reverseString(String str, int i) {

        if(i == str.length()-1) {
            System.out.print(str.charAt(i));
            return "";
        }

        reverseString(str, i+1);
        System.out.print(str.charAt(i));
        return "";
    }

    // printReverse("cool", 3)
    private static String printReverse(String str, int n) {

        if(n == 0) {
            return str.charAt(0)+"";
        }

        return str.charAt(n) + printReverse(str, n-1);
    }
}
