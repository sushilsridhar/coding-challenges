package sorting;

public class MergeTwoSortedArray {

    public static void main(String[] args) {

    }

    public int[] solve(final int[] A, final int[] B) {

        int aLen = A.length;
        int bLen = B.length;

        int[] r = new int[aLen+bLen];
        int aIndex = 0;
        int bIndex = 0;
        int rIndex = 0;

        while(aIndex < aLen && bIndex < bLen) {

            if(A[aIndex] <= B[bIndex]) {
                r[rIndex] = A[aIndex];
                aIndex++;
            } else {
                r[rIndex] = B[bIndex];
                bIndex++;
            }

            rIndex++;
        }

        while(aIndex < aLen) {
            r[rIndex] = A[aIndex];
            aIndex++;
        }

        while(bIndex < bLen) {
            r[rIndex] = B[bIndex];
            bIndex++;
        }

        return r;
    }
}
