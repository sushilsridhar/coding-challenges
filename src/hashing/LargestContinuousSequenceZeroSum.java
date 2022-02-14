package hashing;

import java.util.ArrayList;
import java.util.HashMap;

/*
    Given an array A of N integers.
    Find the largest continuous sequence in a array which sums to zero.
    Return an array denoting the longest continuous sequence with total sum of zero.
    NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

    A = [1,2,-2,4,-4]
    return [2,-2,4,-4], it is the longest sequence with total sum of zero.


    1) edge case when input array = [0, 1, 2 ,3, 4, 5] , when index 0 is the largest sequence with sum 0

    2) edge case input array = [1, 2, -3, 3], check for zero value in prefix array
    prefix array = [1, 3, 0, 3] , ans is 0to2 index values,

 */
public class LargestContinuousSequenceZeroSum {

    public static void main(String[] args) {

        int[] a = {1,2,-2,4,-4};

        int[] r = bruteForce(a);
        for(int ele: r) {
            System.out.print(ele+" ");
        }
        System.out.println();

        int[] r1 = optimized(a);
        for(int ele: r1) {
            System.out.print(ele+" ");
        }
    }

    // tc: O(n), sc: O(n)
    public static int[] optimized(int[] A) {
        ArrayList<Integer> r = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] pf = new int[A.length];
        int maxDistance = Integer.MIN_VALUE;
        int startIndex = -1, endIndex = -1;

        pf[0] = A[0];
        if(pf[0] == 0) { // edge case when [0, 1, 2 ,3, 4, 5]
            maxDistance = 0;
            startIndex = 0;
            endIndex = 0;
        }
        for(int i=1; i<A.length; i++) {
            pf[i] = pf[i-1] + A[i];

            if(pf[i] == 0) { // edge case handle prefix array contains 0
                int distance = i;
                if(distance > maxDistance) {
                    maxDistance = distance;
                    startIndex = 0;
                    endIndex = i;
                }
            }
        }

        for(int i=0; i<A.length; i++) {
            if(map.containsKey(pf[i])) {
                int previousOccurranceOfI = map.get(pf[i]);
                int distance = i-(previousOccurranceOfI+1);
                if(distance > maxDistance) {
                    maxDistance = distance;
                    startIndex = previousOccurranceOfI+1;
                    endIndex = i;
                }
            } else {
                map.put(pf[i], i);
            }
        }

        if(startIndex != -1 && endIndex != -1) {
            for(int i=startIndex; i<=endIndex; i++) {
                r.add(A[i]);
            }
        }

        return r.stream().mapToInt(ele->ele).toArray();
    }

    // tc: O(n2), sc: O(n)
    public static int[] bruteForce(int[] A) {
        ArrayList<Integer> r = new ArrayList<>();
        int maxDistance = Integer.MIN_VALUE;
        int startIndex = -1, endIndex = -1;

        for(int i=0; i<A.length; i++) {
            int sum = 0;
            for(int j=i; j<A.length; j++) {
                sum = sum + A[j];

                if(sum == 0) {
                    int distance = j-i;
                    if(distance > maxDistance) {
                        maxDistance = distance;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }

        if(startIndex != -1 && endIndex != -1) {
            for(int i=startIndex; i<=endIndex; i++) {
                r.add(A[i]);
            }
        }

        return r.stream().mapToInt(ele->ele).toArray();
    }
}
