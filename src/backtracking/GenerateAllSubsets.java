package backtracking;

import java.util.ArrayList;

/*
    Given an array of size n, (distinct elements), generate all subsets of it

    arr = { 1, 2, 3}

    subset can be empty,
    {}
    {3 }
    {2 }
    {2 3 }
    {1 }
    {1 3 }
    {1 2 }
    {1 2 3 }

    approach,
    for each element, you can make a decision, whether to include that element in subset or not,

    0 means rejection
    1 means inclusion

    at each index, we make two decisions and track the outcome, until we reach the end of the array

    tc: O(2^n), n is the size of the array, if n = 3, 2^3 = 8, 8 subsets are present
    space complexity is O(h), where h is the height of tree in function call stack, h is n, as there are n function calls in stack at a given point, so
    sc: O(n)
 */
public class GenerateAllSubsets {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        ArrayList<Integer> container = new ArrayList<>();
        backtracking(arr, container, 0);
    }

    private static void backtracking(int[] arr, ArrayList<Integer> container, int index) {

        if(index == arr.length) {
            System.out.print("{");
            for(int i: container) {
                System.out.print(i+" ");
            }
            System.out.print("}");
            System.out.println("");
            return;
        }

        backtracking(arr, container, index+1);

        container.add(arr[index]);
        backtracking(arr, container, index+1);
        container.remove(container.size()-1);
    }
}
