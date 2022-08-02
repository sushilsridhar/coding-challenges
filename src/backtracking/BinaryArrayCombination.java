package backtracking;

import java.util.ArrayList;

/*
    Given n, generate all combination of binary arrays of size n

    n = 2,

    output,
    0 0
    0 1
    1 0
    1 1

                     0 0
             0 0     0 1

    0 0

             1 0     1 0
                     1 1

    consider both scenario, add 0 to first index and add 1 to first index, then move to second index, add 0 or 1 there,
    when pointer moves out of array size, we have reached a combination

    tc: O(n * 2^n)
    sc: O(n)

    n for iterating and printing final result,
    total number of function calls is 2^0 + 2^1 + 2^2 ... 2^n ~ approx 2^n

    total number of times printing happens, total number of functions calls at leaf, 2^n
    so time complexity is n * 2^n (printing) + 2^n (all function calls)

    sc: O(n), at any point, the total number of active calls in stack in height of the tree,
    here height is n

 */
public class BinaryArrayCombination {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[n];

        backtracking(arr, 0);

        System.out.println("");
        System.out.println("Using Dynamic array, ");

        ArrayList<Integer> list = new ArrayList<>();

        backtrackingWithDynamicArray(0, n, list);
    }

    private static void backtrackingWithDynamicArray(int index, int n, ArrayList<Integer> list) {

        if(index == n) {
            for(int i: list) {
                System.out.print(i+" ");
            }
            System.out.println("");
            return;
        }

        list.add(index, 0);
        backtrackingWithDynamicArray(index+1, n, list);
        list.remove(index);

        list.add(index, 1);
        backtrackingWithDynamicArray(index+1, n, list);
        list.remove(index);
    }

    private static void backtracking(int[] arr, int index) {

        if(index == arr.length) {
            for(int i=0; i<arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
            return;
        }

        arr[index] = 0;
        backtracking(arr,index+1);

        arr[index] = 1;
        backtracking(arr,index+1);
    }
}
