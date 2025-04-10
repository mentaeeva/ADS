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
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
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
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
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
    public void remove (int index){
        if (index < 0 || index >= size) return;
        array[index] = null;
    }

    //deletes first element
    @Override
    public void removeFirst(){
        if (size == 0) return;
        size--;
        array[0] = null;
    }

    //deletes last element
    @Override
    public void removeLast(){
        if (size == 0) return;
        size--;
        array[size - 1] = null;
    }

    //sorting by bubble sort
    @Override

    public void sort() {
        for (int i = 0; i < size - 1; i++) { // Внешний цикл (проходы по массиву)
            for (int j = 0; j < size - 1 - i; j++) { // Внутренний цикл (сравнение элементов)
                Comparable<T> current = (Comparable<T>) array[j]; // Текущий элемент
                T next = (T) array[j + 1]; // Следующий элемент
                if (current.compareTo(next) > 0) { // Сравниваем элементы
                    T temp = (T) array[j]; // Сохраняем текущий элемент
                    array[j] = array[j + 1]; // Меняем местами
                    array[j + 1] = temp;
                }
            }
        }
    }

    // returns index of element
    @Override
    public int indexOf(Object object){
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) return i ;
        }
        return -1;

    }
    //returns index of the last repeated element
    @Override
    public int lastIndexOf(Object object){
        for (int i=size-1; i>=0;i--){
            if (object.equals(array[i])) return i;
        }
        return -1;
    }

    //determines if element exists
    @Override
    public boolean exists(Object object){
        for (int i=0; i<size;i++){
            if (object.equals(array[i])) return true;
        }
        return false;
    }

    //makes exact array from object array
    @Override
    public Object[] toArray(){
        Object[] ExactArray = new Object[size];
        for (int i=0;i<size;i++){
            ExactArray[i] = array[i];

        }
        return ExactArray;
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
        return new Iterator<T>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                return (T) array[current++];
            }
        };
    }





}

