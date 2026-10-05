package com.daypaytechnologies.linkedlist;

public class CycleLinkedList extends SinglyLinkedList{

    public CycleLinkedList() {
        super();
    }

    public CycleLinkedList(int value) {
        super(value);
    }

    /**
     * Creates a cycle by connecting the last node
     * to the node at the given position.
     *
     * position = 0 means head
     * position = 1 means second node
     */
    public void createCycle(int position) {
        if (head == null) {
            return;
        }
        Node cycleNode = null;
        Node current = head;
        int index = 0;
        while (current.next != null) {
            if (index == position) {
                cycleNode = current;
            }
            current = current.next;
            index++;
        }
        // Connect last node to selected node
        if (index == position) {
            cycleNode = current;
        }
        if (cycleNode != null) {
            current.next = cycleNode;
        }
    }

    /**
     * Detect whether the linked list contains a cycle.
     *
     * Floyd's Cycle Detection Algorithm:
     *
     * slow -> moves one node
     * fast -> moves two nodes
     */
    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // -------------------------
        // Example 1: No cycle
        // -------------------------
        CycleLinkedList list1 = new CycleLinkedList();
        list1.append(10);
        list1.append(20);
        list1.append(30);
        list1.append(40);
        System.out.println("List 1 has cycle: " + list1.hasCycle());

        // -------------------------
        // Example 2: Cycle exists
        // -------------------------
        CycleLinkedList list2 = new CycleLinkedList();
        list2.append(10);
        list2.append(20);
        list2.append(30);
        list2.append(40);
        // 40 -> 30
        list2.createCycle(2);
        System.out.println("List 2 has cycle: " + list2.hasCycle());

        /**
         * 2 means:
         *
         * Connect the last node to the node at position 2.
         *
         * Position 2 contains 30.
         *
         * Therefore:
         *
         * 40.next = 30
         *
         * The list becomes:
         *
         * 10 → 20 → 30 → 40
         *           ↑     |
         *           |_____|
         */
    }
}
