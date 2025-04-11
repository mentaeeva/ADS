package WEEK1;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    //constructor
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    //check if index is not out of bounds
    private void checkIndexValid(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    //returns node by its index
    private Node getNode(int index) {
        checkIndexValid(index);
        return getNode(index, head, 0);
    }

    private Node getNode(int index, Node current, int currentIndex) {
        if (currentIndex == index) {
            return current;
        }
        return getNode(index, current.next, currentIndex + 1);
    }
    //add data to the end
    @Override
    public void add(T data) {
        addLast(data);
    }

    // add new data to exact index
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;
        Node newNode = new Node(item);
        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    //returns last node
    @Override
    public T getLast() {
        return tail.data;
    }

    //returns first node
    @Override
    public T getFirst() {
        return head.data;
    }

    //returns node by index
    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    //replace prev data to the new
    @Override
    public void set(int index, T item) {
        getNode(index).data = item;
    }

    //remove by index
    @Override
    public void remove(int index) {
        checkIndexValid(index);
        Node nodeToRemove = getNode(index);
        if (nodeToRemove == head) {
            removeFirst();
            return;
        }
        if (nodeToRemove == tail) {
            removeLast();
            return;
        }
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
        size--;
    }
    // removes first node
    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }
    //removes last node
    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
    }

    //add new node as a head
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    //add new node as tail
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    //returns index
    @Override
    public int indexOf(Object object) {
        return indexOfRecursive(object, head, 0);
    }

    private int indexOfRecursive(Object object, Node current, int index) {
        if (current == null) {
            return -1; // Если достигли конца списка, возвращаем -1
        }
        if (current.data.equals(object)) {
            return index; // Если нашли элемент, возвращаем его индекс
        }
        return indexOfRecursive(object, current.next, index + 1); // Рекурсивно идём к следующему элементу
    }


    //returns last index
    @Override
    public int lastIndexOf(Object object) {
        return lastIndexOf(object, tail, -1);
    }

    private int lastIndexOf(Object object, Node current, int index) {
        if (current == null) {
            return index;
        }
        if (current.data.equals(object)) {
            return index;
        }
        return lastIndexOf(object, current.prev, index - 1);
    }


    //check if object exists
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }
    //linkedlist to array
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        toArrayRecursive(array, head, 0);
        return array;
    }
    //recursive method of copying data to array
    private void toArrayRecursive(Object[] array, Node current, int index) {
        if (current == null) {
            return;
        }
        array[index] = current.data;
        toArrayRecursive(array, current.next, index + 1);
    }

    //bubble sorting
    @Override
    public void sort() {
        if (size < 2) {
            return;
        }
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                Comparable<T> data1 = (Comparable<T>) i.data;
                if (data1.compareTo(j.data) > 0) {
                    T temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }
    //clears linkedlist
    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    //returns size
    @Override
    public int size() {
        return size;
    }
//iterator
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }


}
