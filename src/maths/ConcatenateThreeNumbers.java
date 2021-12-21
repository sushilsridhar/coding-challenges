package maths;

/*
    Given three 2-digit integers, A, B and C, find out the minimum number that can be obtained by concatenating them in any order.
    Return the minimum result that can be obtained.

    constraint: 10 <= A, B, C <= 99

    another solution: There are only 3! = 6 ways of arranging the numbers.
    ABC
    BAC ..

    if(A <= B and B <= C)
        return A*10000 + B*100 + C;
    else if(A <= C and C <= B)
        return A*10000 + C*100 + B;
    else if(B <= A and A <= C)
        return B*10000 + A*100 + C;
    else if(B <= C and C <= A)
        return B*10000 + C*100 + A;
    else if(C <= A and A <= B)
        return C*10000 + A*100 + B;
    else
        return C*10000 + B*100 + A;
 */
public class ConcatenateThreeNumbers {

    public static void main(String[] args) {

        int  A = 55, B = 43, C = 47; // output 434755
        System.out.println(solve(A,B,C));
    }

    public static int solve(int A, int B, int C) {

        int sum = A + B + C;

        int min = Math.min(Math.min(A,B),C);
        int max = Math.max(Math.max(A,B),C);

        int middle = sum - min - max;

        return min * 10000 + middle * 100 + max;
    }
}
