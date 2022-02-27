package recursion;

/*
    Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
    Given f(0)=1; f(1)=1; f(2)=2;

    f(3) = 2+1+1+3 = 7

    try dynamic programming approach
 */
public class AnotherSequenceProblem {

    public static void main(String[] args) {

        System.out.println(solve(3));;
    }

    private static int solve(int A) {

        if(A == 0 || A == 1) {
            return 1;
        }
        if(A == 2) {
            return 2;
        }

        return solve(A-1) + solve(A-2) + solve(A-3) + A;
    }
}
