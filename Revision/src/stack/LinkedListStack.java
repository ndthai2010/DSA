package src.stack;

public class LinkedListStack<E> implements Stack<E>{

    class Node{
        E element;
        Node next;

    }

    private Node head = null;
    
    @Override
    public void push(E element) {
        // TODO Auto-generated method stub
        if(head == null){
            Node node = new Node();
            node.element = element;
            this.head = node;
        }else{
            Node node = new Node();
            node.element = element;
            head = node.next;
            head = node;
        }

    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        if(head == null){
            return null;
        }else{
            E element = head.element;
            head = head.next;
            return element;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return head == null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        Node p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        return count;
    }
    
}
