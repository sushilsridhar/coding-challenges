package heaps;

/*
    check if heap is min heap

     0   1   2   3   4   5
    10, 18, 20, 80, 90, 20

    logical representation
                     10
             18               20
        80       90       20

    approach:
    iterate from start to parent of last element present,
    check if root is smaller than it's left and right child

    tc: O(n)
    sc: O(1)
 */
public class CheckIfItIsMinHeap {

    private static boolean checkIfMinHeap(int[] heap) {

        int last = heap.length-1;
        int parentOfLast = (last-1)/2;

        for(int i=0; i<=parentOfLast; i++) {
            int lIndex = i * 2 + 1;
            int rIndex = i * 2 + 2;
            int root = heap[i];

            int l = heap[lIndex];

            if(rIndex <= heap.length-1) {
                int r = heap[rIndex];
                if (root > l || root > r)
                    return false;
            } else {
                if (root > l)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] a = {10, 18, 20, 80, 90, 20};

        System.out.println(checkIfMinHeap(a));
    }
}
