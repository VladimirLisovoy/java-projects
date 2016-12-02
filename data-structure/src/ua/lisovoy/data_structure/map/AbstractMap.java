package ua.lisovoy.data_structure.map;

/**
 * Created by vladimir on 02.12.16.
 */
public abstract class AbstractMap implements Map{

    protected int size;

    @Override
    public int size() {
        return size;
    }
}
