package linkedlist.adv;

// TODO
public class SortList {

    public ListNode sortList(ListNode A) {
        ListNode head = A;

        if( head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddleNode(head);

        ListNode secondHalf = mid.next;
        mid.next = null;

        ListNode h1 = head;
        ListNode h2 = secondHalf;

        ListNode sortedList1 = sortList(h1);
        ListNode sortedList2 = sortList(h2);

        return merge(sortedList1, sortedList2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);

        ListNode rPointer = head;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;

        while(pointer1 != null && pointer2 != null) {
            if(pointer1.val < pointer2.val) {
                rPointer.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                rPointer.next = pointer2;
                pointer2 = pointer2.next;
            }
            rPointer = rPointer.next;
        }

        if(pointer1 != null) {
            rPointer.next = pointer1;
        }

        if(pointer2 != null) {
            rPointer.next = pointer2;
        }

        return head.next;
    }

    private ListNode getMiddleNode(ListNode head) {

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

}
