package WEEK1;
import java.util.Iterator;
public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    private void grow() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public void add(T item) {
        if (size == array.length) grow();
        array[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) return;
        array[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) return;
        if (size == array.length) grow();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        if (size == 0) return null;
        return (T) array[0];
    }

    @Override
    public T getLast() {
        if (size == 0) return null;
        return (T) array[size - 1];
    }




}

