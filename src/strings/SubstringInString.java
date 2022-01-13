package strings;

/*
    1. consider the first character of s2
    2. Iterate s1 and Check if character is present in s1
    3. If yes, iterate in both the strings else check for next first character in s1

    palindrorome, rome
 */
public class SubstringInString {

    public static void main(String []args) {

        System.out.println(isSubstring("palindrome","rome"));
    }

    private static int isSubstring(String s1, String s2) {

        for(int i=0; i<s2.length(); i++) {
            char firstChar = s2.charAt(i);
            int k =0;

            for(int j=0; j< s1.length(); j++) {
                if(firstChar == s1.charAt(j)) {
                    k++;
                    firstChar = s1.charAt(k);
                }

                if(k == s2.length()) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
