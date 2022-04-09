package sorting;

/*
    Given an array of size n, return the inversion count of the array

    (i,j) such that, i<j && a[i] > a[j]

    4 5 1 2 6 3

    4 > 1 2 3
    5 > 1 2 3
    6 > 3

    ans = 7

    approach:

    merge sort
    arr1    arr2
    4, 5, | 1

    4 > 1 , so add 2 to inversion count ( 4>1 and 5>1 --> 2)

 */
public class InversionCount {

    public static void main(String[] args) {
                 //  0  1  2  3  4  5
        int[] a = {  4, 5, 1, 2, 6, 3};

        System.out.println(bruteForce(a));

        System.out.println(optimized(a));

    }

    // tc:
    private static int optimized(int[] a) {

        return mergeSort(a, 0, a.length-1);
    }

    private static int mergeSort(int[] a, int start, int end) {
        if(start == end) {
            return 0;
        }

        int inversionCount = 0;
        int mid = (start+end)/2;

        inversionCount = inversionCount + mergeSort(a, start, mid);
        inversionCount = inversionCount + mergeSort(a, mid+1, end);
        inversionCount = inversionCount + merge(a, start, mid, end);

        return inversionCount;
    }

    private static int merge(int[] a, int start, int mid, int end) {

        int sizeOfFirstArray = mid - start + 1;
        int sizeOfSecondArray = end - (mid+1) + 1;

        int[] firstArray = new int[sizeOfFirstArray];
        int[] secondArray = new int[sizeOfSecondArray];

        int index = 0;
        for(int i=start; i<=mid; i++) {
            firstArray[index] = a[i];
            index++;
        }

        index = 0;
        for(int i=mid+1; i<=end; i++) {
            secondArray[index] = a[i];
            index++;
        }

        int originalArrayIndex = start;
        int aIndex = 0;
        int bIndex = 0;
        int inversionCount = 0;

        while(aIndex < sizeOfFirstArray && bIndex < sizeOfSecondArray) {

            if(firstArray[aIndex] > secondArray[bIndex]) {
                a[originalArrayIndex] = secondArray[bIndex];
                bIndex++;

                // start index of subarray              -> aIndex
                // end index of subarray                --> sizeOfFirstArray -1
                // total number of element in subarray  --> sizeOfFirstArray -1 -aIndex + 1
                inversionCount = inversionCount + sizeOfFirstArray - aIndex;

            } else {
                a[originalArrayIndex] = firstArray[aIndex];
                aIndex++;
            }

            originalArrayIndex++;
        }

        while(aIndex < sizeOfFirstArray) {
            a[originalArrayIndex] = firstArray[aIndex];
            aIndex++;
            originalArrayIndex++;
        }

        while(bIndex < sizeOfSecondArray) {
            a[originalArrayIndex] = secondArray[bIndex];
            bIndex++;
            originalArrayIndex++;
        }

        return inversionCount;
    }

    // tc: O(n^2)
    private static int bruteForce(int[] a) {
        int count = 0;

        for(int i=0; i<a.length; i++) {
            for(int j=i+1; j<a.length; j++) {
                if(a[i] > a[j])  {
                    count++;
                }
            }
        }

        return count;
    }
}
