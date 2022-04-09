package sorting;

/*
    Merge Sort
    1. split the array into half, make recursive calls on the two half of the array separately
    2. split until there is only one element left in the array
    3. once the recursive calls returns, merge the elements of two arrays
    4. repeat

    tc: O(1 * nlogn + n * logn) --> O(nlogn)
    sc: O(n)
 */
public class MergeSort {

    public static void main(String[] args) {
        //          0  1  2  3   4  5  6
        int[] a = { 5, 8, 1, 3, 15, 9, 2};

        // 1, 2, 3, 5, 8, 9, 15

        int[] r = mergeSortTryOut(a);

        for(int i: r) {
            System.out.print(i+" ");
        }

        System.out.println(" ");

        //          0  1  2  3   4  5  6
        int[] b = { 5, 8, 1, 3, 15, 9, 2};

        mergeSort(b, 0, b.length-1); // --> most optimized and clean code

        for(int i: b) {
            System.out.print(i+" ");
        }
    }

    // clean code of merge sort
    private static void mergeSort(int[] b, int start, int end) {

        if(start == end) {
            return;
        }

        int mid = (start+end)/2;

        mergeSort(b, start, mid);
        mergeSort(b, mid+1, end);
        merge(b, start, mid, end);
    }

    private static void merge(int[] b, int start, int mid, int end) {

        int sizeOfFirstArray = mid - start + 1;
        int sizeOfSecondArray = end - (mid+1) + 1;

        int[] firstArray = new int[sizeOfFirstArray];
        int[] secondArray = new int[sizeOfSecondArray];

        int index = 0;
        for(int i=start; i<=mid; i++) {
            firstArray[index] = b[i];
            index++;
        }

        index = 0;
        for(int i=mid+1; i<=end; i++) {
            secondArray[index] = b[i];
            index++;
        }

        int originalArrayIndex = start;
        int aIndex = 0;
        int bIndex = 0;

        while(aIndex < sizeOfFirstArray && bIndex < sizeOfSecondArray) {

            if(firstArray[aIndex] <= secondArray[bIndex]) {
                b[originalArrayIndex] = firstArray[aIndex];
                aIndex++;
            } else {
                b[originalArrayIndex] = secondArray[bIndex];
                bIndex++;
            }

            originalArrayIndex++;
        }

        while(aIndex < sizeOfFirstArray) {
            b[originalArrayIndex] = firstArray[aIndex];
            aIndex++;
            originalArrayIndex++;
        }

        while(bIndex < sizeOfSecondArray) {
            b[originalArrayIndex] = secondArray[bIndex];
            bIndex++;
            originalArrayIndex++;
        }

    }

    private static int[] mergeSortTryOut(int[] a) {

        int n = a.length;

        if(n == 1) {
            return a;
        }
        int sizeOfFirstArray = n/2;
        int sizeOfSecondArray = n - n/2;

        int[] firstArray = new int[sizeOfFirstArray];
        int[] secondArray = new int[sizeOfSecondArray];
        int originalArrayIndex = 0;

        for(int i=0; i<sizeOfFirstArray; i++) {
            firstArray[i] = a[originalArrayIndex];
            originalArrayIndex++;
        }

        for(int i=0; i<sizeOfSecondArray; i++) {
            secondArray[i] = a[originalArrayIndex];
            originalArrayIndex++;
        }

        int[] A = mergeSortTryOut(firstArray); //0 -n/2
        int[] B = mergeSortTryOut(secondArray); //n/2 - n

        int aLen = A.length;
        int bLen = B.length;

        int[] r = new int[aLen+bLen];
        int aIndex = 0;
        int bIndex = 0;
        int rIndex = 0;

        while(aIndex < aLen && bIndex < bLen) {

            if(A[aIndex] <= B[bIndex]) {
                r[rIndex] = A[aIndex];
                aIndex++;
            } else {
                r[rIndex] = B[bIndex];
                bIndex++;
            }

            rIndex++;
        }

        while(aIndex < aLen) {
            r[rIndex] = A[aIndex];
            aIndex++;
            rIndex++;
        }

        while(bIndex < bLen) {
            r[rIndex] = B[bIndex];
            bIndex++;
            rIndex++;
        }

        return r;
    }
}
