package maths.primenumbers;

import java.util.HashSet;

/*
    TODO
 */
public class DistinctPrimes {
    public static void main(String[] args) {

        /*int[] r1 = seiveOfEratosthenes(A);

        for(int i: r1) {
            System.out.print(i+" ");
        }*/

        int[] A = { 96, 98, 5, 41, 80 };
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {


        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++) {
            max = Math.max(max, A[i]);
        }

        int n = max;
        boolean[] fabric = new boolean[n+1];
        fabric[1] = false;

        for(int i=2; i<=n; i++) {
            fabric[i] = true;
        }

        for(int i=2; i<=n; i++) {
            if(fabric[i]) {
                for(int j=i*2; j<=n; j=j+i) {
                    fabric[j] = false;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++) {
            int ele = A[i];
            for(int j=2; j<=n; j++) {
                if(fabric[i] && (ele%i == 0)) {
                    set.add(i);
                }
            }
        }

        return set.size();
    }
}
