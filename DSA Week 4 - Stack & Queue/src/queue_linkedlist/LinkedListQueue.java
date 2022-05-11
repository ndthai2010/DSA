package src.queue_linkedlist;

public class LinkedListQueue<T> implements Queue<T> {

    class Node {
        T data;
        Node next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    @Override
    public void enqueue(T data) {
        // TODO Auto-generated method stub
        if (top == null || bot == null) {
            Node node = new Node(data);
            top = bot = node;
        } else {
            Node node = new Node(data);
            bot.next = node;
            bot = node;
        }
        n++;
    }

    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        if (top == null || bot == null) {
            n = 0;
            return null;
        }

        T data = top.data;
        top = top.next;
        return data;
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return top == null;
    }

    @Override
    public int size() {
        int count = 0;
        Node p = top;
        while (p != null) {
            p = p.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedListQueue<String>();

        String[] data = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for (int i = 0; i < data.length; i++) {
            queue.enqueue(data[i]);
        }

        System.out.println("Size: " + queue.size());
        System.out.println(queue.dequeue() + " " + queue.dequeue());
        System.out.println("Size: " + queue.size() + "");

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        System.out.println("Size = " + queue.size());
    }
}
