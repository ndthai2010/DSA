package src.formula_eval;

import java.util.Iterator;

public class LinkedListStack<T> implements StackInterface<T> {

    class Node {
        T element;
        Node next;
    }

    Node stack = null;

    @Override
    public void push(T element) {
        // TODO Auto-generated method stub
        Node node = new Node();
        node.element = element;
        node.next = stack;
        stack = node;

    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if(stack == null){
            return null;
        }
        T data = stack.element;
        stack = stack.next;
        return data;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }

    class StackIterator implements Iterator<T> {

        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentNode != null;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            T data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

}
