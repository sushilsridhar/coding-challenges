package arrays.numbers;

/*
    Given an integer array A of size N. In one second you can increase the value of one element by 1.

    Find the minimum time in seconds to make all elements of the array equal.

    A = [2, 4, 1, 3, 2]

    We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.

 */
public class TimeToEquality {

    public static void main(String[] args) {

        int []A = { 2, 4, 1, 3, 2 };

        System.out.println(solve(A));
    }

    public static int solve(int[] A) {

        int max = Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++) {
            max = Math.max(max, A[i]);
        }

        int totalSeconds = 0;

        for(int i=0; i<A.length; i++) {
            if(max != A[i]) {
                totalSeconds = totalSeconds + (max-A[i]);
            }
        }
        return totalSeconds;
    }
}
