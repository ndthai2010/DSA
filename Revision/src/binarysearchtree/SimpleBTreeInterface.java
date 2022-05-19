package src.binarysearchtree;

public interface SimpleBTreeInterface<Key extends Comparable<Key>> extends Iterable {
    
    void insert(Key key);
    Key search(Key key);
    int size();
    boolean isEmpty();

}
