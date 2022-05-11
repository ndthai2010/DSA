package src.eng_dict;

import java.util.*;
@SuppressWarnings("unchecked")
public class DictList<T> implements ListInterface<T>{

    private T[] array;
    private int top = 0;
    private int capacity = 100;

    public DictList(){
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        // TODO Auto-generated method stub
        if(size() > capacity){
            array = Arrays.copyOf(array, array.length * 3 / 2);
        }
        array[top++] = value;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        if(array != null){
            return array[index];
        }
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return top;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return array == null;
    }
    
}
