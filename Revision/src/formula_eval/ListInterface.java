package src.formula_eval;

public interface ListInterface<T> extends Iterable<T> {

    void push(T value);

    T pop();

    boolean isEmpty();

}
