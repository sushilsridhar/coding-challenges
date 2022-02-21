package bitmanipulation.adv;

/*
    You have an array A with N elements. We have 2 types of operation available on this array :
    1. We can split a element B into 2 elements C and D such that B = C + D.
    2. We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.

    You have to determine whether it is possible to make array A containing only 1 element i.e. 0 after several splits and/or merge?

    approach
    [1, 2, 3, 4, 5]

    even number can be split up into two values, 4 -> 2+2 and take 2^2 becomes 0
    odd number can be merged to form even number, 3^5 --> 6, even number can be made 0

    if the count of odd numbers is even, then yes else no

    {1, 2, 3, 4}  ans -> Yes
    {1, 2, 3, 4, 5}  ans -> No
 */
public class InterestingArray {

    public static void main(String[] args) {

        int A[] = {1, 2, 3, 4, 5};  // ans -> Yes
        System.out.println(solve(A));
    }

    // tc: O(n)
    private static String solve(int[] A) {
        int countOfOdd = 0;
        for(int i=0; i<A.length; i++) {
            if((A[i]&1) == 1) {
                countOfOdd++;
            }
        }
        if((countOfOdd&1) == 1){
            return "No";
        }

        return "Yes";
    }
}
