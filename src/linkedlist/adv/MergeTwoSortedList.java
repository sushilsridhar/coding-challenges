package linkedlist.adv;

/*
    Merge two sorted linked lists, A and B, and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists and should also be sorted.

    1 --> 4 --> 8 --> 19 --> 100 --> 102 --> null
    2 --> 5 --> 9 --> 98 --> 100 --> 103 --> null
    1 --> 2 --> 4 --> 5 --> 8 --> 9 --> 19 --> 98 --> 100 --> 100 --> 102 --> 103 --> null

    approach:
    take a dummy node, and start appending to end of it

    tc: O(n+m), worst case, we need to visit all nodes
 */
public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {

        ListNode headA = A;
        ListNode headB = B;

        ListNode pointer1 = headA;
        ListNode pointer2 = headB;

        ListNode newListHead = new ListNode(-1);
        ListNode newListpointer = newListHead;

        while(pointer1 != null && pointer2 != null) {

            if(pointer1.val < pointer2.val) {
                newListpointer.next = pointer1;
                newListpointer = newListpointer.next;
                pointer1 = pointer1.next;

            } else {
                newListpointer.next = pointer2;
                newListpointer = newListpointer.next;
                pointer2 = pointer2.next;
            }
        }

        if(pointer1 != null) {
            newListpointer.next = pointer1;
        }

        if(pointer2 != null) {
            newListpointer.next = pointer2;
        }

        return newListHead.next;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);
        ListNode head1 = createLinkedListTwo();
        printLinkedList(head1);


        ListNode mergedList = mergeTwoLists(head, head1);
        printLinkedList(mergedList);

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

    private static ListNode createLinkedList() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(19);
        ListNode n5 = new ListNode(100);
        ListNode n6 = new ListNode(102);



        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        return head;
    }

    private static ListNode createLinkedListTwo() {
        ListNode head = new ListNode(2);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(98);
        ListNode n5 = new ListNode(100);
        ListNode n6 = new ListNode(103);



        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        return head;
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
