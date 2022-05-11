package src.unordered_symbol_table;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "unchecked", "deprecation" })

public class ArraySymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int size = 100, n = 0;

    public ArraySymbolTable() {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
    }

    private int indexOf(Key key) {
        for (int i = 0; i < n; i++) {
            if (keys[i].compareTo(key) == 0)
                return i;
        }
        return -1;
    }

    @Override
    public void put(Key key, Value value) {
        // TODO Auto-generated method stub
        int idx = indexOf(key);
        if(idx == -1){
            keys[n] = key;
            values[n] = value;
            n++;
        }else{
            values[idx] = value;
        }
    }

    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        int idx = indexOf(key);
        if(idx == -1){
            return null;
        }
        return values[idx];
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        List<Key> list = new ArrayList<Key>();
        for(int i = 0; i < n; i++){
            if(values[i] != null){
                list.add(keys[i]);
            }
        }
        return list;
    }

    
}
