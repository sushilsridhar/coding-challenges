package linkedlist;

/*
    Given a node, delete the node
    Given: that node is not the last element of linked list

    approach:

    1 -> 2 -> 3 -> 4 -> 5

    remove 3, head of the linked list is not given

    copy the data of 4 to 3, point the new 4 to 5, the old element 4 will be garbage collected

    node.data = node.next.data;
    node.next = node.next.next;
 */
public class GivenNodeDeleteNode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;
    static int size = 0;

    public static void insert_node(int value) {
        // @params position, integer
        // @params value, integer

        Node node = new Node(value);
        Node pointer = head;

        if(size == 0) {
            head = node;
        } else {
            while(pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
        }
        size++;
    }

    public static Node getNode(int position) {

        Node pointer = head;

        int count = 1;
        while(count < position) {
            pointer = pointer.next;
            count++;
        }

        return pointer;
    }

    public static void main(String[] args) {

        insert_node(1);
        insert_node(2);
        insert_node(3);
        insert_node(4);
        insert_node(5);

        Node node = getNode(3);
        delete(node);

        Node pointer = head;
        while(pointer != null) {
            System.out.print(pointer.data+" ");
            pointer = pointer.next;
        }

    }

    static void delete(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;

        size--;
    }

}
