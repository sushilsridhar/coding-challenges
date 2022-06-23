package linkedlist.adv;

import java.util.HashMap;

/*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
    The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

    Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

    NOTE: If you are using any global variables, make sure to clear them in the constructor.

    Example :

    Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1

    approach:

    -1 <-> 1 <-> 5

    get(5)
    get(1) , deletes 1 and insert new 1 at end of queue, update the new address in map

    -1 <-> 5 <-> 1
    map       - (1,addressOf 1) , (5, addressOf 5)
    valuesmap - (1,10) , (5,12) ,

    set(6, 14)

    -1 <-> 1 <-> 6
    map       - (1,addressOf 1) , (6, addressOf 6)
    valuesmap - (1,10) , (6,14)

    tc: O(1)
    sc: O(capacity)

 */
public class LRUCache {

    int capacity = 0;
    int size = 0;
    int keyOfHead = 0;

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, Integer> valuesMap = new HashMap<>();

    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keyOfHead = 0;

        Node dummyNode = new Node(-1);
        head = dummyNode;
        tail = dummyNode;

        map.clear();
        valuesMap.clear();
    }

    public int get(int key) {

        if(map.containsKey(key)) {
            removeNodeFromQueue(key);
            Node newNode = addNodeAtTailOfQueue(key);
            insertOrUpdateNodeAddressInMap(key, newNode);
            return valuesMap.get(key);
        }

        return -1;
    }

    public void set(int key, int value) {

        if(map.containsKey(key)) {
            removeNodeFromQueue(key);
            Node newNode = addNodeAtTailOfQueue(key);
            insertOrUpdateNodeAddressInMap(key, newNode);
            insertOrUpdateValueInValuesMap(key, value);
        } else {

            if(size != 0 && size == capacity) {
                popFromTheFrontOfQueue();
            }

            Node newNode = addNodeAtTailOfQueue(key);
            insertOrUpdateNodeAddressInMap(key, newNode);
            insertOrUpdateValueInValuesMap(key, value);
        }

    }

    private void popFromTheFrontOfQueue() {
        int key = keyOfHead;
        removeNodeFromQueue(key);
        removeNodeAndValueFromMaps(key);
    }

    private void removeNodeAndValueFromMaps(int key) {
        map.remove(key);
        valuesMap.remove(key);
    }

    private void removeNodeFromQueue(int key) {

        Node node = map.get(key);

        if(head == tail && node == head) {
            Node dummyNode = node.prev;
            node.prev = null;
            dummyNode.next = null;

            head = dummyNode;
            tail = dummyNode;

            keyOfHead = 0;
        } else {
            Node n1 = node.prev;
            Node n2 = node.next;

            node.prev = null;
            node.next = null;

            n1.next = n2;

            if(node == head) {
                head = n2;
                keyOfHead = n2.data;
            }

            if(n2 == null)
                tail = n1;
            else
                n2.prev = n1;
        }

        size--;
    }

    private Node addNodeAtTailOfQueue(int key) {

        Node newNode = new Node(key);

        if(size == 0) {
            head.next = newNode;
            newNode.prev = head;

            head = newNode;
            tail = newNode;

            keyOfHead = key;
        } else {
            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;
        }

        size++;

        return newNode;
    }

    private void insertOrUpdateNodeAddressInMap(int key, Node newNode) {
        map.put(key, newNode);
    }

    private void insertOrUpdateValueInValuesMap(int key, int value) {
        valuesMap.put(key, value);
    }
}
