package src.queue_linkedlist;

public interface Queue<T>  {
    
    public void enqueue(T data);
    public T dequeue();
    public boolean isEmpty();
    public int size();
}
