package sorting;

import java.util.Arrays;

/*
    Given N array elements , calculate the no of noble integer present,
    a[i] is said to be noble {No of elements < ar[i] } = ar[i]

    Elements are Distinct
                                 -10, -5, 1, 3, 4, 5, 10
    count of elements < ar[i]     0    1  2  3  4  5  6
    index                         0    1  2  3  4  5  6

    Duplicate elements are found

                                  -10, 1, 1, 2, 4, 4, 4, 8, 10
    count of elements < ar[i]      0   1  1  3  4  4  4  7  8
    index                          0   1  2  3  4  5  6  7  8

    observation:

    1. if current element is same as previous element, the number of elements less than the current element won't change
    2. if the element comes for the first time, the number of elements less than a[i] is i
 */
public class NobleInteger {

    public static void main(String[] args) {

        int[] A = { -10, -5 , 1, 3, 4, 5, 10 }; // output - 2

        System.out.println(distinct(A));

        int[] B = { -10, 1, 1, 2, 4, 4, 4, 8, 10 }; // output - 5

        System.out.println(duplicate(B));

        System.out.println(cleanCodeDuplicate(B));
    }

    // Time complexity - nlogn + n
    private static int distinct(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for(int i=0; i<a.length; i++) {
            if(a[i] == i) {
                count++;
            }
        }
        return count;
    }

    // Time complexity - nlogn + n
    private static int cleanCodeDuplicate(int[] a) {
        int count = 0;
        int noOfElementsLessThan = 0;
        Arrays.sort(a);

        for(int i=1; i<a.length; i++) {
            if(a[i] != a[i-1]) {
                noOfElementsLessThan = i;
            }
            if(noOfElementsLessThan == a[i]) {
                count++;
            }
        }
        return count;
    }

    // Time complexity - nlogn + n
    private static int duplicate(int[] a) {
        int count = 0;
        boolean iIsNobleInteger = false;

        Arrays.sort(a);

        if(a[0] == 0) {
            count++;
        }

        for(int i=1; i<a.length; i++) {
            if(a[i] == i) {
                count++;
                iIsNobleInteger = true;
            } else if (a[i]==a[i-1]) {
                if(iIsNobleInteger) {
                    count++;
                }
            } else {
                iIsNobleInteger = false;
            }
        }

        return count;
    }

}
