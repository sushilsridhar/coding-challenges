package linkedlist.adv;

/*
     1->2->3->
                        100->101->102->109
     6->7->8->9->10->

     approach:

     find the length of two linkedlist, iterate the longer list to diff times,
     and find the intersection

     tc: O(n+m)
     sc: O(1)
 */
public class IntersectionInYShape {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pointer1 = headA;
        ListNode pointer2 = headB;
        int sizeA = 0;
        int sizeB = 0;

        while(pointer1 != null) {
            sizeA++;
            pointer1 = pointer1.next;
        }

        while(pointer2 != null) {
            sizeB++;
            pointer2 = pointer2.next;
        }

        int diff = Math.abs(sizeA-sizeB);

        ListNode p1 = headA;
        ListNode p2 = headB;

        if(sizeA > sizeB) {
            while(diff != 0) {
                p1 = p1.next;
                diff--;
            }
        } else if(sizeA < sizeB) {
            while(diff != 0) {
                p2 = p2.next;
                diff--;
            }
        }

        while(p1 != null && p2 != null) {

            if(p1 == p2) {
                return p2;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
}
