package com.solvd.townhall.lists.LinkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println("Doubly Linked List Test");
        System.out.println("Insert at Start");
        linkedList.insertAtStart(0);
        linkedList.display();
        System.out.println("Insert at End");
        linkedList.insertAtEnd(5);
        linkedList.display();
        System.out.println("Insert at Position");
        linkedList.insertAtPos(1, 2);
        linkedList.insertAtPos(2, 3);
        linkedList.insertAtPos(3, 4);
        linkedList.display();
        System.out.println("Deleting at Position 1");
        linkedList.deleteAtPos(1);
        linkedList.display();
    }
}
