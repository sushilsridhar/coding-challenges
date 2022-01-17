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
 */
public class ToUpperCase {

    public static void main(String []args) {

        char[] A = {'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'};
        char[] B = {'S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0'};

        char[] out = to_upper(A);
        for(char i: out) {
            System.out.print(i+" ");
        }
        System.out.println("");

        char[] out2 = optimized(B);
        for(char i: out2) {
            System.out.print(i+" ");
        }
    }

    public static char[] to_upper(char[] A) {

        for(int i=0; i<A.length; i++) {
            if(A[i] >= 'a' && A[i] <= 'z') {
                A[i] = (char) (A[i] - ('a'-'A'));
            }
        }
        return A;
    }

    public static char[] optimized(char[] B) {

        for(int i=0; i<B.length; i++) {
            if(B[i] >= 'a' && B[i] <= 'z') {
                B[i] = (char) (B[i] ^ ('a'-'A'));
            }
        }
        return B;
    }
}
