package linkedlist.adv;

/*
    Given a linked list A, swap every two adjacent nodes and return its head.

    NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.


    A = 1 -> 2 -> 3 -> 4

    output:
    2 -> 1 -> 4 -> 3

    1 --> 2 --> 3 --> 4 --> 5 --> null    - input
    2 --> 1 --> 4 --> 3 --> 5 --> null    - output

    tc: O(n)
    sc: O(1)
 */
public class SwapListNodesInPairs {

    private static ListNode swapPairs(ListNode A) {

        ListNode pointer1 = A;
        ListNode pointer2 = A.next;

        if(pointer1 != null && pointer2 != null) {

            ListNode next = pointer2.next;
            pointer2.next = pointer1;
            pointer1.next = next;

            ListNode newHead = pointer2;

            if(next == null) {
                return newHead;
            }

            ListNode prev = pointer1;
            ListNode p1 = pointer1.next;
            ListNode p2 = p1.next;

            while(p1 != null && p2 != null) {
                ListNode n = p2.next;
                p2.next = p1;
                p1.next = n;

                prev.next = p2;
                prev = p1;

                p1 = n;
                if(n != null) {
                    p2 = p1.next;
                }
            }

            return newHead;
        }

        return A;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode swapPairs = swapPairs(head);
        printLinkedList(swapPairs);

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
