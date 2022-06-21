package linkedlist.adv;

import java.util.HashMap;

/*
    A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

    Return a deep copy of the list.

    Given list
       1 -> 2 -> 3
    with random pointers going from
      1 -> 3
      2 -> 1
      3 -> 1

      approach:

      1 -> 2 -> 3, map the first and second list in hashmap
      1 -> 2 -> 3

      use this mapping to set the random pointer

      tc: O(n)
      sc: O(n)

      optimized:
      1 -> 2 -> 3, create a copy of each node in the same list
      1 -> 1 -> 2 -> 2 -> 3 -> 3 -> null

      use two pointers to map the random pointer and split the list

      tc: O(n)
      sc: O(1)
 */
public class CloneLinkedList {

    //  tc: O(n)
    //  sc: O(1)
    private static RandomListNode copyRandomListOptimized(RandomListNode head) {

        if(head == null) {
            return null;
        }

        RandomListNode pointer = head;

        while(pointer != null) {
            RandomListNode copy = new RandomListNode(pointer.label);

            copy.next = pointer.next;
            pointer.next = copy;

            pointer = copy.next;
        }

        RandomListNode x = head;
        RandomListNode y = head.next;

        while(x != null && y != null) {

            if(x.random != null) {
                y.random = x.random.next;
            }

            x = y.next;

            if(y.next != null)
                y = y.next.next;
        }

        RandomListNode x1 = head;
        RandomListNode clonedHead = head.next;
        RandomListNode y1 = clonedHead;

        while(x1 != null && y1 != null) {

            x1.next = y1.next;

            if(y1.next != null) {
                y1.next = y1.next.next;
            }

            x1 = x1.next;
            y1 = y1.next;
        }

        return clonedHead;
    }

    //  tc: O(n)
    //  sc: O(n)
    private static RandomListNode copyRandomList(RandomListNode head) {

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode pointer = head;
        RandomListNode clonedHead = new RandomListNode(0);
        RandomListNode pointerForClone = clonedHead;

        while(pointer != null) {
            RandomListNode node = new RandomListNode(pointer.label);
            pointerForClone.next = node;

            map.put(pointer, node);

            pointerForClone = pointerForClone.next;
            pointer = pointer.next;
        }

        RandomListNode pointer2 = head;
        RandomListNode pointer2ForClone = clonedHead.next;

        while(pointer2 != null) {

            RandomListNode nodeRandom = pointer2.random;

            if(nodeRandom != null) {
                RandomListNode clonedRandom = map.get(nodeRandom);
                pointer2ForClone.random = clonedRandom;
            }

            pointer2ForClone = pointer2ForClone.next;
            pointer2 = pointer2.next;
        }

        return clonedHead.next;
    }

    public static void main(String[] args) {

        RandomListNode head = createLinkedList();
        printLinkedList(head);

        RandomListNode r = copyRandomList(head);
        printLinkedList(r);

        RandomListNode r1 = copyRandomListOptimized(head);
        printLinkedList(r1);
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    private static class RandomListNode {
        private int label;
        private RandomListNode next;
        private RandomListNode random;

        RandomListNode(int x) {
            label = x;
        }
    }

    private static RandomListNode createLinkedList() {
        RandomListNode head = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);

        head.next = n2;
        head.random = n3;
        n2.next = n3;
        n2.random = head;
        n3.random = head;

        return head;
    }

    private static void printLinkedList(RandomListNode head) {
        RandomListNode pointer = head;
        RandomListNode pointer2 = head;

        while(pointer != null) {
            System.out.print(pointer.label+" --> ");
            pointer = pointer.next;
        }
        System.out.print("null");
        System.out.println("");

        while(pointer2 != null) {
            System.out.print(pointer2.random.label+" -- ");
            pointer2 = pointer2.next;
        }

        System.out.println("");
    }
}
