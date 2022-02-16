package hashing;

import java.util.Arrays;
import java.util.HashSet;

/*
    Given an array, find the length of the largest subsequence which can be rearranged to a sequence of consecutive numbers

    subsequence is same as subarray but it does not have to be contiguous, order should be maintained
    every subarray is subsequence, but subsequence may not be subarray

    -1, 8, 2, 3, 7, 1, 4, 9 --> ans = 4

    100, 101, 99, 98, 7, 6, 100, 102 --> ans = 5

    approach:
    Time complexity: nlogn, space complexity: O(1), depends on the sorting algorithm
    1. sort, -1, 1, 2, 3, 4, 7, 8, 9
    2. compare i and i+1 element, if difference is 1, they are consecutive, if they are same, skip processing,
       if they are different, break the maxLength calculation and start over from next element

     0  1  2  3  4  5  6  7
    -1, 8, 2, 3, 7, 1, 4, 9 --> ans = 4

     optimization: if(!set.contains(a[i]-1))

     i=2, a[i]-1 = 1 present in the set?
     if present, then skip processing a[i],
     2 3 4 is sequence for i=2
     above is sequence is already present for i=5, no need to process i=2
     1 2 3 4 is sequence for i=5

     0 1 2 3 4 5 6 7  8
     6 6 6 6 6 7 8 9 10 -> ans = 5
     iterate over the set(which has unique values) instead of the array, otherwise
     0 index -> 6 7 8 9 10
     1 index -> 6 7 8 9 10 ...

 */
public class LargestSubSequence {

    public static void main(String[] args) {

        int[] a = {-1, 8, 2, 3, 7, 1, 4, 9};

        int[] b = {100, 101, 99, 98, 7, 6, 100, 102};
        // sorted 6,7,98,99,100,100,101,102

        System.out.println(sortSolution(a));
        System.out.println(sortSolution(b));

        System.out.println(bruteForce(a));
        System.out.println(bruteForce(b));

        System.out.println(bruteForceOptimized(a)); // best solution
        System.out.println(bruteForceOptimized(b));

    }

    private static int sortSolution(int[] a) {

        Arrays.sort(a);
        int n = a.length;
        int l = 1;
        int maxLength = l; // 1 is the minimum subsequence length
        for(int i=0; i<n-1; i++) {
            if(a[i+1] - a[i] == 1) {
                l++;
                maxLength = Math.max(maxLength, l);
            } else if(a[i+1] != a[i]) { // condition to break the count, automatically skips duplicate elements
                l = 1;
            }
        }

        return maxLength;
    }

    // tc: O(n2), sc: O(n)
    private static int bruteForce(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++) {
            set.add(a[i]);
        }
        int max = 1;
        for(int i=0; i<a.length; i++) {
            int ele = a[i]+1;
            int l = 1;
            while(set.contains(ele))  {
                ele++;
                l++;
            }
            max = Math.max(max, l);

        }
        return max;
    }

    // tc: O(n), how ? refers notes sc: O(n)
    private static int bruteForceOptimized(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++) {
            set.add(a[i]);
        }
        int max = 1;
        for(int i=0; i<a.length; i++) {
            if(!set.contains(a[i]-1)) {
                int ele = a[i]+1;
                int l = 1;
                while(set.contains(ele))  {
                    ele++;
                    l++;
                }
                max = Math.max(max, l);
            }
        }
        return max;
    }
}
