package maths.primenumbers;

/*
    Given a number n, count the number of factors of n

    16 -> 1 2 4 8 16, ans = 5

    tc: O(sqrt(n))
 */
public class CountNoOfFactors {

    public static void main(String[] args) {

        System.out.println(bruteForce(16));
        System.out.println(optimized(16));
    }

    // tc: O(sqrt(n))
    private static int optimized(int n) {

        int count = 0;

        for(int i=1; i*i<=n; i++) {
            if(n%i == 0) {
                count++;

                if(n/i != i) {
                    count++;
                }
            }
        }
        return count;
    }

    // tc: O(n)
    private static int bruteForce(int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(n%i == 0) {
                count++;
            }
        }
        return count;
    }
}
