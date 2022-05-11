package src.queue_arraylist;

public class ArrayListQueue<E> implements Queue<E>{

    private E[] queue;
    private int n;
    private int front = 0, count = 0;

    public ArrayListQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        // TODO Auto-generated method stub
        if(count < n){
            queue[front + count] = element;
            count++;
        }
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        if(count > 0){
            count--;
            return queue[front++];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return count == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }
    
    public static void main(String[] args) {
    }
}
