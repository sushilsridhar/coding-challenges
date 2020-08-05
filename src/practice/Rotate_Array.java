package practice;

import java.util.ArrayList;

/* left rotate array */

public class Rotate_Array {
    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int d = 4; /* number of shifts */

        for(int i=0; i< a.length; i++) {
            System.out.print(a[i]+" ");
        }

        System.out.println("");

        /*int[] result1 = bruteForceTwo(a, d, a.length);

        for(int element: result1) {
            System.out.print(element+" ");
        }*/

        //System.out.println("");

        int[] result2 = bestSolution(a, d, a.length);

        for(int element: result2) {
            System.out.print(element+" ");
        }

    }

    /*
    *  o(n) + o(n/2) + o(n/2) => o(2n) => o(n)
    */
    private static int[] bestSolution(int[] a, int d, int n) {

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
