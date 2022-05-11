package src.vietnamese_dict;

import java.util.*;
public class DictList<T> implements ListInterface<T> {

    private T[] values;
    private int n = 0;
    private int size = 1000;

    public DictList(){
        values = (T[]) new Object[size];
    }

    @Override
    public void add(T data) {
        // TODO Auto-generated method stub
        if(size() > values.length){
            values = Arrays.copyOf(values, values.length * 3 / 2);
        }
        values[n++] = data;
    }

    @Override
    public T get(int i) {
        // TODO Auto-generated method stub
        if(values[i] != null){
            return values[i];
        }
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n == 0;
    }

}
