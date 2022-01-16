package strings;

/*
    You are given a char array, Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.
 */
public class IsAlpha {

    public static void main(String[] args) {

        char[] A = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        char[] B = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};

        System.out.println(solve(A));
        System.out.println(solve(B));
    }

    public static int solve(char[] A) {

        for(int i=0; i<A.length; i++) {
            if(A[i] >= 'a' && A[i] <= 'z') {
                continue;
            } else if(A[i] >= 'A' && A[i] <= 'Z') {
                continue;
            }
            return 0;
        }
        return 1;
    }
}
