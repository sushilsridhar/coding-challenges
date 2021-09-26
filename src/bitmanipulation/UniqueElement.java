package bitmanipulation;

/*
    Given an array of integers A, every element appears twice except for one. Find that single one.
 */
public class UniqueElement {
    public static void main(String[] args) {

        int A[] = {1, 2, 2, 3, 1};
        System.out.println(singleNumber(A));
    }

    public static int singleNumber(final int[] A) {

        int result = 0;
        for(int i=0; i<A.length; i++) {
            result =  result ^ A[i];
        }
        return result;
    }
}
