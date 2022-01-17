package strings;

/*
    You are given a char array, Return 1 if all the characters of the character array are alphabetical and numeric (a-z and A-Z and 0-9), else return 0.

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

 */
public class IsAlphaNumeric {

    public static void main(String[] args) {

        char[] A = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        char[] B = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};

        System.out.println(solve(A));
        System.out.println(solve(B));
    }

    public static int solve(char[] A) {

        for(int i=0; i<A.length; i++) {
            char currChar = A[i];

            if(currChar >= 'a' && currChar <='z') {
                continue;
            } else if(currChar >= 'A' && currChar <='Z') {
                continue;
            } else if(currChar >= '0' && currChar <='9') {
                continue;
            }
            return 0;
        }
        return 1;
    }
}
