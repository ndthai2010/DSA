package src.count_words;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings({ "unchecked", "deprecation" })
public class SimpleArrayList<T> implements ListInterface<T> {

    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (size() > array.length) {
            array = Arrays.copyOf(array, array.length * 3 / 2);
        }
        array[n++] = data;
    }

    public T get(int i) {
        if (!isEmpty()) {
            return array[i];
        }
        return null;
    }

    public void set(int i, T data) {
        if (!isEmpty()) {
            array[i] = data;
        }
    }

    public void remove(int i) {
        if (array.length < i) {
            return;
        }

        T[] tokens = (T[]) new Object[array.length - 1];
        for (int idx = 0; idx < tokens.length; idx++) {
            tokens[idx] = array[idx];
        }

        for (int idx = i + 1; idx < tokens.length; idx++) {
            tokens[idx] = array[idx];
        }

        array = Arrays.copyOf(array, array.length - 1);

        for (int idx = 0; idx < tokens.length; idx++) {
            tokens[idx] = array[idx];
        }
    }

    public boolean isContain(T data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T data) {
        for (int idx = 0; idx < array.length; idx++) {
            if (array[idx] != null && array[idx].equals(data)) {
                return idx;
            }
        }
        return -1;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < n;
        }

        @Override
        public T next() {
            T data = array[current];
            current++;
            return data;
        }

    }

}
