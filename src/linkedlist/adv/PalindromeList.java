package linkedlist.adv;

/*
    Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.

    1 --> 2 --> 3 --> 4 --> 3 --> 2 --> 1 --> null
    odd length, middle will be 4

    1 --> 2 --> 3 --> 3 --> 2 --> 1 --> null
    even length, middle will be first 3

    approach:
    find middle using slow faster pointer, reverse the second half and compare with first half,

    tc: O(n)
    sc: O(1)
 */
public class PalindromeList {

    public static int palindrome(ListNode A) {
        ListNode head = A;

        ListNode mid = getMiddle(head);
        ListNode firstHalf = head;
        ListNode secondHalf = mid.next;
        mid.next = null;

        ListNode reversedSecondHalf = reverseSecondHalf(secondHalf);

        while(firstHalf != null && reversedSecondHalf != null) {
            if(firstHalf.val != reversedSecondHalf.val) {
                return 0;
            }
            firstHalf = firstHalf.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return 1;
    }

    private static ListNode reverseSecondHalf(ListNode secondHalf) {

        ListNode prev = null;
        ListNode curr = secondHalf;
        ListNode next = secondHalf;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode getMiddle(ListNode head) {

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

        System.out.println(palindrome(head));

        System.out.println("----");

        ListNode head1 = createLinkedListTwo();
        printLinkedList(head1);

        System.out.println(palindrome(head1));


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
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1);


        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        return head;
    }

    private static ListNode createLinkedListTwo() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1);


        head.next = n2;
        n2.next = n3;
        n3.next = n5;
        n5.next = n6;
        n6.next = n7;

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
