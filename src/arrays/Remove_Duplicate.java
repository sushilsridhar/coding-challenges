package arrays;

import java.util.ArrayList;

public class Remove_Duplicate {
    public static void main(String[] args) {

        int arr[] = { 2, 2, 3, 3, 7, 5};

        //int arr[] = { 2, 1, 3, 3, 7, 5, 5, 5, 7, 9, 10};


        int[] result = bruteForce(arr, arr.length);

        for(int element: result) {
            System.out.print(element+" ");
        }
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
