package arrays.printpatterns;

/*
    1 0 0 0
    1 2 0 0
    1 2 3 0
    1 2 3 4
 */
public class ArrayPattern {
    public static void main(String[] args) {

        int A =4;
        int[][] b = solve(A);

        for(int i=0; i<b.length; i++) {
            System.out.println();
            for(int j=0; j<b.length; j++) {
                System.out.print(b[i][j]+" ");
            }
        }
    }

    public static int[][] solve(int A) {

        int[][] output = new int[A][A];

        for(int i=0; i<A; i++) {
            for(int j=0; j<=i; j++) {
                output[i][j] = j+1;
            }
        }
        return output;
    }
}
