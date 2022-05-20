package linkedlist.adv;

/*
    Given a singly linked list, delete middle of the linked list.
    For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

    If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
    For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

    Return the head of the linked list after removing the middle node.
    If the input linked list has 1 node, then this node should be deleted and a null node should be returned.

    TODO document approach
 */
public class DeleteMiddle {

    public Node optimizedUsingTwoPointers(Node A) {

        Node head = A;

        Node pointer = head;
        Node pointer2 = head;
        Node prev = null;

        while(pointer2.next != null && pointer2.next.next != null) {
            prev = pointer;
            pointer = pointer.next;
            pointer2 = pointer2.next.next;
        }

        if(pointer2.next == null) {
            if(prev == null) {
                head = head.next;
                return head;
            }
            prev.next = pointer.next;
        } else {
            prev = pointer;
            pointer = pointer.next;

            prev.next = pointer.next;
        }

        return head;
    }

    private static Node bruteForce(Node A) {

        Node head = A;

        Node pointer1 = head;
        int size = 0;

        while(pointer1 != null) {
            size++;
            pointer1 = pointer1.next;
        }

        if(size == 1) {
            A = A.next;
            return A;
        }

        int k = (size-1)/2;
        if((size & 1) == 0) {
            k++;
        }

        Node prev = null;
        Node pointer2 = head;
        int i=0;
        while(i<k) {
            prev = pointer2;
            pointer2 = pointer2.next;
            i++;
        }

        prev.next = pointer2.next;


        return head;
    }

    public static void main(String[] args) {

        Node head = createLinkedList();
        printLinkedList(head);

        Node reversedList = bruteForce(head);
        printLinkedList(reversedList);

    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private static Node createLinkedList() {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);


        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return head;
    }

    private static void printLinkedList(Node head) {
        Node pointer = head;

        while(pointer != null) {
            System.out.print(pointer.val+" --> ");
            pointer = pointer.next;
        }
        System.out.print("null");
        System.out.println("");
    }
}
