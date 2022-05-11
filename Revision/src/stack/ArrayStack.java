package src.stack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {

    private E[] array;
    private int head = 0;
    private int capacity = 1000;

    @Override
    public void push(E element) {
        // TODO Auto-generated method stub
        if(size() >= array.length){
            array = Arrays.copyOf(array, array.length * 3 / 2);
        }

        array[head++] = element;
    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        if(array != null){
            return array[head--];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return head == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return head;
    }

}