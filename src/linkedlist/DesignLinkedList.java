package linkedlist;

/*
    There are four types of operations:

    0 x -1: Add a node of value x before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.

    1 x -1: Append a node of value x to the last element of the linked list.

    2 x index: Add a node of value x before the indexth node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.

    3 index -1: Delete the indexth node in the linked list, if the index is valid.

    A[i][0] represents the type of operation.

    A[i][1], A[i][2] represents the corresponding elements with respect to type of operation.

    Note: Indexing is 0 based.

    Input 2:
        A = [   [0, 1, -1]
                [1, 2, -1]
                [2, 3, 1]
                [0, 4, -1]
                [3, 1, -1]
                [3, 2, -1]
                           ]
    Output 2:
        4->3->NULL
 */
public class DesignLinkedList {

    class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
    }

    ListNode head = null;
    int size = 0;

    public ListNode solve(int[][] A) {

        // get the type of operation
        // operation - 0 - insert as head
        // operation - 1 - insert as last element
        // operation - 2 - insert at index
        // operation - 3 - delete node

        for(int i=0; i<A.length; i++) {
            int operation = A[i][0];
            int element = A[i][1];
            int index = A[i][2];

            if(operation == 0) {
                insertAtStart(element);
            } else if(operation == 1) {
                insertAtLast(element);
            } else if(operation == 2) {
                insertAtIndex(index, element);
            } else if(operation == 3) {
                index = A[i][1];
                delete(index);
            }

        }

        return head;
    }

    private void insertAtStart(int element) {

        ListNode node = new ListNode(element);

        node.next = head;
        head = node;
        size++;
    }

    private void insertAtLast(int element) {

        if(size == 0) {
            insertAtStart(element);
        } else {
            ListNode node = new ListNode(element);
            ListNode pointer = head;

            while(pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
            size++;
        }
    }

    private void insertAtIndex(int index, int element) {
        if(index == 0) {
            insertAtStart(element);
        } else if(index == size) {
            insertAtLast(element);
        } else if(index < size){
            ListNode node = new ListNode(element);
            ListNode pointer = head;
            int count = 0;

            while(count < index-1) {
                pointer = pointer.next;
                count++;
            }

            node.next = pointer.next;
            pointer.next = node;
            size++;
        }
    }

    private void deleteFirstNode() {
        head = head.next;
        size--;
    }

    private void deleteLastNode() {
        ListNode pointer = head;

        while(pointer.next.next != null) {
            pointer = pointer.next;
        }
        pointer.next = null;
        size--;
    }

    private void delete(int index) {

        if(size !=0 ) {
            if(index == 0) {
                deleteFirstNode();
            } else if(index == size-1) {
                deleteLastNode();
            } else if(index < size-1) {
                ListNode pointer = head;
                int count = 0;

                while(count < index-1) {
                    pointer = pointer.next;
                    count++;
                }
                pointer.next = pointer.next.next;
                size--;
            }
        }
    }
}
