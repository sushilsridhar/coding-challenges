package twopointers;

/*
    Given a sorted array of size n and a integer k,
    find a pair i,j such that A[i] & A[j] = k

    approach: two pointers

    increase i, sum increase
    decrease j, sum decrease

    approach:
    one pointer at the start and one pointer at end

    tc: O(n)
    sc: O(1)
 */
public class PairWithGivenSum {

    public static void main(String[] args) {
            //      0  1  2   3   4   5   6
        int a[] = { 1, 3, 5, 10, 20, 23, 30}; // ans -> 1,4 return true
        int k = 23;

        System.out.println(bruteForce(a, k));

        System.out.println(twoPointers(a, k));
    }

    // tc: O(n)
    private static boolean twoPointers(int[] a, int k) {

        int i = 0;
        int j = a.length-1;

        while(i<j) {
            int sum = a[i] + a[j];

            if(sum == k) {
                return true;
            } else if(sum > k) {
                j--;
            } else if(sum < k) {
                i++;
            }
        }

        return false;
    }

    // tc: O(n^2)
    private static boolean bruteForce(int[] a, int k) {

        for(int i=0; i<a.length; i++) {
            for(int j=i+1; j<a.length; j++) {
                if(a[i]+a[j] == k) {
                    return true;
                }
            }
        }

        return false;
    }
}
