package leetcode.linkedlist;


import java.util.List;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }
    }


    static ListNode addTwoList(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode head = new ListNode();
        ListNode pointer = head;

        int sum= 0;
        int carry= 0;

        while(p1 != null || p2 != null) {

            sum = (p1!=null ? p1.val : 0) + (p2!=null ? p2.val : 0) + carry;

            carry = sum/10;

            int val = sum%10;

            if(p1!=null) {
                p1 = p1.next;
            }
            if(p2!=null) {
                p2 = p2.next;
            }


            ListNode node = new ListNode(val);

            pointer.next = node;

            pointer = pointer.next;

        }

        if(carry != 0) {
            pointer.next = new ListNode(carry);
        }

        return head.next;
    }



    public static void main(String args[]) {

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(8);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;


        ListNode node = addTwoList(a1, b1);

        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }

}
