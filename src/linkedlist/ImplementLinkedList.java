package linkedlist;

public class ImplementLinkedList {
        static class Node {
                int data;
                Node next;

                Node(int data) {
                        this.data = data;
                }
        }

        static Node head;
        static int size = 0;

        public static void insert_node(int position, int value) {
                // @params position, integer
                // @params value, integer

                Node node = new Node(value);
                Node pointer = head;

                if(position == 1) {
                        node.next = head;
                        head = node;
                        size++;
                } else if(position == size+1) {
                        while(pointer.next != null) {
                                pointer = pointer.next;
                        }
                        pointer.next = node;
                        size++;
                } else if(position != 0 && position <= size) {
                        int count = 1;
                        while(count < position-1) {
                                pointer = pointer.next;
                                count++;
                        }
                        node.next = pointer.next;
                        pointer.next = node;
                        size++;
                }
        }

        public static void delete_node(int position) {
                // @params position, integer
                Node pointer = head;

                if(size > 0) {
                        if(position == 1) {
                                head = head.next;
                                size--;
                        } else if(position == size) {
                                while(pointer.next.next != null) {
                                        pointer = pointer.next;
                                }
                                pointer.next = null;
                                size--;
                        } else if(position != 0 && position < size) {
                                int count = 1;

                                while(count < position-1) {
                                        pointer = pointer.next;
                                        count++;
                                }
                                Node removedNode = pointer.next;
                                pointer.next = pointer.next.next;
                                removedNode.next = null;
                                size--;
                        }
                }
        }

        public static void print_ll() {
                // Output each element followed by a space

                Node pointer = head;
                while(pointer.next != null) {
                        System.out.print(pointer.data+" ");
                        pointer = pointer.next;
                }
                if(pointer!=null) { // to avoid printing space after the last element
                        System.out.print(pointer.data);
                }
        }
}

