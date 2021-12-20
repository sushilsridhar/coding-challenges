package maths;

/*
    Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.

    Constraints
    1 <= A, B <= 109
    A != B

    input:
    A = 5
    B = 10
    For M = 5, A % M = 0 and B % M = 0.

    intuition:
    3 possibilities, A>B, B>A, A=B, in last case m=A

    A>B,
    B = B
    B = A - (A-B), take modulus of A-B on both sides
    B%(A-B) = (A - (A-B))%(A-B)
    B%(A-B) = (A%(A-B) - (A-B)%(A-B))

    B%(A-B) = A%(A-B) , M = A-B

    B>A, A=A, A = B - (B-A) -> ans is B-A, general answer is abs(A-B)

 */
public class ABandModulo {

    public static void main(String[] args) {

        int a=5, b=10;
        System.out.println(solve(a,b));
        System.out.println(bestSolution(a,b));
    }

    // time complexity: o(1)
    public static int bestSolution(int A, int B) {
        return Math.abs(A-B);
    }

    // time complexity: o(n) , worst case n = 10^9, TLE
    public static int solve(int A, int B) {

        int n =0;
        if(A>B) {
            n=A;
        } else {
            n=B;
        }

        int ans = 0;

        for(int i=1; i<n; i++) {
            if(A%i == B%i) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }
}
