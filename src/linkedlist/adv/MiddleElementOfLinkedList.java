package linkedlist.adv;

/*
    Given a linked list of integers, find and return the middle element of the linked list.
    NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

    1 -> 2 -> 3 -> 4 -> 5,
    middle is 3

    1 -> 2 -> 3 -> 4 -> 5 -> 6,
    middle is 4, even length list has two centers 3 and 4, return the second center

    approach: slow and fast pointer
    every iteration
    1. increment pointer1 once
    2. increment pointer2 twice,

    by the time pointer2 reaches end of the list, pointer1 will be in the middle
    tc: O(n/2)
 */
public class MiddleElementOfLinkedList {

    // tc: O(n/2)
    public static int twoPointers(ListNode A) {

        ListNode head = A;
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }

        if(pointer2.next == null) { // length is odd
            return pointer1.val;
        }

        return pointer1.next.val; // length is even
    }

    // tc: O(n + n/2)
    public static int bruteForce(ListNode A) {

        ListNode head = A;
        ListNode pointer = head;

        int size = 0;

        while(pointer != null) {
            pointer = pointer.next;
            size++;
        }

        int k = size/2 + 1;
        int count = 1;
        int data = 0;
        ListNode pointer2 = head;


        while(count <= k) {
            data = pointer2.val;
            pointer2 = pointer2.next;
            count++;
        }

        return data;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        int ans = twoPointers(head);
        System.out.println(ans);

        ListNode head2 = createLinkedListOdd();
        printLinkedList(head2);

        int ans2 = twoPointers(head2);
        System.out.println(ans2);
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

    private static ListNode createLinkedListOdd() {
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
