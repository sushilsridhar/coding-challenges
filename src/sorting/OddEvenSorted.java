package sorting;

import java.util.ArrayList;

/*
    Given an array of size n, sort the given array
     - all odd valued elements are present in sorted order
     - all even valued elements are present in sorted order

    approach:
    1. split the array into even array and odd array
    2. merge the array, comparing the values

    each array element is visited by the pointer only once,
    we can use the input array itself for storing result instead of creating a result array

    tc: O(n), sc: O(n)
 */
public class OddEvenSorted {

    public static void main(String[] args) {

                //  0  1  2  3   4   5   6   7
        int[] a = { 3, 9, 2, 4, 12, 11, 18, 15};

        int[] r = solution(a);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    private static int[] solution(int[] a) {
        int n = a.length;

        int[] even = new int[n];
        int[] odd = new int[n];
        int evenCount = 0;
        int oddCount = 0;

        for(int i=0; i<a.length; i++) {
            if((a[i] & 1) == 0) {
                even[evenCount] = a[i];  // 2 4 12 18
                evenCount++;
            } else {
                odd[oddCount] = a[i];   //  3 9 11 15
                oddCount++;
            }
        }

        int evenIndex = 0;
        int oddIndex = 0;
        int[] r = new int[a.length]; // we can use the input array itself for storing result
        int rIndex = 0;

        while(evenIndex < evenCount && oddIndex < oddCount) {

            if(even[evenIndex] <= odd[oddIndex]) {
                r[rIndex] = even[evenIndex];
                evenIndex++;
            } else {
                r[rIndex] = odd[oddIndex];
                oddIndex++;
            }
            rIndex++;
        }

        while(evenIndex < evenCount) {
            r[rIndex] = even[evenIndex];
            evenIndex++;
            rIndex++;
        }

        while(oddIndex < oddCount) {
            r[rIndex] = odd[oddIndex];
            oddIndex++;
            rIndex++;
        }

        return r;
    }
}
