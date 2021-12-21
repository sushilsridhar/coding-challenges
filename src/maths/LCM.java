package maths;

/*
    You are given two non-negative integers A and B, find the value of Least Common Multiple (LCM) of A and B.

    LCM of two integers is the smallest positive integer that is divisible by both.

    constraints: 1 <= A, B <= 1000

    18 is the smallest positive integer which is divisible by both 9 (9 * 2 = 18) and 6 (6 * 3 = 18).

    solution:
    1. find the Greatest common divisor - GCD, gcd can be in range of [1 - min(a,b)]
    2. lcm = (a * b)/gcd
 */
public class LCM {

    public static void main(String[] args) {

        int A = 9, B = 6;
        System.out.println(LCM(9, 6));

        System.out.println(bestSolution(9, 6));
    }

    public static int bestSolution(int A, int B) {
        int g = 1;
        for(int i=1; i<=Math.min(A,B); i++) {
            if(A % i == 0 && B % i == 0) {
                g = i;
            }
        }

        return (A * B)/g;
    }

    public static int LCM(int A, int B) {
        int ans = 0;
        for(int i=1; i<=1000; i++) {
            ans = A*i;
            if(ans%B==0) {
                break;
            }
        }
        return ans;
    }
}
