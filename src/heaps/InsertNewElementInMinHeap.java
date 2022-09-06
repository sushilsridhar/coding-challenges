package heaps;

import java.util.ArrayList;

/*
    Insert new element into min heap

    0  1  2    3   4    5    6    7    8   9
    1, 8 ,7, 102, 50, 100, 105, 104, 220, 65

    logical representation
                          1
               8                     7
        102           50         100      105
     104   220     65

    approach:
    add 10 to min heap,

    add new ele to the last index, compare it with it's parent,
    if ele is less than parent, swap parent and ele

    1 8 7 102 10 100 105 104 220 65 50

    tc: O(h), worst case, the added element can move up to the root
    height of the complete binary tree is O(logn)

    tc: O(logn)
    sc: O(1)
 */
public class InsertNewElementInMinHeap {

    private static ArrayList<Integer> addToMinHeap(ArrayList<Integer> heap, int ele) {

        heap.add(ele);
        int indexOfEle = heap.size()-1;
        int indexOfParentEle = (indexOfEle-1)/2;

        while(heap.get(indexOfEle) < heap.get(indexOfParentEle) && indexOfEle > 0) {
            int parentEle = heap.get(indexOfParentEle);
            int currEle = heap.get(indexOfEle);

            heap.set(indexOfParentEle, currEle);
            heap.set(indexOfEle, parentEle);

            indexOfEle = indexOfParentEle;
            indexOfParentEle = (indexOfEle-1)/2;
        }

        return heap;
    }

    public static void main(String[] args) {

        int[] a = {1, 8 ,7, 102, 50, 100, 105, 104, 220, 65};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: a) {
            list.add(i);
        }

        ArrayList<Integer> r = addToMinHeap(list, 10);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }
}
