package practice;

import java.util.ArrayList;

public class Rotate_Array {
    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8};

        int d = 2;

        for(int i=0; i< a.length; i++) {
            System.out.print(a[i]+" ");
        }

        System.out.println("");

        //bruteForce(a, d, a.length);

        int[] result1 = bruteForceTwo(a, d, a.length);

        for(int element: result1) {
            System.out.print(element+" ");
        }

        System.out.println("");

        //int[] result2 = averageSolution(a, d, a.length);
        /*for(int element: result2) {
            System.out.print(element+" ");
        }*/

    }

    private static void averageSolution(int[] a, int d, int n) {


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
