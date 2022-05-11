package src.queue;

public class ArrayQueue<T> implements Queue<T>{

    private T[] queue;
    private int n;
    private int front = 0, count = 0;

    public ArrayQueue(int capacity){
        n = capacity;
        queue = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        // TODO Auto-generated method stub
        if(count < n){
            queue[front + count++] = element;
        }
    }

    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        if(count > 0){
            count--;
            return queue[front++];
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
        return count == 0;
    }

   
    
}
