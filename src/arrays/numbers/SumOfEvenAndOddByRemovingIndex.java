package arrays.numbers;

public class SumOfEvenAndOddByRemovingIndex {
    public static void main(String[] args) {

        int []A = { 1, 2, 3, 7, 1, 2, 3 };

        System.out.println(solve(A));
    }

    public static int solve(int[] A) {

        int count=0;
        int evenSum=0, oddSum=0;

        for(int i=0; i<A.length; i++) {
            if(i%2==0) {
                evenSum = evenSum + A[i];
            } else {
                oddSum = oddSum + A[i];
            }
        }

        for(int i=0; i<A.length; i++) {
            int eSum=evenSum, oSum=oddSum;

            if(i%2==0) {
                eSum = eSum - A[i];
            } else {
                oSum = oSum - A[i];
            }

            if(eSum == oSum) {
                count++;
            }
        }
        return count;
    }
}
