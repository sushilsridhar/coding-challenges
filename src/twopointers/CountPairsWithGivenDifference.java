package twopointers;

import java.util.HashMap;

/*

 */
public class CountPairsWithGivenDifference {

    public static void main(String[] args) {

        int[] a = {8, 12, 16, 4, 0, 20};
        int b = 4;

        System.out.println(bruteForce(a, b));
    }

    private static int bruteForce(int[] A, int B) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                if(Math.abs(A[i]-A[j]) == B) {
                    set.put(Math.min(A[i], A[j]), Math.max(A[i],A[j]));
                }
            }
        }
        return set.size();
    }
}
