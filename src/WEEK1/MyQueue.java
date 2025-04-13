package WEEK1;

public class MyQueue<T> {
    private MyList<T> list;

    // constructor: accepts the list implementation
    public MyQueue(MyList<T> listImpl) {
        this.list = listImpl;
    }

    // returns true if the queue is empty
    public boolean empty() {
        return list.size() == 0;
    }

    // adds an element to the end of the queue
    public void enqueue(T item) {
        list.addLast(item);
    }

    // removes and returns the front element of the queue
    public T dequeue() {
        if (empty()) return null;  // if the queue is empty, return null
        T item = list.getFirst();  // get the first element
        list.removeFirst();        // remove the first element
        return item;               // return the removed element
    }

    // returns the front element of the queue without removing it
    public T peek() {
        return empty() ? null : list.getFirst();  // return the front element or null if empty
    }

    // returns the size of the queue
    public int size() {
        return list.size();
    }

    // clears the queue
    public void clear() {
        list.clear();
    }
}
