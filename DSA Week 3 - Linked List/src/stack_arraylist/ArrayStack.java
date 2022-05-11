package src.stack_arraylist;

import java.util.Arrays;

@SuppressWarnings({"unchecked", "deprecation"})
public class ArrayStack<E> implements Stack<E> {

    private E[] stack;
    private int top = 0;
    private int capacity = 100;

    public ArrayStack(){
        stack = (E[]) new Object[capacity];
    }

    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
    }


    @Override
    public void push(E element) {
        // TODO Auto-generated method stub
        if(size() >= stack.length){
            stack = Arrays.copyOf(stack, stack.length * 3 / 2);
        }
        stack[top++] = element;
        
    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        if(!isEmpty()){
            return stack[top--];
        }else{
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return top == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return top;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
}
