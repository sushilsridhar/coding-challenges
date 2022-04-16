package strings;

/*
    You are given a string A of size N.

    Return the string A after reversing the string word by word.

    NOTE:

    1. A sequence of non-space characters constitutes a word.
    2. Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
    3. If there are multiple spaces between words, reduce them to a single space in the reversed string.

    tc: O(n^2)
 */
public class ReverseSentenceTwo {

    public static void main(String[] args) {

        String str = "the sky is blue";

        String str1 = " the sky is blue ";

        String str2 = "the sky is   blue";

        String str3 = "   the     sky    is      blue   ";

        System.out.println(solve(str));
        System.out.println(solve(str1));
        System.out.println(solve(str2));
        System.out.println(solve(str3));

    }

    // tc: O(n^2)
    private static String solve(String A) {

        A = A.trim();

        StringBuilder builder = new StringBuilder(A);
        reverse(builder, 0, A.length()-1);

        int start = 0;
        int end = 0;
        int len = builder.length();

        int i=0;
        while(i<len) {

            if(builder.charAt(i) == ' ') {

                if(builder.charAt(i-1) == ' ') { // handling multiple spaces between words
                    builder.deleteCharAt(i);
                    len--;
                    continue;
                }

                end = i-1;
                reverse(builder, start, end);
                start = i+1;
            }

            i++;
        }

        reverse(builder, start, builder.length()-1); // reverse the last word

        return builder.toString();
    }

    private static StringBuilder reverse(StringBuilder builder, int start, int end) {

        while(start<end) {
            char temp = builder.charAt(start);
            builder.setCharAt(start, builder.charAt(end));
            builder.setCharAt(end, temp);
            start++;
            end--;
        }

        return builder;
    }
}
