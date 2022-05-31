package linkedlist.adv;

/*
    TODO

    TODO tail recursion, macher algo

 */
public class IterativeSortOnLinkedList {







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
        ListNode head = new ListNode(100);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(102);
        ListNode n4 = new ListNode(19);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(4);

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(7);
        ListNode n10 = new ListNode(100);
        ListNode n11 = new ListNode(98);
        ListNode n12 = new ListNode(5);


        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;

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
