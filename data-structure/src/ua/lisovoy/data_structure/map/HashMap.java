package ua.lisovoy.data_structure.map;

import java.util.*;

/**
 * Created by vladimir on 02.12.16.
 */
public class HashMap<K, V> extends AbstractMap<K, V> {

    private final static int INITIAL_CAPACITY = 5;
    private final static int MULTIPLY_CAPACITY = 10;
    private final static double INCREASE_PERCENTAGE = 2.5;
    private ArrayList<Entry<K, V>>[] entries;

    public HashMap() {
        entries = new ArrayList[INITIAL_CAPACITY];
    }

    private Entry<K, V> getEntry(K key) {
        int index = getIndex(key);
        ArrayList<Entry<K, V>> bucket = getBucket(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    private ArrayList<Entry<K, V>> getBucket(int index) {
        return entries[index];
    }

    private int getIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return (hashCode < 0 ? Math.abs(hashCode-1) : hashCode) % entries.length;
    }


    private void extendEntries(int newCapacity) {
        ArrayList<Entry<K, V>>[] newArray = new ArrayList[newCapacity];
        for (ArrayList<Entry<K, V>> bucket : entries) {
            for (Entry<K, V> entry : bucket) {
                int index = getIndex(entry.key);
                newArray[index].add(entry);
            }
        }
        entries = newArray;
    }

    @Override
    public V put(K key, V value) {
        if (size > entries.length * MULTIPLY_CAPACITY) {
            int newCapacity = (int) (entries.length * INCREASE_PERCENTAGE);
            extendEntries(newCapacity);
        }

        int index = getIndex(key);
        ArrayList<Entry<K, V>> bucket = getBucket(index);

        if (containsKey(key)) {
            Entry<K, V> entryPrevious = getEntry(key);
            V previousValue = entryPrevious.value;
            entryPrevious.value = value;
            return previousValue;
        } else {
            if (bucket == null) {
                bucket = new ArrayList<Entry<K, V>>();
                entries[index] = bucket;
            }
            Entry<K, V> entry = new Entry<K, V>(key, value);
            bucket.add(entry);
            size++;
            return null;
        }
    }


    @Override
    public V get(K key) {
        int index = getIndex(key);
        ArrayList<Entry<K, V>> bucket = getBucket(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }


    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        ArrayList<Entry<K, V>> bucket = getBucket(index);
        if (bucket == null) {
            return false;
        }
        for (Entry<K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        if (!containsKey(key)) {
            put(key, value);
            return value;
        }
        return getEntry(key).value;
    }

    @Override
    public void putAll(HashMap map) {
        if (size < map.size) {
            extendEntries(map.size);
        }
        for (int i = 0; i < map.entries.length; i++) {
            ArrayList<Entry<K, V>> bucket = map.getBucket(i);
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }


    @Override
    public V remove(K key) {
        if (containsKey(key)) {
            int index = getIndex(key);
            ArrayList<Entry<K, V>> bucket = getBucket(index);
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).key.equals(key)) {
                    size--;
                    return bucket.remove(i).value;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "entries=" + Arrays.toString(entries) +
                '}';
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

    }


}
