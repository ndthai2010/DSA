package src.priority_queue;

public interface MaxPriorityQueue<Key extends Comparable<Key>> {
    public void insert(Key key);
    public Key deleteMax();
    public boolean isEmpty();
    public int size();
}
