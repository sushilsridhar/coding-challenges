package maths;

/*
    Given eight integers A, B, C, D, E, F, G and H which represent two rectangles in a 2D plane.
    For the first rectangle it's bottom left corner is (A, B) and top right corner is (C, D) and for the second rectangle it's bottom left corner is (E, F) and top right corner is (G, H).

    Find and return whether the two rectangles overlap or not.

    check FindIfTwoRectangleOverlap image for explanation
 */
public class FindIfTwoRectangleOverlap {

    public static void main(String[] args) {

        int A = 0 ,  B = 0;
        int C = 4 ,  D = 4;
        int E = 2 ,  F = 2;
        int G = 6 ,  H = 6;

        System.out.println(solve(A,B,C,D,E,F,G,H));
    }

    public static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {

        if( C<=E || A>=G || D<=F || B>=H) {
            return 0;
        }
        return 1;
    }
}
