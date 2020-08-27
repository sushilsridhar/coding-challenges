package arrays;

import java.util.ArrayList;

/*
    Time complexity: o(n), where n is size of array
 */
public class Max_Second_Max {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 10, 15, 10, 2, 4, 5, 6, 15};

        ArrayList<Integer> arrayList = largestAndSecondLargest(arr.length, arr);

        for(int a : arrayList) {
            System.out.println(a);
        }

    }

    private static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[])
    {
        ArrayList<Integer> results = new ArrayList<>();
        int largest = Integer.MIN_VALUE, second_largest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if (arr[i] > largest) {
                second_largest = largest;
                largest = arr[i];
            } else if (arr[i] > second_largest && arr[i] != largest) {
                second_largest = arr[i];
            }
        }

        results.add(largest);
        if(second_largest == Integer.MIN_VALUE) {
            results.add(-1);
        } else {
            results.add(second_largest);
        }

        return results;
    }
}

/*

1. assign, min value to two variables, max and second max
2. iterate the array to just mark and find max and second max
 */