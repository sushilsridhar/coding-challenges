package linkedlist.adv;

/*
    Given a singly linked list A

    A: A0 → A1 → … → An-1 → An
    reorder it to:

    A0 → An → A1 → An-1 → A2 → An-2 → …
    You must do this in-place without altering the nodes' values

    1 --> 2 --> 3 --> 4 --> 5 --> null
    1 --> 5 --> 2 --> 4 --> 3 --> null

    split into two half, reverse the second half and merge the two half as requirement

    tc: O(n), n + n/2 + n
    sc: O(1)
 */
public class ReorderList {

    public static ListNode reorderList(ListNode A) {
        ListNode head = A;

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }

        ListNode secondListHead = pointer1.next;
        pointer1.next = null;

        ListNode reversedSecondListHead = reverse(secondListHead);

        return merge(head, reversedSecondListHead);
    }

    private static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode merge(ListNode head, ListNode reversedSecondListHead) {

        ListNode pointer1 = head;
        ListNode pointer2 = reversedSecondListHead;
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyPointer = dummyNode;

        while(pointer1 != null && pointer2 != null) {
            dummyPointer.next = pointer1;
            dummyPointer = dummyPointer.next;

            pointer1 = pointer1.next;

            dummyPointer.next = pointer2;
            dummyPointer = dummyPointer.next;

            pointer2 = pointer2.next;
        }

        if(pointer2 == null) {
            dummyPointer.next = pointer1;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode reorderedList = reorderList(head);
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

    private static ListNode createLinkedList() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);


        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

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
