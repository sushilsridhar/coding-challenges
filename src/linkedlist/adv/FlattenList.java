package linkedlist.adv;

/*
    Given a linked list where every node represents a linked list and contains two pointers of its type:

    Pointer to next node in the main list (right pointer)
    Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
    You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list.
    The flattened linked list should also be sorted.

    Problem Constraints

    1 <= Total nodes in the list <= 100000

    1 <= Value of node <= 109

   input:

   3 -> 4 -> 20 -> 20 ->30
   |    |    |     |    |
   7    11   22    20   31
   |               |    |
   7               28   39
   |               |
   8               39

   output:  3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39

   approach:

   use merge sort idea, and use the down pointer to sort them

   tc: O() // TODO
   sc: O()
 */
public class FlattenList {

    ListNode flatten(ListNode root) {
        return divideAndMerge(root);
    }

    private ListNode divideAndMerge(ListNode root) {

        if(root.right == null) {
            return root;
        }

        ListNode head = root;
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(pointer2 != null && pointer2.right != null && pointer2.right.right != null) {
            pointer1 = pointer1.right;
            pointer2 = pointer2.right.right;
        }

        ListNode headTwo = pointer1.right;
        pointer1.right = null;

        ListNode linkedL1 = divideAndMerge(head);
        ListNode linkedL2 = divideAndMerge(headTwo);

        return merge(linkedL1, linkedL2);
    }

    private ListNode merge(ListNode linkedL1, ListNode linkedL2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode dummyPointer = dummyHead;

        ListNode p1 = linkedL1;
        ListNode p2 = linkedL2;

        while(p1 != null && p2 != null) {

            if(p1.val < p2.val) {
                dummyPointer.down = p1;
                p1 = p1.down;
            } else {
                dummyPointer.down = p2;
                p2 = p2.down;
            }

            dummyPointer = dummyPointer.down;
        }

        if(p1 != null) {
            dummyPointer.down = p1;
        }

        if(p2 != null) {
            dummyPointer.down = p2;
        }

        return dummyHead.down;
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }
}
