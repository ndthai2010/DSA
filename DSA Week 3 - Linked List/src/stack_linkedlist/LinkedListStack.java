package src.stack_linkedlist;

public class LinkedListStack<E> implements Stack<E> {

    class Node{
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node stack = null;

    @Override
    public void push(E element) {
        // TODO Auto-generated method stub
        if(stack == null) {
            Node node = new Node(element);
            stack = node;
        }else{
            Node node = new Node(element);
            node.next = stack;
            stack = node;
        }
    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        if(stack == null){
            return null;
        }else{
            E element = stack.element;
            stack = stack.next;
            return element;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return stack == null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        Node p = stack; 
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
