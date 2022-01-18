package strings;

/*
    Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

    Concatenate the string with itself.
    Delete all the uppercase letters.
    Replace each vowel with '#'.
    You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

    NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.

    String str = "AbcaZeoB";
    "bc###bc###"

 */
public class StringOperations {

    public static void main(String []args) {

        String str = "AbcaZeoB";

        System.out.println(solve(str));
    }

    public static String solve(String A) {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<A.length(); i++) {
            char currChar = A.charAt(i);

            if(currChar >= 'a' && currChar <= 'z') {
                if(currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u') {
                    builder.append('#');
                } else {
                    builder.append(currChar);
                }
            }
        }
        builder.append(builder);
        return builder.toString();
    }
}
