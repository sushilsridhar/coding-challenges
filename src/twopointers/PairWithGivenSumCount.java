package twopointers;

import java.util.HashMap;

/*
    Given a sorted array of distinct integers A and an integer B,
    find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

    Input 1:
    A = [1, 2, 3, 4, 5]
    B = 5
    Output 1:
    2

    tc: O(n)
    sc: O(1)
 */
public class PairWithGivenSumCount {

    public static void main(String[] args) {
        //          0   1   2    3    4
        int a[] = { 5, 10, 20, 100, 105}; // ans -> 2
        int k = 110;

        System.out.println(twoPointers(a, k));
        System.out.println(usingMap(a, k));

    }

    private static int twoPointers(int[] A, int B) {

        int i = 0;
        int j = A.length-1;
        int count = 0;

        while(i<j) {
            int sum = A[i] + A[j];

            if(sum == B) {
                count++;
                i++;
                j--;
            } else if(sum > B) {
                j--;
            } else if(sum < B) {
                i++;
            }
        }

        return count;
    }

    private static int usingMap(int[] A, int B) {

        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i])+1);
            } else {
                map.put(A[i], 1);
            }
        }

        for(int i=0; i<A.length; i++) {
            int x = B - A[i];
            if(map.containsKey(x)) {
                count = count + map.get(x);
            }
        }

        return count/2; // pairs get counted twice, so divide by 2
    }
}
