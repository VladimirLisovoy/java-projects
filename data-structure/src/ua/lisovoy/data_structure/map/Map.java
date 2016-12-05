package ua.lisovoy.data_structure.map;


/**
 * Created by vladimir on 02.12.16.
 */
public interface Map<K,V> {

    V put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    V putIfAbsent(K key, V value);

    int size();

    V remove(K key);

    void putAll(HashMap entries);

    boolean isEmpty();

}
