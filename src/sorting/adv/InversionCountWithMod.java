package sorting.adv;

/*
    Given an array of integers A. If i < j and A[i] > A[j],
    then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

    TODO
 */
public class InversionCountWithMod {

    public int solve(int[] A) {

        return mergeSort(A, 0, A.length-1);
    }

    private int mergeSort(int[] a, int start, int end) {

        if(start == end) {
            return 0;
        }

        int inversionCount = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        int mid = (start+end)/2;

        inversionCount = ((inversionCount%mod) + (mergeSort(a, start, mid)%mod))%mod;
        inversionCount = ((inversionCount%mod) + (mergeSort(a, mid+1, end)%mod))%mod;

        inversionCount = ((inversionCount%mod) + (merge(a, start, mid, end)%mod))%mod;

        //inversionCount = inversionCount + mergeSort(a, start, mid);
        //inversionCount = inversionCount + mergeSort(a, mid+1, end);

        //inversionCount = inversionCount+ merge(a, start, mid, end);

        return inversionCount;
    }

    private int merge(int[] a, int start, int mid, int end) {


        int aLen = mid - start + 1;
        int bLen = end - (mid+1) + 1;

        int[] firstArr = new int[aLen];
        int[] secondArr = new int[bLen];

        int index = 0;
        for(int i=start; i<=mid; i++) {
            firstArr[index] = a[i];
            index++;
        }

        index = 0;
        for(int i=mid+1; i<=end; i++) {
            secondArr[index] = a[i];
            index++;
        }

        int aPointer = 0;
        int bPointer = 0;
        int originalIndex = start;
        int inversionCount = 0;
        int mod = (int) Math.pow(10, 9) +  7;

        while(aPointer < aLen && bPointer < bLen) {

            if(firstArr[aPointer] > secondArr[bPointer]) {
                a[originalIndex] = secondArr[bPointer];
                bPointer++;
                inversionCount = ((inversionCount%mod) + ((aLen - aPointer)%mod))%mod;

                //inversionCount = inversionCount + aLen - aPointer;
            } else {
                a[originalIndex] = firstArr[aPointer];
                aPointer++;
            }

            originalIndex++;
        }

        while(aPointer < aLen) {
            a[originalIndex] = firstArr[aPointer];
            aPointer++;
            originalIndex++;
        }

        while(bPointer < bLen) {
            a[originalIndex] = secondArr[bPointer];
            bPointer++;
            originalIndex++;
        }

        return inversionCount;
    }
}
