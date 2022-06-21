package linkedlist.adv;

/*
    Given a DLL and a node, add a new node before the given node

    1 --> 2 --> 3 --> 4 --> 5 --> null
    1 --> 2 --> 3 --> 10 --> 4 --> 5 --> null

    tc: O(1)
    sc: O(1)
 */
public class GivenDLLInsertNodeBefore {

    private static void insertNodeBefore(ListNode node, int val) {

        ListNode n1 = node.prev;
        ListNode newNode = new ListNode(val);

        if(n1 == null) {
            node.prev = newNode;
            newNode.next = node;

            // change head pointer to newNode

        } else {
            ListNode n2 = n1.next;
            newNode.next = n2;
            newNode.prev = n1;

            n1.next = newNode;

            if(n2 != null)
                n2.prev = newNode;
        }

    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode pointer = head;

        for(int i=0; i<3; i++) {
            pointer = pointer.next;
        }

        insertNodeBefore(pointer,10);
        printLinkedList(head);
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    private static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        ListNode(int x) {
            val = x;
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
        n2.prev = head;
        n3.next = n4;
        n3.prev = n2;
        n4.next = n5;
        n4.prev = n3;
        n5.prev = n4;

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
