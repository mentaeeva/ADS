package WEEK1;

public class MyStack<T> {
    private MyList<T> list;

    // constructor: accepts the list implementation
    public MyStack(MyList<T> listImpl) {
        this.list = listImpl;
    }

    // adds an element to the top of the stack
    public void push(T item) {
        list.addLast(item);
    }

    // removes and returns the top element of the stack
    public T pop() {
        if (empty()) return null;  // if the stack is empty, return null
        T top = list.getLast();   // get the top element
        list.removeLast();        // remove the top element
        return top;               // return the removed element
    }

    // returns the top element of the stack without removing it
    public T peek() {
        return empty() ? null : list.getLast();  // return the top element or null if empty
    }

    // returns true if the stack is empty
    public boolean empty() {
        return list.size() == 0;
    }

    // returns the size of the stack
    public int size() {
        return list.size();
    }

    // clears the stack
    public void clear() {
        list.clear();
    }
}
