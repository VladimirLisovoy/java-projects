package ua.lisovoy.data_structure.map;

/**
 * Created by vladimir on 02.12.16.
 */
public interface Map {

    Object put(Object key, Object value);

    Object get(Object key);

    boolean containsKey(Object key);

    Object putIfAbsent(Object key, Object value);

    int size();

    Object remove(Object key);
}
