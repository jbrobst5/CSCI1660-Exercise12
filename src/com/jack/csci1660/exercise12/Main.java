package com.jack.csci1660.exercise12;

/*
Implement a Queue generic type similar to the Stack type but with enqueue( ) and dequeue( ) methods. The enqueue( )
method adds an element to the queue and the dequeue( ) method removes the first/oldest element from the queue. Stacks
are often described as being "last-in, first-out" whereas queues represent a "first-in, first-out" behavior.
 */

class Queue<T> {                                // One-directional queue

    private class Node<T> {
        T data;                    // Generic data
        Node<T> next;              // Single direction
        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front;

    public Queue() {} // Intentionally empty

    public void enqueue(T data) {
        if (this.front == null) {               // If there's nothing in the queue
            this.front = new Node<>(data);      // Add the first thing
            return;     // Code golf
        }
        Node<T> current = this.front;
        while (current.next != null) {      // Get the last node
            current = current.next;
        }
        current.next = new Node<>(data);    // Append the new node
    }

    public T dequeue() {
        T out = this.front.data;        // save off the data, for returning
        this.front = this.front.next;   // takes care of depleting the queue, garbage collection will erase old front eventually
        return out;
    }

    public String toString() {
        if (this.front == null) {
            return "Queue is empty";
        }
        String out = "";
        Node<T> current = this.front;
        while (current.next != null) {
            out += current.data.toString() + ", ";
            current = current.next;
        }
        return out + current.data.toString();
    }

}

public class Main {

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();
        Queue<String> stringQueue = new Queue<>();

        System.out.printf("integerQueue: %s\n", integerQueue.toString());
        System.out.printf("stringQueue: %s\n", stringQueue.toString());

        System.out.println("Enqueueing some data to integerQueue");
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        integerQueue.enqueue(4);
        integerQueue.enqueue(5);

        System.out.println("Enqueueing some data to stringQueue");
        stringQueue.enqueue("one");
        stringQueue.enqueue("two");
        stringQueue.enqueue("three");
        stringQueue.enqueue("four");
        stringQueue.enqueue("five");

        System.out.printf("integerQueue: %s\n", integerQueue.toString());
        System.out.printf("stringQueue: %s\n", stringQueue.toString());

        System.out.println("Dequeueing some 2 items from integerQueue");
        integerQueue.dequeue();
        integerQueue.dequeue();

        System.out.println("Dequeueing some 2 items from stringQueue");
        stringQueue.dequeue();
        stringQueue.dequeue();

        System.out.printf("integerQueue: %s\n", integerQueue.toString());
        System.out.printf("stringQueue: %s\n", stringQueue.toString());
    }

}
