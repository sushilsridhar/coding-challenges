package strings;

/*
    Given a string, which stores a sentence, reverse words in the sentence
    string does not have extra space in start and end
    every word is separated by a single space only

    s = "here is a picture"
    o = "picture a is here"

    steps:
    1. reverse the whole sentence, erutcip a si ereh
    2. reverse each word, picture a is here
 */
public class ReverseSentence {

    public static void main(String []args) {

        String str = "here is a picture";

        System.out.println(solution(str));
    }

    // Time complexity: ??
    private static String solution(String str) {

        int n = str.length()-1;

        StringBuilder builder = new StringBuilder(str);

        StringBuilder reversedString = reverseString(builder, 0, n); // O(n)

        int start = 0, end = 0;

        for(int i=0; i<=n; i++) {
            if(reversedString.charAt(i) == ' ') {
                end = i-1;
                reverseString(reversedString, start, end);
                start = i + 1;
            } else if(i == n) {
                end = i;
                reverseString(reversedString, start, end);
            }
        }

        return reversedString.toString();
    }

    private static StringBuilder reverseString(StringBuilder builder, int start, int end) {

        if(start == end) {
            return builder;
        }

        while(start<end){
            char temp = builder.charAt(start);
            builder.setCharAt(start, builder.charAt(end));
            builder.setCharAt(end, temp);
            start++;
            end--;
        }

        return builder;
    }
}
