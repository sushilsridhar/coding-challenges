package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Return_Duplicates {

    public static void main(String[] args) {

        int a[] = {26 ,13, 9, 25, 1, 1, 0, 22, 13, 22, 20, 3, 8, 11, 25, 10, 3, 15, 11, 19, 20, 2, 4, 25, 14, 23, 14};


        ArrayList<Integer> result = solution(a, a.length);


        //int a[] = { 2, 3, 1, 2, 3, 7, 7};
        //ArrayList<Integer> result = duplicates(a, a.length);

        for(int r: result) {
            System.out.print(r+" ");
        }
    }

    /* not working properly - check */
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        int flag = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) > 1) {
                ans.add(i);
                flag = 1;
            }
        }
        if (flag == 0) ans.add(-1);
        return ans;
    }


    /* time complexity: o(n), where n is length of the array
     *
     *  space complexity: o(n)
     */
    private static ArrayList<Integer> solution(int arr[], int n) {

        int[] marker = new int[n];

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<n; i++) {
            if(marker[arr[i]] == 0) {
                marker[arr[i]] = 1;
            } else if(marker[arr[i]] == 1) {
                list.add(arr[i]);
                marker[arr[i]] = 2;
            }
        }

        if(list.size() == 0) {
            list.add(-1);
        }

        Collections.sort(list); // --> not required

        return list;
    }
}

/*
    1. mark all elements as 1
    2. if equal to 1, then it is duplicate, add to list and mark it as 2, so that another occurrence is not added

 */
