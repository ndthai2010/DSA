package src.stack_linkedlist;

public interface Stack<E> {
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public int size();
}
