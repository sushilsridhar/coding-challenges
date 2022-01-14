package strings;

/*
    Given a string and start, end index, reverse the substring from s to e
 */
public class ReverseSubstring {

    public static void main(String []args) {

        String str = "whresosyious"; // ans - whysoserious

        System.out.println(solution(str,2, 7));
        System.out.println(solutionStringBuilder(str,2, 7));

    }

    // Using StringBuilder class
    private static String solutionStringBuilder(String str, int start, int end) {

        StringBuilder builder = new StringBuilder(str);

        while(start<end) {
            char temp = builder.charAt(start);
            builder.setCharAt(start, builder.charAt(end));
            builder.setCharAt(end, temp);

            start++;
            end--;
        }

        return builder.toString();
    }

    // Using charArray
    private static String solution(String str, int start, int end) {

        char[] charArray = str.toCharArray();

        while(start<end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            start++;
            end--;
        }

        return String.copyValueOf(charArray);
    }
}
