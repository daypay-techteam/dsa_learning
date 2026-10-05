package com.daypaytechnologies.linkedlist;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    private static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    public SinglyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Add a node to the end of the LinkedList
     * This operation is O(1) which is constant in nature
     *
     * @param value - the value to be added
     *
     * Append is O(1) because the linked list maintains a tail pointer.
     * We can directly access the last node and attach the new node without traversing the list.
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }
}
