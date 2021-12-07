package arrays.numbers;

/*
    Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] |
    where i != j and |x| denotes the absolute value of x.

    Return the minimum value of | A[i] - A[j] |

     A = [5, 17, 100, 11]
     answer:  The minimum value is 6 (|11 - 5| or |17 - 11|)
 */
public class MinimiumAbsoluteDifference {
    public static void main(String[] args) {

        int[] A = {5, 17, 100, 11};
        System.out.println(bruteForce(A));
    }

    public static int bruteForce(int[] A) {

        int r = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {

                r = Math.min(r, Math.abs(A[i]-A[j]));
            }
        }
        return r;
    }
}
