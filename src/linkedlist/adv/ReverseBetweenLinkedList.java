package linkedlist.adv;

/*
    Reverse a linked list A from position B to C.
    NOTE: Do it in-place and in one-pass.

    B = 2, C = 5,
    1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> null
    1 --> 5 --> 4 --> 3 --> 2 --> 6 --> 7 --> null

    iterate from start to end, note down the node before B(first pointer) and node after C(last pointer),
    reverse from B to C, (from pointer - to pointer),

       1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7 --> null
    first   from               to   last

     1 -->null    2 --> 3 --> 4 --> 5 --> null     6 --> 7 --> null
     first        from              to             last

      1 -->null    5 --> 4 --> 3 --> 2 --> null     6 --> 7 --> null
     first        to              from             last

     first.next = to
     from.next = last

     tc: O(n)
     sc: O(1)
 */
public class ReverseBetweenLinkedList {

    public static ListNode reverseBetweenCleanCode(ListNode A, int B, int C) {

        ListNode head = A;
        int x = B;
        int y = C;

        if(x == y) {
            return head;
        }

        int c = 0;
        ListNode from = head;
        ListNode to = head;
        ListNode first = null;
        ListNode last = null;
        ListNode pointer = head;

        while(pointer != null) {
            c++;

            if(c < x) {
                first = pointer;
            } else if(c == x) {
                from = pointer;
            } else if( c == y) {
                to = pointer;
                last = to.next;
                break;
            }

            pointer = pointer.next;
        }

        to.next = null;

        reverse(from);

        if(first != null) {
            first.next = to;
        } else {
            head = to;
        }

        from.next = last;

        return head;
    }

    private static ListNode reverse(ListNode from) {
        ListNode prev = null;
        ListNode curr = from;
        ListNode next = from;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode reverseBetween(ListNode A, int B, int C) {

        ListNode head = A;
        int x = B;
        int y = C;

        if(x == y) {
            return head;
        }

        int c = 1;
        ListNode prevOfXNode = head;
        ListNode xNode = head;
        ListNode pointer = head;
        while(c<x && pointer != null) {
            prevOfXNode = pointer;
            pointer = pointer.next;
            c++;
        }

        if(x != 1) {
            xNode = prevOfXNode.next;
        }

        ListNode prev = null;
        ListNode curr = xNode;
        ListNode next = xNode;

        while( c<=y && curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

            c++;
        }

        if(x != 1) {
            prevOfXNode.next = prev;
            xNode.next = curr;
        } else {
            xNode.next = curr;
            return prev;
        }


        return head;
    }

    public static void main(String[] args) {

        ListNode head = createLinkedList();
        printLinkedList(head);

        ListNode reversedList = reverseBetween(head, 2, 5);
        printLinkedList(reversedList);

        System.out.println("-----");

        ListNode head1= createLinkedList();
        printLinkedList(head1);

        ListNode reversedList1 = reverseBetweenCleanCode(head1, 2, 5);
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
        ListNode n7 = new ListNode(7);


        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
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
