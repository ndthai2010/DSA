package src.queue;

public class LinkedListQueue<E> implements Queue<E> {

    class Node{
        E element;
        Node next;
    }

    private Node top = null;
    private Node bottom = null;
    private int n = 0;

    @Override
    public void enqueue(E element) {
        // TODO Auto-generated method stub
        if (top == null || bottom == null) {
            Node node = new Node();
            node.element = element;
            top = bottom = node;
        }else{
            Node node = new Node();
            node.element = element;
            bottom.next = bottom;
            bottom = node;
        }
        n++;
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        if (top == null) {
            n = 0;
            return null;
        }else{
            E element = top.element;
            top = top.next;
            return element;
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return top == null;
    }

    
    
}
