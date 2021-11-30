package numbers;

/*
    "Primal Power" of an array is defined as the count of prime numbers present in it.
    Given an array of integers A of length N, you have to calculate its Primal Power

    prime number - it has only two factors 1 and itself
    If number N is prime number, it has no factors from 2 to root N
 */
public class PrimalPower {

    public static void main(String[] args) {
        int a[] = {-11, 7, 8, 9, 10, 11};

        System.out.println(solve(a));
    }

    public static int solve(int[] A) {

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
