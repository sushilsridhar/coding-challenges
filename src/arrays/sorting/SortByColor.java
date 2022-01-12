package arrays.sorting;

public class SortByColor {
    public class Solution {
        public int[] sortColors(int[] A) {

            int n = A.length;

            if(n == 1) {
                return A;
            }

            if(n == 2) {
                A[0] = 0;
                A[1] = 1;
                return A;
            }

            int numberOfInsertions = n/3;
            int i = 0, count = 0, elementToBeInserted = 0;

            while(i<n) {
                if(count < numberOfInsertions) {
                    A[i] = elementToBeInserted;
                    count++;
                } else {
                    elementToBeInserted = elementToBeInserted + 1;
                    A[i] = elementToBeInserted;
                    count = 1;
                }
                i++;
            }
            return A;
        }
    }

}
