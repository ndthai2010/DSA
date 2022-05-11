package src.vi_dict;

import java.util.Arrays;
@SuppressWarnings("unchecked")
public class DictList<T> implements ListInterface<T> {

    private T[] array;
    private int n = 0;
    private int size = 100;

    public DictList(){
        array = (T[]) new Object[size];
    }

    @Override
    public void add(T value) {
        // TODO Auto-generated method stub
        if(size() >= array.length){
            array = Arrays.copyOf(array, array.length * 3 / 2);
        }

        array[n++] = value;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        if(array[index] != null){
            return array[index];
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
