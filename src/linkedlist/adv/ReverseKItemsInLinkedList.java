package linkedlist.adv;

/*
    Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.

    Constraints:
    1 <= |A| <= 103
    B always divides A

    iterative solution
    tc: O(n)

    recursive solution
    tc: O(n)
    sc: O(n/b), n/b recursive calls will be made, n/b stack space required
 */
public class ReverseKItemsInLinkedList {

    public static ListNode reverseListUsingRecursion(ListNode A, int B) {

        ListNode head = A;
        int k = B;

        return reverseItems(head, k);
    }

    private static ListNode reverseItems(ListNode head, int k) {

        if(head == null || k == 1) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        int c = 1;
        while(curr != null && c<=k) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

            c++;
        }

        head.next = reverseItems(curr, k);

        return prev;
    }

    public static ListNode reverseKItems(ListNode A, int B) {

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

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode reversedList = reverseKItems(head, 2);
        printLinkedList(reversedList);

        System.out.println("-----");

        ListNode head1 = createLinkedList();
        printLinkedList(head1);

        ListNode reversedList1 = reverseListUsingRecursion(head1, 2);
        printLinkedList(reversedList1);

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
