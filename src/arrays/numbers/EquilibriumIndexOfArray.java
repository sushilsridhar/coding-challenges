package arrays.numbers;

/*
    You are given an array A of integers of size N.

    Your task is to find the equilibrium index of the given array

    Equilibrium index of an array is an index such that the sum of elements at lower indexes is
    equal to the sum of elements at higher indexes.

    A=[-7, 1, 5, 2, -4, 3, 0]

    3 is an equilibrium index, because:
    A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 */
public class EquilibriumIndexOfArray {
    public static void main(String[] args) {

        int[] A= {-7, 1, 5, 2, -4, 3, 0};

        System.out.println(prefixSumSolution(A));

        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        if(A.length < 3) {
            return -1;
        }
        int sum = 0;
        for(int i=0; i<A.length; i++) {
            sum = sum + A[i];
        }

        int leftSum = 0;
        for(int i=0; i<A.length; i++) {

            sum = sum - A[i];

            if(leftSum == sum) {
                return i;
            }
            leftSum = leftSum + A[i];
        }

        return -1;
    }

    public static int prefixSumSolution(int[] A) {

        if(A.length < 3) {
            return -1;
        }

        int[] pf = new int[A.length];
        pf[0] = A[0];
        for(int i=1; i<A.length; i++) {
            pf[i] = pf[i-1] + A[i];
        }

        for(int i=0; i<A.length; i++) {

            int firstHalfSum = pf[i] - A[i];
            int secondHalfSum = pf[A.length-1] - pf[i];

            if(firstHalfSum == secondHalfSum) {
                return i;
            }
        }

        return -1;
    }
}
