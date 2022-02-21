package bitmanipulation.adv;

/*
    Given an array of integers A, every element appears thrice except for one. Find that single one.

    contribution of repeating element is 3*x on any position, where x is the number of same elements

    1,2,3,1,2,3,1,2,3,5

    3 2 1 0
    -------
    0 0 0 1 - 1
    0 0 1 0 - 2
    0 0 1 1 - 3
    0 0 0 1 - 1
    0 0 1 0 - 2
    0 0 1 1 - 3
    0 0 0 1 - 1
    0 0 1 0 - 2
    0 0 1 1 - 3
    0 1 0 1 - 5

    contribution at position 0 is, 7, 3 from 1, 3 from 3 and 1 from 5
    repeating element contribution is 6 (3+3)
    unique element contribution is 1
 */
public class UniqueElementTwo {

    public static void main(String[] args) {

        int A[] = {5, 7, 7, 5, 5, 4, 7, 11, 9, 11, 4, 4, 11};
        System.out.println(solution(A));
    }

    private static int solution(int[] a) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int noOfSetBits = 0;
            for (int j = 0; j < a.length; j++) {
                if (checkIfIthBitSet(a[j], i)) {
                    noOfSetBits++;
                }
            }

            if (noOfSetBits % 3 == 1) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }

    private static boolean checkIfIthBitSet(int a, int i) {
        return (a&(1<<i)) != 0;
    }
}
