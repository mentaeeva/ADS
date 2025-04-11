package WEEK1;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    // constructor
    private Object[] array;
    private int size;

    //creating object and array
    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    //to make size bigger
    private void grow() {
        Object[] newArray = new Object[array.length * 2];
        copyElements(newArray, 0);
        array = newArray;
    }

    private void copyElements(Object[] newArray, int index) {
        if (index == size) return;
        newArray[index] = array[index];
        copyElements(newArray, index + 1);
    }

    // add new element (calls void grow)
    @Override
    public void add(T item) {
        if (size == array.length) grow();
        array[size++] = item;
    }

    // set new element instead of previous one
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) return;
        array[index] = item;
    }

    //add new element to exact index, moving other elements to the right
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) return;
        if (size == array.length) grow();
        shiftRight(index, size);
        array[index] = item;
        size++;
    }

    private void shiftRight(int index, int current) {
        if (current == index) return;
        array[current] = array[current - 1];
        shiftRight(index, current - 1);
    }

    //add element in first position
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // add element in last position
    @Override
    public void addLast(T item) {
        add(item);
    }

    // returns element by its index
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return (T) array[index];
    }

    //returns first element
    @Override
    public T getFirst() {
        if (size == 0) return null;
        return (T) array[0];
    }

    //returns last element
    @Override
    public T getLast() {
        if (size == 0) return null;
        return (T) array[size - 1];
    }

    // deletes element by index
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) return;
        shiftLeft(index, size - 1);
        size--;
    }

    private void shiftLeft(int index, int current) {
        if (index == current) return;
        array[index] = array[index + 1];
        shiftLeft(index + 1, current);
    }

    //deletes first element
    @Override
    public void removeFirst() {
        remove(0);
    }

    //deletes last element
    @Override
    public void removeLast() {
        if (size == 0) return;
        size--;
    }

    //sorting by bubble sort
    @Override
    public void sort() {
        bubbleSort(0, 0);
    }

    private void bubbleSort(int i, int j) {
        if (i == size - 1) return;
        if (j == size - 1 - i) {
            bubbleSort(i + 1, 0);
            return;
        }
        Comparable<T> current = (Comparable<T>) array[j];
        T next = (T) array[j + 1];
        if (current.compareTo(next) > 0) {
            T temp = (T) array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
        bubbleSort(i, j + 1);
    }

    // returns index of element
    @Override
    public int indexOf(Object object) {
        return findIndex(object, 0);
    }

    private int findIndex(Object object, int index) {
        if (index == size) return -1;
        if (object.equals(array[index])) return index;
        return findIndex(object, index + 1);
    }

    //returns index of the last repeated element
    @Override
    public int lastIndexOf(Object object) {
        return findLastIndex(object, size - 1);
    }

    private int findLastIndex(Object object, int index) {
        if (index < 0) return -1;
        if (object.equals(array[index])) return index;
        return findLastIndex(object, index - 1);
    }

    //determines if element exists
    @Override
    public boolean exists(Object object) {
        return checkExists(object, 0);
    }

    private boolean checkExists(Object object, int index) {
        if (index == size) return false;
        if (object.equals(array[index])) return true;
        return checkExists(object, index + 1);
    }

    //makes exact array from object array
    @Override
    public Object[] toArray() {
        Object[] exactArray = new Object[size];
        fillExactArray(exactArray, 0);
        return exactArray;
    }

    private void fillExactArray(Object[] exactArray, int index) {
        if (index == size) return;
        exactArray[index] = array[index];
        fillExactArray(exactArray, index + 1);
    }

    //clears array
    @Override
    public void clear() {
        size = 0;
    }

    //returns number of elements
    @Override
    public int size() {
        return size;
    }

    // to use foreach
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }
}
