package src.stack_arraylist;

public interface Stack<E>  {
    
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public int size();
}
