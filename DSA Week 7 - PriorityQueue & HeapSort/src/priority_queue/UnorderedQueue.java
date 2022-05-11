package src.priority_queue;

import java.util.Arrays;

public class UnorderedQueue<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {

    private Key[] keys;
    private int n = 0;

    @Override
    public void insert(Key key) {
        // TODO Auto-generated method stub
        if (size() >= keys.length) {
            keys = Arrays.copyOf(keys, keys.length * 2);
        }
        keys[n++] = key;

    }

    public UnorderedQueue(int capacity) {
        n = capacity;
        keys = (Key[]) new Object[capacity];
    }

    @Override
    public Key deleteMax() {
        // TODO Auto-generated method stub
        Key max = keys[0];
        for(int i = 0; i < keys.length; i++) {
            if(max.compareTo(keys[i]) < 0){
                max = keys[i];
            }
            swap(keys, i, n - 1);
            n--;
        }
        return max;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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

    public static void main(String[] args) {
        
    }
}
