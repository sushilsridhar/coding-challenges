package linkedlist.adv;

/*
    Given a linked list A, remove the B-th node from the end of the list and return its head.
    For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.

    NOTE: If B is greater than the size of the list, remove the first node of the list.
    NOTE: Try doing it using constant additional space.

    approach
    0    1    2    3
    1 -> 2 -> 3 -> 4 -> 5 -> null , B = 2

    size = 5, 5-2 = 3, delete 3th node from start

 */
public class RemoveNthNodeFromTheList {

    // tc: O(n + k)
    public static ListNode solution(ListNode A, int B) {

        if(B == 0) {
            return A;
        }

        ListNode head = A;
        ListNode pointer = head;

        int size = 0;

        while(pointer != null) {
            pointer = pointer.next;
            size++;
        }

        int k = size - B;

        if(k <= 0) {
            head = head.next;
            return head;
        }

        int c = 0;
        ListNode pointer2 = head;
        ListNode prev = null;

        while(c<k) {
            prev = pointer2;
            pointer2 = pointer2.next;
            c++;
        }

        prev.next = pointer2.next;

        return head;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode ans = solution(head, 2);
        printLinkedList(ans);

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
