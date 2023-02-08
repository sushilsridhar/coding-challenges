package arrays.numbers;

/*
    You are given an array of integers A of size N.
    Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.
 */
public class SubtractMaxEvenMinOdd {
    public static void main(String[] args) {

        int[] A = {5, 17, 100, 1};
        solve(A);
    }

    public static int solve(int[] A) {

        int maxEvenValue = Integer.MIN_VALUE;
        int minOddValue = Integer.MAX_VALUE;

        for(int element: A) {

            if(element%2 == 0) {
                maxEvenValue = Math.max(maxEvenValue, element);
            } else {
                minOddValue = Math.min(minOddValue, element);
            }
        }

        return maxEvenValue - minOddValue;
    }
}
