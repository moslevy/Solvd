package com.example.hw5.Queue;

import java.util.PriorityQueue;

public class QueueClass {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 10; i>0; i--){
            queue.add(i);

        }
        System.out.println("Before removing head");
        System.out.println("Queue size is: " +queue.size());
        System.out.println("Queue head item: "+queue.peek()); // Look at the first item on the queue.
        queue.poll(); // Remove first item of the list.
        System.out.println("After removing head");
        System.out.println("Queue size is: " +queue.size());
        System.out.println("Queue head item: "+queue.peek()); // Look at the first item on the queue.
    }
    // Queue of citizens that would like to pay their taxes.
}
