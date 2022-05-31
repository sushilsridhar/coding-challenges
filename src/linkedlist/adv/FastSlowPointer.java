package linkedlist.adv;

/*
    Given a ll, find the middle of the linkedlist

    1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
    3 or 4

    1 --> 2 --> 3 --> 4 --> 5 --> null
    3

    for even length, the middle can be either 3 or 4
    for odd length, the middle is 3

    tc: O(n/2)
 */
public class FastSlowPointer {

    private static ListNode fastSlowPointer(ListNode head) {

        if(head == null) {
            return head;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }

        return pointer1;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode middleEle = fastSlowPointer(head);
        System.out.println(middleEle.val);
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
        ListNode n6 = new ListNode(6);



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
