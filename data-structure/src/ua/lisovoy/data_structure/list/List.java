package ua.lisovoy.data_structure.list;


/**
 * Created by vladimir on 11/28/2016.
 */
public interface List extends Iterable {

    int size();

    int add(Object value);

    void add(Object value, int index);

    int indexOf(Object value);

    int lastIndexOf(Object value);

    boolean contains(Object value);

    Object set(Object value, int index);

    void clear();

    Object get(int index);

    void remove(int index);

}
