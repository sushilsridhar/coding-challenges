package linkedlist.adv;

import java.util.ArrayList;

/*
    Given a list containing head pointers of N sorted linked lists.
    Merge these given sorted linked lists and return them as one sorted list

    1 -> 10 -> 20
    4 -> 11 -> 13
    3 -> 8 -> 9

    1 --> 3 --> 4 --> 8 --> 9 --> 10 --> 11 --> 13 --> 20 --> null

    tc: O(nlogn), 2T(n/2) + n
    sc: O(k), size of arraylist
    TODO sc: O(logn), that is, length of the recursion binary tree, check this
 */
public class MergeKSortedLists {

    public static ListNode mergeKLists(ArrayList<ListNode> a) {

        int size = a.size();
        int startIndex = 0;
        int endIndex = size-1;

        return divideAndMerge(a, startIndex, endIndex);
    }

    private static ListNode divideAndMerge(ArrayList<ListNode> a, int startIndex, int endIndex) {

        if(startIndex == endIndex) {
            return a.get(startIndex);
        }

        int mid = (startIndex + endIndex)/2;

        int s1 = startIndex;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = endIndex;

        ListNode head1 = divideAndMerge(a, s1, e1);
        ListNode head2 = divideAndMerge(a, s2, e2);

        return merge(head1, head2);
    }

    private static ListNode merge(ListNode head1, ListNode head2) {

        ListNode pointer1 = head1;
        ListNode pointer2 = head2;
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyPointer = dummyNode;

        while(pointer1 != null && pointer2 != null) {

            if(pointer1.val < pointer2.val) {
                dummyPointer.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                dummyPointer.next = pointer2;
                pointer2 = pointer2.next;
            }
            dummyPointer = dummyPointer.next;
        }

        if(pointer1 != null) {
            dummyPointer.next = pointer1;
        }

        if(pointer2 != null) {
            dummyPointer.next = pointer2;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ArrayList<ListNode> arrayList = createLinkedList();

        ListNode reorderedList = mergeKLists(arrayList);
        printLinkedList(reorderedList);
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ArrayList<ListNode> createLinkedList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(10);
        ListNode n3 = new ListNode(20);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(11);
        ListNode n6 = new ListNode(13);
        n4.next = n5;
        n5.next = n6;

        ListNode n7 = new ListNode(3);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        n7.next = n8;
        n8.next = n9;

        ArrayList<ListNode> arrayList = new ArrayList<>();
        arrayList.add(n1);
        arrayList.add(n4);
        arrayList.add(n7);


        return arrayList;
    }

    private static void printLinkedList(ListNode head) {
        ListNode pointer = head;

        while(pointer != null) {
            System.out.print(pointer.val+" --> ");
            pointer = pointer.next;
        }
        System.out.print("null");
        System.out.println("");
    }
}
