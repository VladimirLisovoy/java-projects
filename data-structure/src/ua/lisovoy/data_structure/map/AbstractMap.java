package ua.lisovoy.data_structure.map;

/**
 * Created by vladimir on 02.12.16.
 */
public abstract class AbstractMap<K,V> implements Map<K,V> {

    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
