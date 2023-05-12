package main.java;

public class MyHashMap {
    private Node[] buckets;
    private int size;

    public class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    private int hashFunction(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void put(Object key, Object value) {
        int index = hashFunction(key);
        Node node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    public void remove(Object key) {
        int index = hashFunction(key);
        Node prev = null, current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        buckets = new Node[buckets.length];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = hashFunction(key);
        Node node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(10);
        map.put("Element", 1);
        map.put("element", 2);
        System.out.println(map.get("Element"));
        map.remove("Element");
        System.out.println(map.get("Element"));
        System.out.println(map.size());
        map.clear();
        System.out.println(map.size()); 
    }
}
