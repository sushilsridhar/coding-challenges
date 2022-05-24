package linkedlist.adv;

/*
    Given a sorted linked list, delete all duplicates such that each element appears only once.

    1 --> 1 --> 3 --> 4 --> 4 --> 5 --> null

    1 --> 3 --> 4 --> 5 --> null

    1 --> 1 --> 1 --> 1 --> null , is also handled

    only if two elements does not match, move to the next element

    tc: O(n)
 */
public class RemoveDuplicatesFromSortedList {

    // tc: O(n)
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode head = A;
        ListNode pointer = head;

        while(pointer != null && pointer.next != null) {

            if(pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode ans = deleteDuplicates(head);
        printLinkedList(ans);

    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    private static ListNode createLinkedList() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);



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
