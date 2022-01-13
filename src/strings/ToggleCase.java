package strings;

/*

    ASCII value of
    0  'A' - 65
    1  'B' - 66
    2  'C' - 67
    25 'Z' - 90

    0  'a' - 97
    1  'b' - 98
    2  'c' - 99
    25 'z' - 122

    '0' - 48
    '1' - 49
    '9' - 57

    observation:
    A - 65, a - 97, 97-65 = 32
    char element = 'A'+32 -> a
 */
public class ToggleCase {
    public static void main(String []args) {

        String str = "aBcDeA"; // ans - AbCdEa

        System.out.println(toggleCase(str));

    }

    private static String toggleCase(String str) {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            char currChar = str.charAt(i);

            if(currChar >= 65 && currChar <=90) {
                char ans = (char) (currChar+32);
                builder.append(ans);
            } else if(currChar >= 97 && currChar <=122) {
                char ans = (char) (currChar-32);
                builder.append(ans);
            }
        }

        return builder.toString();
    }
}
