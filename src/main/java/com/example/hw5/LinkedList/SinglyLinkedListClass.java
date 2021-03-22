package com.example.hw5.LinkedList;

public class SinglyLinkedListClass {

    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedListClass ssl = new SinglyLinkedListClass();
        ssl.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        //Now we will connect them together to form a chain.

        ssl.head.next = second; // 10 --> 1
        second.next = third; // 10 --> 1 --> 8
        third.next = fourth; // 10 --> 1 --> 8 --> 11 --> null

        ssl.display(ssl.head);

        SinglyLinkedListClass singlyLinkedList = new SinglyLinkedListClass();
        ListNode reverseListNode = singlyLinkedList.reverse();

        ssl.display(ssl.head);

        System.out.println(reverseListNode);
    }

    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length() {
        if(head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public ListNode reverse() {
        if(head == null) {
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
