package arrays.numbers;

/*
    "Primal Power" of an array is defined as the count of prime numbers present in it
    Given an array of integers A of length N, you have to calculate its Primal Power

     A = [-11, 7, 8, 9, 10, 11]

     output - 2

     7 and 11 are prime numbers. Hence, Primal Power = 2.

 */
public class PrimalPower {
    public static void main(String[] args) {

        int[] a = {-11, 7, 8, 9, 10, 11};
        System.out.println(solve(a));
    }

    private static int solve(int[] A) {

        int primalNumberCount = 0;

        for(int i=0; i<A.length; i++) {
            if(A[i] > 1) {
                boolean isPrime = true;

                for(int j=2; j<A[i]; j++) {
                    if(A[i]%j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    primalNumberCount++;
                }
            }
        }
        return primalNumberCount;
    }
}
