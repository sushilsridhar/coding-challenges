package linkedlist.adv;

/*
    You are given two linked lists, A and B, representing two non-negative numbers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return it as a linked list

    2 --> 4 --> 3 --> null
    5 --> 4 --> 6 --> null
    7 --> 0 --> 8 --> null

    approach:

    normal addition, handle carry case properly, use the same linked list to save space

    tc: O(n1 + n2)
    sc: O(1)

 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {

        ListNode pointer = A;
        ListNode pointer1 = B;
        ListNode prevOfPointer = null;
        int carry = 0;

        while(pointer != null && pointer1 != null) {
            int a = pointer.val;
            int b = pointer1.val;

            int sum = a + b + carry;

            pointer.val = sum%10;
            carry = sum/10;

            prevOfPointer = pointer;
            pointer = pointer.next;
            pointer1 = pointer1.next;
        }

        while(pointer != null) {
            int a = pointer.val;
            int sum = a + carry;

            pointer.val = sum%10;
            carry = sum/10;

            prevOfPointer = pointer;
            pointer = pointer.next;
        }

        while(pointer1 != null) {
            int b = pointer1.val;
            int sum = b + carry;

            pointer1.val = sum%10;
            carry = sum/10;

            prevOfPointer.next = pointer1;
            prevOfPointer = prevOfPointer.next;

            pointer1 = pointer1.next;
        }

        if(carry != 0) {
            ListNode newNode = new ListNode(carry);
            prevOfPointer.next = newNode;
        }

        return A;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        ListNode head1 = createLinkedListTwo();
        printLinkedList(head);
        printLinkedList(head1);


        ListNode r = addTwoNumbers(head, head1);
        printLinkedList(r);

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
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        n2.next = n4;
        n4.next = n3;

        return n2;
    }

    private static ListNode createLinkedListTwo() {
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n4 = new ListNode(4);

        n5.next = n6;
        n6.next = n4;

        return n5;
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
