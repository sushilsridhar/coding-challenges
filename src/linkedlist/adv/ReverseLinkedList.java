package linkedlist.adv;

/*
    TODO, check the better approach and video
 */
public class ReverseLinkedList {

    private static Node reverseList(Node head) {

        Node prev = null;
        Node curr = head;
        Node next = curr;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        Node head = createLinkedList();
        printLinkedList(head);

        Node reversedList = reverseList(head);
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
