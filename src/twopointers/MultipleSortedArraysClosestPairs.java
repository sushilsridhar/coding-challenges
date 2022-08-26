package twopointers;

/*
    TODO
 */
public class MultipleSortedArraysClosestPairs {

    public int[] solve(int[] A, int[] B, int C) {

        int ans = Integer.MAX_VALUE;
        int[] r = new int[2];
        int target = C;

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                int sum = A[i] + B[j];
                int distanceBetweenSumAndTarget = Math.abs(sum - target);
                int distanceBetweenAnsAndTarget = Math.abs(ans - target);

                if(distanceBetweenSumAndTarget < distanceBetweenAnsAndTarget) {
                    ans = sum;
                    r[0] = A[i];
                    r[1] = B[j];

                    if(distanceBetweenSumAndTarget == 0) {
                        return r;
                    }
                }

            }
        }

        return r;
    }
}
