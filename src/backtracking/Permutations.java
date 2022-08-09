package backtracking;

import java.util.ArrayList;
import java.util.HashSet;

/*
    Given an integer array A of size N denoting collection of numbers , return all possible permutations.

    NOTE:

    No two entries in the permutation sequence should be the same.
    For the purpose of this problem, assume that all the numbers in the collection are unique.
    Return the answer in any order

    input:
    [1, 2, 3]

    output:
    1 2 3
    1 3 2
    2 1 3
    2 3 1
    3 1 2
    3 2 1

    approach:
    fix one element and try out various combination,

    fix 1, second element can be 2 or 3,
    fix 1, second as 2, for third element, we have only one choice 3, 1 2 3, reached base case

    tc: O(n^2 * n!)

    total number of function calls for one permutation is n, there are n! permutation, so n * n!,
    inside each function call, we do n operations, so n^2 * n! is time complexity

    sc: O(n), height of tree is h, here h is n, size of hashset and arraylist is also n
 */
public class Permutations {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        ArrayList<ArrayList<Integer>> ans = permute(A);

        for(ArrayList<Integer> i: ans) {
            for(int j: i) {
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        HashSet<Integer> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> container = new ArrayList<>();

        backtracking(ansList, set, A, container);
        return ansList;
    }

    private static void backtracking(ArrayList<ArrayList<Integer>> ansList, HashSet<Integer> set, ArrayList<Integer> list, ArrayList<Integer> container) {

        if(container.size() == list.size()) {
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i: container) {
                ans.add(i);
            }
            ansList.add(ans);
            return;
        }

        for(int i=0; i<list.size(); i++) {
            int currEle = list.get(i);

            if(!set.contains(currEle)) {
                set.add(currEle);
                container.add(currEle);

                backtracking(ansList, set, list, container);

                container.remove(container.size()-1);
                set.remove(currEle);
            }
        }

    }
}
