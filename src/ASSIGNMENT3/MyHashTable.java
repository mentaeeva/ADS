package ASSIGNMENT3;

public class MyHashTable<K, V> {
    // Inner class representing a node in a linked list
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        // Constructor initializes key and value
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // toString method to print key-value pair
        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    // constructor
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    // Constructor with number of buckets
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    // compute index for a key
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    // insert key-value into the table
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = chainArray[index];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        chainArray[index] = newNode;
    }

    // retrieve value using key
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    // remove key-value pair by key
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null;

        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            chainArray[index] = head.next;
        }
        return head.value;
    }
    // check if a value exists
    public boolean contains(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) return true;
                node = node.next;
            }
        }
        return false;
    }

    // get key by value (first occurrence)
    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            while (node != null) {
                if (node.value.equals(value)) return node.key;
                node = node.next;
            }
        }
        return null;
    }

}



