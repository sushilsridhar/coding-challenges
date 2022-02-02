package recursion;

/*
    Write a recursive function that, given a string S, prints the characters of S in reverse order.
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
}
