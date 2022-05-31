package linkedlist.adv;

/*
    Merge Sort on linked list

    approach:
    find the middle element of list using fast slow pointer, split it into two ll and apply merge

    T(N) = 2 T(N/2) + 2 N

    tc: O(nlogn)
    sc: O(logn)
 */
public class MergeSortOnLinkedList {

    public static ListNode mergeSort(ListNode A) {
        ListNode head = A;

        if( head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddleNode(head);

        ListNode secondHalf = mid.next;
        mid.next = null;

        ListNode h1 = head;
        ListNode h2 = secondHalf;

        ListNode sortedList1 = mergeSort(h1);
        ListNode sortedList2 = mergeSort(h2);

        return merge(sortedList1, sortedList2);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {

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

    private static ListNode getMiddleNode(ListNode head) {

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

        ListNode mergedList = mergeSort(head);
        printLinkedList(mergedList);

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
        ListNode head = new ListNode(100);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(102);
        ListNode n4 = new ListNode(19);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(4);

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(7);
        ListNode n10 = new ListNode(100);
        ListNode n11 = new ListNode(98);
        ListNode n12 = new ListNode(5);


        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;

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
