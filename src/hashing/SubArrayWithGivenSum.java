package hashing;

import java.util.ArrayList;

/*
    Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    If the answer does not exist return an array with a single element "-1".
    First sub-array means the sub-array for which starting index in minimum.

                0  1  2  3  4
     int[] A = {1, 2, 3, 4, 5};
     ans -> [2, 3] adds to 5


 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;

        int[] r = bruteForce(A, B);
        for(int ele: r) {
            System.out.print(ele+" ");
        }
    }

    public static int[] bruteForce(int[] A, int B) {
        ArrayList<Integer> r = new ArrayList<>();

        for(int i=0; i<A.length; i++) {
            int sum = 0;
            for(int j=i; j<A.length; j++) {
                sum = sum + A[j];
                if(sum == B) {
                    for(int k=i; k<=j; k++) {
                        r.add(A[k]);
                    }
                    return r.stream().mapToInt(ele->ele).toArray();
                } else if(sum > B) {
                    break;
                }
            }
        }

        return new int[]{-1};
    }
}
