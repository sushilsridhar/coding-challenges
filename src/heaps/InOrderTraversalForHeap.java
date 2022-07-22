package heaps;

/*
    Print inorder traversal of heap

    0  1  2  3   4  5   6   7   8
    7, 5, 4, 1, 10, 8, 80, 11, 12

    logical representation
                     7
             5               4
        1       10       8      80
     11   12

    inorder: 11 1 12 5 10 7 8 4 80

 */
public class InOrderTraversalForHeap {

    private static void inOrderTraversal(int[] heap, int i) {

        if(i >= heap.length) {
            return;
        }

        inOrderTraversal(heap, i*2+1);
        System.out.print(heap[i]+" ");
        inOrderTraversal(heap, i*2+2);
    }

    public static void main(String[] args) {

        int[] a = {7, 5, 4, 1, 10, 8, 80, 11, 12};

        inOrderTraversal(a, 0);
    }
}
