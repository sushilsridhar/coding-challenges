package arrays.numbers;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Given an integer array A containing N distinct integers, you have to find all the leaders in the array A.

    An element is leader if it is strictly greater than all the elements to its right side.

    NOTE:The rightmost element is always a leader.

    solution, traverse from the right to left, assume last element as max, if any element greater than max, that elements has all smaller elements towards
    its right side.
 */
public class LeadersInTheArray {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(16, 17, 4, 3, 5, 2));

        ArrayList<Integer> sol = solve(A);
        for(int i: sol) {
            System.out.print(i+" ");
        }

        System.out.println(" ");

        ArrayList<Integer> efficientSol = efficent(A);
        for(int i: efficientSol) {
            System.out.print(i+" ");
        }
    }

    // O(n)
    public static ArrayList<Integer> efficent(ArrayList<Integer> A) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A.get(A.size()-1));
        int max = A.get(A.size()-1);

        for(int i=A.size()-2; i>0; i--) {

            if(A.get(i) > max) {
                arr.add(A.get(i));
                max = A.get(i);
            }
        }

        return arr;
    }

    // O(n^2)
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<A.size()-1;i++) {
            boolean isleader = true;
            for(int j=i+1; j<A.size(); j++) {
                if(A.get(i) < A.get(j)) {
                    isleader = false;
                    break;
                }
            }
            if(isleader) {
                arr.add(A.get(i));
            }
        }

        arr.add(A.get(A.size()-1));

        return arr;
    }
}
