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
    A - 65, a - 97, a-A -> 97-65 = 32
    char element = 'A'+32 -> a

    optimized:
    'Z' -> 90  -> 1 0 1 1 0 1 0
    'z' -> 122 -> 1 1 1 1 0 1 0, only one bit change
        XOR 32 -> 0 1 0 0 0 0 0, to toggle cases
 */
public class ToggleCase {
    public static void main(String []args) {

        String str = "aBcDeA"; // ans - AbCdEa

        System.out.println(toggleCase(str));
        System.out.println(solution(str));
        System.out.println(optimized(str));
    }

    private static String optimized(String str) {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            char ans = (char) (str.charAt(i) ^ 32);
            builder.append(ans);
        }

        return builder.toString();
    }

    private static String solution(String str) {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            char currChar = str.charAt(i);

            if(currChar >= 'A' && currChar <='Z') {
                char ans = (char) (currChar+('a'-'A'));
                builder.append(ans);
            } else if(currChar >= 'a' && currChar <='z') {
                char ans = (char) (currChar-('a'-'A'));
                builder.append(ans);
            }
        }

        return builder.toString();
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
