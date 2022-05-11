package src.unordered_symbol_table;

public abstract class AbstractSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

    @Override
    public boolean contains(Key key) {
        // TODO Auto-generated method stub
        return get(key) != null;
    }

    @Override
    public void delete(Key key) {
        // TODO Auto-generated method stub
        put(key, null);
    }
    
}
