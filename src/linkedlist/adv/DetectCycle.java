package linkedlist.adv;

/*
    approach: Floyd Cycle Finding Algorithm

    Given a ll, detect whether cycle exists

    1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9
                                              4 <--

    using hashset,
    store the address of ListNodes in HashSet, if there exists duplicate, cycle exists

    using slow fast pointer,
    if there is a cycle, these two pointers will meet some where

    time complexity:
    If there is a cycle, the fast pointer needs M times to catch up the slower pointer, where M is the length of the cycle in the list.
    Obviously, M <= N. So we will run the loop up to N times.
    So, the time complexity of this algorithm is O(N) in total.

    tc: O(n)
    sc: O(1)
 */
public class DetectCycle {

    private static boolean fastSlowPointer(ListNode head) {

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

            if(pointer1 == pointer2) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();

        System.out.println(fastSlowPointer(head));
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
