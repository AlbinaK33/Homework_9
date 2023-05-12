package main.java;

public class MyQueue {
    private Node front;
    private Node rear;
    private int size;

    public class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (front == null) {
            return null;
        }
        return front.data;
    }

    public Object poll() {
        if (front == null) {
            return null;
        }
        Node temp = front;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return temp.data;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add("Element 1");
        queue.add("Element 2");
        queue.add("Element 3");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        queue.clear();
        System.out.println(queue.size());
    }
}
