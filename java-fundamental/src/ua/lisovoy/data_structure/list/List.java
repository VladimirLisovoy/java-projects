package ua.lisovoy.data_structure.list;


/**
 * Created by vladimir on 11/28/2016.
 */
public interface List<E> extends Iterable {

    int size();

    int add(E value);

    void add(E value, int index);

    int indexOf(E value);

    int lastIndexOf(E value);

    boolean contains(E value);

    E set(E value, int index);

    void clear();

    E get(int index);

    void remove(int index);

}
