package linkedlist.adv;

/*
    You are given a linked list that contains a loop.
    You need to find the node, which creates a loop and break it by making the node point to NULL.

    1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7
                        <-- 9 <-- 8 <--

    1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9 --> null

    approach:

    Floyd Cycle Finding Algorithm, to find if there is a loop

    if there is a loop, the distance between the point where slow and fast pointer meet and the start of the loop is same as
    the distance between the head of ll and start of the loop,

    refer Floyd-cycle-detection.png

    tc: O(n)
    sc: O(1)
 */
public class RemoveLoopFromLinkedList {

    public static ListNode removeLoop(ListNode A) {

        ListNode head = A;

        ListNode p1 = head;
        ListNode p2 = null;
        ListNode prevOfP2 = null;

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

            if(pointer1 == pointer2) {
                p2 = pointer1;
                break;
            }
        }

        if(p2 != null) {

            while(p1 != null && p2 != null) {

                if(p1 == p2) {
                    break;
                }

                prevOfP2 = p2;
                p1 = p1.next;
                p2 = p2.next;
            }

            prevOfP2.next = null;
        }


        return head;

    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        //printLinkedList(head);

        ListNode withoutLoop = removeLoop(head);
        printLinkedList(withoutLoop);
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
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);



        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n4;

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
