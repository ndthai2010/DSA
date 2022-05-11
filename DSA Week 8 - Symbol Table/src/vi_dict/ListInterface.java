package src.vi_dict;

public interface ListInterface<T> {
    void add(T value);
    T get(int index);
    int size();
    boolean isEmpty();

}
