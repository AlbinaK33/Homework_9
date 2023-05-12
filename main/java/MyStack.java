package main.java;

public class MyStack {
    private Node head;
    private int size;

    public class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyStack() {
        this.head = null;
        this.size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void remove(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return;
        }
        current.next = current.next.next;
        size--;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public Object pop() {
        if (head == null) {
            return null;
        }
        Object data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("Element 1");
        stack.push("Element 2");
        stack.push("Element 3");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack.size());
    }
}
