package ua.lisovoy.data_structure.list;

/**
 * Created by vladimir on 11/28/2016.
 */
public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public void validateIndex(int index) {
        if (index < 0 || index >= size) {
            String msg = "Incorrect index -> " + index +
                    " , index should be between 0 and " + size;
            throw new IllegalArgumentException(msg);
        }
    }

    public void validateAddIndex(int index) {
        if (index < 0 || index > size) {
            String msg = "Incorrect index -> " + index +
                    " , index should be between 0 and " + size;
            throw new IllegalArgumentException(msg);
        }
    }
}
