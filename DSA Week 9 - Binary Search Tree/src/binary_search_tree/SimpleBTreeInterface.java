package src.binary_search_tree;

public interface SimpleBTreeInterface<Key extends Comparable<Key>> extends Iterable {
    
    public void insert(Key k);
    public Key search(Key k);
    public int size();
    public boolean isEmpty();

}
