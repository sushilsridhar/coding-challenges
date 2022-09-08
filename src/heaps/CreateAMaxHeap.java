package heaps;

/*
    TODO
 */
public class CreateAMaxHeap {

    private static void createHeap(int[] a) {
        int indexOfLastEle = a.length-1;
        int indexOfParentOfLastEle = (indexOfLastEle - 1)/2;

        for(int i=indexOfParentOfLastEle; i>=0; i--) {
            heapify(i, a);
        }
    }

    private static void heapify(int i, int[] a) {
        int n = a.length;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        int currPointer = i;

        while(currPointer < n-1) {
            if(leftIndex < n && rightIndex < n) {
                if(a[currPointer] > a[leftIndex] && a[currPointer] > a[rightIndex])
                    break;

                if(a[leftIndex] > a[rightIndex]) {
                    if(a[leftIndex] > a[currPointer]) {
                        swap(currPointer, leftIndex, a);
                        currPointer = leftIndex;
                    }
                } else if(a[rightIndex] > a[leftIndex]) {
                    if(a[rightIndex] > a[currPointer]) {
                        swap(currPointer, rightIndex, a);
                    }
                }
            } else if(leftIndex < n) {
                if(a[leftIndex] > a[currPointer]) {
                    swap(currPointer, leftIndex, a);
                } else
                    break;
            } else if(rightIndex < n) {

            }


        }
    }

    private static void swap(int p, int c, int[] a) {
        int temp = a[p];
        a[p] = a[c];
        a[c] = temp;
    }

    public static void main(String[] args) {

        int[] a = {15, 8, 70, 80, 10, 5};

        createHeap(a);

        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
