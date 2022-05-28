package linkedlist.adv;

/*
    TODO code recursion solution
 */
public class ReverseKItemsInLinkedList {

    public static ListNode bruteForce(ListNode A, int B) {

        ListNode head = A;
        int k = B;

        ListNode linkerNode = head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        int c = 0;
        while(c<k) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

            c++;
        }

        head = prev;
        prev = null;
        c=0;

        while(curr != null || c == k) {

            if(c < k) {

                if(c == 0) {
                    linkerNode.next = curr;
                }

                next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
                c++;

            } else {
                ListNode linkerNodeNext = linkerNode.next;
                linkerNode.next = prev;
                prev = null;
                linkerNode = linkerNodeNext;
                c=0;
            }
        }

        return head;
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
