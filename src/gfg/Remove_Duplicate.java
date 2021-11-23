package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/* Remove duplicates in small prime array */

public class Remove_Duplicate {
    public static void main(String[] args) {

        //int arr[] = { 2, 2, 3, 3, 7, 5};

        int arr[] = { 2, 1, 3, 3, 7, 5, 5, 5, 7, 9, 10};

        //int[] result = bruteForce(arr, arr.length);

        //int[] result = Solution(arr, arr.length);

        ArrayList<Integer> result = bestSolution(arr, arr.length);

        for(int element: result) {
            System.out.print(element+" ");
        }
    }

    private static ArrayList<Integer> bestSolution(int arr[], int n)
    {
        int marker[] = new int[100];
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<n; i++)
        {
            if(marker[arr[i]]==0)
            {
                marker[arr[i]]=1;
                list.add(arr[i]);
            }
        }
        return list;
    }

    /*
        works only for int arr[] = { 2, 2, 3, 3, 7, 5};

        when duplicate elements are side by side,

        arrays need to be sorted otherwise, before processing
     */
    private static int[] Solution(int[] arr, int n) {

        Arrays.sort(arr);

        int pos = 0;

        for(int i=0; i<arr.length -1; i++) {

            if(arr[i] != arr[i+1]) {
                arr[pos] = arr[i];
                pos++;
            }
        }

        arr[pos] = arr[arr.length-1];

        int[] result = Arrays.copyOfRange(arr, 0, pos+1);

        //int[] result = IntStream.range(0, pos+1).map(i -> arr[i]).toArray();

        return result;
    }

    /*
        o(n2), where n is length of the array
     */
    private static int[] bruteForce(int arr[], int n)
    {

        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);


        for(int i=1; i<n; i++) {
            boolean addToResult = true;
            int j=0;

            for( ; j<result.size(); j++) {

                if(result.get(j) == arr[i]) {
                    addToResult = false;
                    break;
                }
            }

            if(addToResult) {
                result.add(arr[i]);
            }
        }

        //result.toArray(new Integer[result.size()]); --> returns Integer type

        return result.stream().mapToInt(i -> i).toArray();
    }
}


/*
only works for Sorted , result will be sorted

1. sort the array
2. compare the element of array with adjacent element
3. if both are same, do nothing
4. if both are different, add the element to arr[pos], and increment pos,
5  add last element to the end of the array

*/

/* Best Solution
*
*   1. initialize int[] marker of 100
*   2. marker[arr[i]] == 0 , mark that particular index of marker as 1
*      if arr[i] repeats again, marker[arr[i]] will be 1, hence not added to arraylist
*   3  and add to arraylist
*
* */