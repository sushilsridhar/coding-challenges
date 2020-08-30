package arrays;

import java.util.ArrayList;

/* rotate array - left and right rotation */

public class Rotate_Array {
    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] c = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        int d = 4; /* number of shifts */

        printArray(a);

        /* move elements from right to left side */
        rightRotation(a, d, a.length);
        printArray(a);

        /* move elements from left to right side */
        leftRotation(b, d, a.length);
        printArray(b);



    }

    /*
     *  o(n) + o(n/2) + o(n/2) => o(2n) => o(n)
     */
    private static int[] leftRotation(int[] a, int d, int n) {

        reverse(a, 0, n -1);
        reverse(a, 0, n-1-d);
        reverse(a, n-d, n -1);

        return a;
    }

    /*
    *  o(n) + o(n/2) + o(n/2) => o(2n) => o(n)
    */
    private static int[] rightRotation(int[] a, int d, int n) {

        reverse(a, 0, n -1);
        reverse(a, 0, d -1);
        reverse(a, d, n -1);

        return a;
    }

    private static void reverse(int[] a, int startIndex, int endIndex) {

        for(int i=startIndex; i<endIndex; i++, endIndex--) {

            int temp = a[endIndex];
            a[endIndex] = a[i];
            a[i] = temp;
        }

    }

    private static void printArray(int[] a) {

        System.out.println("");

        for(int element: a) {
            System.out.print(element+" ");
        }
    }

    /*
     *  o(n * d), where n is the length of the array, d is number of shifts
     */
    private static int[] bruteForceTwo(int[] a, int d, int n) {

        for(int i=0; i<d; i++) {

            int temp = a[0];

            for(int j=0; j<n-1; j++) {
                a[j] = a[j+1];
            }

            a[n-1] = temp;
        }

        return a;
    }

    private static void bruteForce(int[] a, int d, int n) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=d; i<a.length; i++) {
            list.add(a[i]);
        }

        for(int i=0; i<d; i++) {
            list.add(a[i]);
        }

        for(Integer el: list) {
            System.out.print(el+" ");
        }

    }
}

/*

left rotation

5 6 7 8 9 10 1 2 3 4

1 - reverse the whole array - 10 9 8 7 6 5 4 3 2 1
2 - reverse the array from 0 to size of array - 1 - number of shifts made - 5 6 7 8 9 10 4 3 2 1
3 - reverse the array from size of array - number of shifts - 5 6 7 8 9 10 1 2 3 4


right rotation

7 8 9 10 1 2 3 4 5 6


1 - reverse the whole array - 10 9 8 7 6 5 4 3 2 1
2 - reverse the array from 0 to  number of shifts - 1, 7 8 9 10 6 5 4 3 2 1
3 - reverse the array from number of shifts to array length -1 , 7 8 9 10 1 2 3 4 5 6
*/


