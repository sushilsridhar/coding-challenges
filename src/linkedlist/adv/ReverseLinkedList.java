package linkedlist.adv;

/*
    You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
    NOTE: You have to do it in-place and in one-pass.

    A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL

    5 -> 4 -> 3 -> 2 -> 1 -> NULL

    save the prev and next, so that we can reassign current's pointer

    tc: O(n)
 */
public class ReverseLinkedList {

    // tc: O(n)
    private static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode reversedList = reverseList(head);
        printLinkedList(reversedList);

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
