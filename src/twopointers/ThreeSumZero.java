package twopointers;

import java.util.ArrayList;
import java.util.Collections;

/*
    Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
    Find all unique triplets in the array which gives the sum of zero.

    Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.

    A = [-1,0,1,2,-1,4]

    output,
    [ [-1,0,1],
    [-1,-1,2] ]

    bruteforce,
    sort the array, so that we can avoid duplicate by skipping it using while loop,
    have three loops with i=0, j=i+1, k=j+1, so that duplicate triplets are avoided and a<=b<=c condition is also maintained
    while to skip duplicate elements in the array

    tc: O(nlogn + n^3)
    sc: O(1)

    two pointers,

    TODO

 */
public class ThreeSumZero {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(-31013930);
        A.add(-31013930);
        A.add(9784175);
        A.add(21229755);

        ArrayList<Integer> a = new ArrayList<>();
        a.add(-1);
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(-1);
        a.add(4);

        ArrayList<ArrayList<Integer>> ansList = bruteForce(a);

        for(ArrayList<Integer> i: ansList) {
            for(int j: i) {
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");

        ArrayList<ArrayList<Integer>> ansList1 = twoPointers(a);

        for(ArrayList<Integer> i: ansList1) {
            for(int j: i) {
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }
    }

    private static ArrayList<ArrayList<Integer>> twoPointers(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();

        Collections.sort(A);
        int n = A.size();

        for(int k=0; k<n; k++) {
            int i = k+1;
            int j = n-1;

            while(i<j) {
                int sum = A.get(k) + A.get(i) + A.get(j);
                if(sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(A.get(k));
                    list.add(A.get(i));
                    list.add(A.get(j));
                    ansList.add(list);

                    while(i+1<n && A.get(i).equals(A.get(i+1))) {
                        i++;
                    }

                    while(j-1>i && A.get(j).equals(A.get(j-1))) {
                        j--;
                    }

                    i++;
                    j--;
                } else if(sum > 0) {
                    j--;
                } else {
                    i++;
                }
            }

            while(k+1<n && A.get(k).equals(A.get(k+1))) {
                k++;
            }
        }

        return ansList;
    }

    private static ArrayList<ArrayList<Integer>> bruteForce(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();

        Collections.sort(A);

        for(int i=0; i<A.size(); i++) {
            for(int j=i+1; j<A.size(); j++) {
                for(int k=j+1; k<A.size(); k++) {

                    if(A.get(i) + A.get(j) + A.get(k) == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(A.get(i));
                        list.add(A.get(j));
                        list.add(A.get(k));
                        ansList.add(list);
                    }

                    while(k+1<A.size() && A.get(k).equals(A.get(k+1))) {
                        k++;
                    }
                }
                while(j+1<A.size() && A.get(j).equals(A.get(j+1))) {
                    j++;
                }
            }
            while(i+1<A.size() && A.get(i).equals(A.get(i+1))) {
                i++;
            }
        }

        return ansList;
    }
}
