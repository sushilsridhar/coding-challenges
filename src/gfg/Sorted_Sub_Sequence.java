package gfg;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorted_Sub_Sequence {
    public static void main(String[] args) {

        //int[] a = { 1, 2, 1, 4, 5, 11, 10, 6};

        int[] a = { 5, 7, 4, 8};

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 1, 4, 5, 1, 2, 6));

        //int[] a = { 1, 1, 1, 3};

        //boolean found = bruteForce(a, a.length);
        //System.out.println(found);

        ArrayList<Integer> result = find3Numbers(arr, arr.size());

        for(int r: result) {
            System.out.print(r+ " ");
        }

    }

    private static ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int small = Integer.MAX_VALUE, large = Integer.MAX_VALUE;

        int i=0;
        for(; i<n; i++) {

            if(arr.get(i) <= small) {
                small = arr.get(i);
            }
            else if(arr.get(i) <= large) {
                large = arr.get(i);
            }
            else {
                break;
            }
        }

        /*  if third element is not found, return empty arraylist */
        if(i == n) {
            return result;
        }

        /*
        [5, 7, 4, 8]

        in this case, the small would become 4, it will fail the condition i<j<k, arr[i]<arr[j]<arr[k]

        hence below logic, to fetch the first small number less than large
        */
        for(int j=0; j<=i; j++) {

            if(arr.get(j) < large) {
                small = arr.get(j);
                break;
            }
        }

        result.add(small);
        result.add(large);
        result.add(arr.get(i));

        return result;
    }

    private static boolean bruteForce(int[] a, int n) {

        boolean found = false;

        for(int i=0; i<n; i++) {

            int element = a[i];
            int sequenceCount = 1;

            for(int j=i+1; j<n; j++) {

                if(a[j] == element+1) {
                    sequenceCount++;
                    element = a[j];
                }
            }

            if(sequenceCount >= 3) {
                found = true;
                break;
            }
        }

        return found;

    }
}

/*

[5, 7, 4, 8]

Find the smallest and second smallest

small = 5
second small = 7

break the loop, if the array value is not less than small and second small, then we have a sequence.
arr[i], would be the third element,



In this case, [5, 7, 4, 8]

the small will get reassigned to 4, which will break the condition, i<j<k or arr[i]<arr[j]<arr[k]

so run a for loop , find the first value less than large, we will get the sequence.


 */