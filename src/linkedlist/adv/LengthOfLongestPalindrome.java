package linkedlist.adv;

/*
    Given a linked list, find the length of the longest odd length palindromic sublist

    solution for combined odd and even length

    odd
    1 --> 2 --> 3 --> 4 --> 5 --> 4 --> 3 --> 1 --> 2 --> 1 --> null
    ans = 5

    even
    4 --> 5 --> 3 --> 3 --> 5 --> 4 --> 7 --> 8 --> 8 --> 3 --> null
    ans = 6

    approach:

    keep reversing element one by one, for each element, check the condition for palindrome

    tc: O(n^2)
    sc: O(1)
 */
public class LengthOfLongestPalindrome {

    private static int getLongestPalindromeLength(ListNode head) {
        int ans = 0;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;

            int evenR = findEvenPalindrome(curr, next);
            int oddR = findOddPalindrome(curr.next, next);

            int r = Math.max(evenR, oddR);
            ans = Math.max(ans, r);

            prev = curr;
            curr = next;
        }

        return ans;
    }

    private static int findEvenPalindrome(ListNode x, ListNode y) {
        int count = 0;
        while (x != null && y != null && x.val == y.val) {
            x = x.next;
            y = y.next;
            count++;
        }
        return count + count;
    }

    private static int findOddPalindrome(ListNode x, ListNode y) {
        int count = 0;
        while(x != null && y != null && x.val == y.val) {
            x = x.next;
            y = y.next;
            count++;
        }
        return count+count + 1;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        int r = getLongestPalindromeLength(head);
        System.out.println(r);

        ListNode head1 = createLinkedListTwo();
        printLinkedList(head1);

        int r1 = getLongestPalindromeLength(head1);
        System.out.println(r1);
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

    private static ListNode createLinkedListTwo() {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(8);
        ListNode n10 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        return n1;
    }

    private static ListNode createLinkedList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(3);
        ListNode n8 = new ListNode(1);
        ListNode n9 = new ListNode(2);
        ListNode n10 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        return n1;
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
